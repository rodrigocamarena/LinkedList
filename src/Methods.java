import java.io.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class Methods {

    public static void BufferedReader (LinkedList<String> Dictionary, HashMap<Character, Integer>Alphabet) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Fixed/unsorteddict3.txt"));
        String line = reader.readLine();
        AlphabetCounter(line, Alphabet);
        SaveLastPosition(line, Dictionary);
        line = reader.readLine();
        AlphabetCounter(line, Alphabet);
        while(line != null){
            if(line.compareToIgnoreCase((Dictionary.get(Dictionary.size()-1))) > 0){ 
                SaveLastPosition(line, Dictionary);
            }else{
                int position = CheckOrder(line, Dictionary, Alphabet);
                FillingMethod(line, position, Dictionary);
            }
            line = reader.readLine();
            if(line!=null){
                AlphabetCounter(line, Alphabet);
            }
        }
    }

    public static int CheckOrder (String line, LinkedList<String> Dictionary, HashMap<Character, Integer>Alphabet){
        int ordervalue = 0;
        int position = AlphabetPosition(line, Alphabet);
        ListIterator<String> iterator = Dictionary.listIterator(position);
        while(iterator.hasNext()){
            String value = iterator.next();
            if(line.compareToIgnoreCase(value) < 0){
                ordervalue = Dictionary.indexOf(value);
                break;
            }
        }
        return ordervalue;
    }

    public static void FillingMethod (String line, int position, LinkedList<String>Dictionary){
        String word = Dictionary.get(position);
        Dictionary.set(position, line);
        ListIterator<String> iterator = Dictionary.listIterator(position+1);
        if(position +1 == Dictionary.size()){
            SaveLastPosition(word, Dictionary);
        }else{
            while(iterator.hasNext()){
                position++;
                line = iterator.next();
                Dictionary.set(position, word);
                word = line;

                if((position + 1) == Dictionary.size()){
                    SaveLastPosition(word, Dictionary);
                    break;
                }
            }
        }
    }
    public static void SaveLastPosition (String line, LinkedList<String>Dictionary){
        Dictionary.add(line);
    }
    public static void PrintLinkedList (LinkedList<String>Dictionary){
        ListIterator<String> iterator = Dictionary.listIterator();
        int i = 1;
        while(iterator.hasNext()){
            System.out.println(i+"."+iterator.next());
            i++;
        }
    }

    public static void Create_Filetxt(LinkedList<String> Dictionary) throws IOException {
        FileWriter writer = new FileWriter("Fixed/sorteddict.txt");
        ListIterator<String> iterator = Dictionary.listIterator();
        while(iterator.hasNext()){
            String line = iterator.next();
            writer.write(line);
            writer.write("\n");
            writer.flush();
        }
    }

    public static void InitializeAlphabet (HashMap<Character, Integer> Alphabet){
        char alphabetchar = 'a';
        for(int i=0; i<26; i++){
            Alphabet.put(c, 0);
            alphabetchar++;
        }


    }

    public static void AlphabetCounter (String line, HashMap<Character, Integer> Alphabet){
        char []letter = line.toCharArray();
        for(Character key : Alphabet.keySet()){
            if(key.equals(Character.toLowerCase(letter[0]))){
                Alphabet.replace(key, (Alphabet.get(key)+1));
                break;
            }
        }
    }

    public static int AlphabetPosition (String line, HashMap<Character, Integer>Alphabet){
        char []letter = line.toCharArray();
        int x = 0;
        for (Character key : Alphabet.keySet()){
            if(key.equals(Character.toLowerCase(letter[0]))){
                if(x!=0){
                    x = x - 1;
                }
                break;
            }
            x = Alphabet.get(key) + x;
        }
        return x;
    }

}
