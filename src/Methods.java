import java.io.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class Methods {

    public static void BufferedReader (LinkedList<String> Diccionario, HashMap<Character, Integer>Alphabet) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Fixed/unsorteddict3.txt"));
        String line = reader.readLine();
        AlphabetCounter(line, Alphabet);
        SaveLastPosition(line, Diccionario);
        line = reader.readLine();
        AlphabetCounter(line, Alphabet);
        while(line != null){
            if(line.compareToIgnoreCase((Diccionario.get(Diccionario.size()-1))) > 0){ //para guardar en la ultima posicion direct.
                SaveLastPosition(line, Diccionario);
            }else{
                int position = CheckOrder(line, Diccionario, Alphabet);
                FillingMethod(line, position, Diccionario);
            }
            line = reader.readLine();
            if(line!=null){
                AlphabetCounter(line, Alphabet);
            }
        }
    }

    public static int CheckOrder (String line, LinkedList<String> Diccionario, HashMap<Character, Integer>Alphabet){
        int i = 0;
        int position = AlphabetPosition(line, Alphabet);
        ListIterator<String> itr = Diccionario.listIterator(position);
        while(itr.hasNext()){
            String value = itr.next();
            if(line.compareToIgnoreCase(value) < 0){
                i = Diccionario.indexOf(value);
                break;
            }
        }
        return i;
    }

    public static void FillingMethod (String line, int position, LinkedList<String>Diccionario){
        String palabra = Diccionario.get(position);
        Diccionario.set(position, line);
        ListIterator<String> itr = Diccionario.listIterator(position+1);
        if(position +1 == Diccionario.size()){
            SaveLastPosition(palabra, Diccionario);
        }else{
            while(itr.hasNext()){
                position++;
                line = itr.next();
                Diccionario.set(position, palabra);
                palabra = line;

                if((position + 1) == Diccionario.size()){
                    SaveLastPosition(palabra, Diccionario);
                    break;
                }
            }
        }
    }
    public static void SaveLastPosition (String line, LinkedList<String>Diccionario){
        Diccionario.add(line);
    }
    public static void PrintLinkedList (LinkedList<String>Diccionario){
        ListIterator<String> itr = Diccionario.listIterator();
        int i = 1;
        while(itr.hasNext()){
            System.out.println(i+"."+itr.next());
            i++;
        }
    }

    public static void Create_Filetxt(LinkedList<String> Diccionario) throws IOException {
        FileWriter writer = new FileWriter("Fixed/sorteddict.txt");
        ListIterator<String> itr = Diccionario.listIterator();
        while(itr.hasNext()){
            String line = itr.next();
            writer.write(line);
            writer.write("\n");
            writer.flush();
        }
    }

    public static void InitializeAlphabet (HashMap<Character, Integer> Alphabet){
        char c = 'a';
        for(int i=0; i<26; i++){
            Alphabet.put(c, 0);
            c++;
        }

        /*
                for(Character key : Alphabet.keySet()){
            System.out.println("Key is: "+key + "Value is: " + Alphabet.get(key));
        }
         */
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
