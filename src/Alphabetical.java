import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Alphabetical {

    public static void Alphabetic_method(LinkedList <String>Dictionary) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Fixed/unsorteddict.txt"));
        boolean flag = true;
        String line = reader.readLine();
        Dictionary.add(line);
        line = reader.readLine();
        while (line != null) {
            for(int i = 0; i<Dictionary.size();i++){
                if(line.compareTo(Dictionary.get(i)) < 0){
                    Filling_method(Dictionary, i, line);
                    flag = false;
                    break;
                }
            }
            if(flag){
                Dictionary.add(line);
            }
            line = reader.readLine();
            flag = true;
        }

        Print_method(Dictionary);
    }

    public static void Filling_method(LinkedList<String> Dictionary, int index, String line){
        String []array = new String [Dictionary.size()+1];
        int num = 0;
        int x = 0;
        for(int j=0; j<Dictionary.size()+1;j++){
            if(index == j){
                array[j] = line;
            }else{
                array[j] = Dictionary.get(x);
                x++;
            }
        }
        while(Dictionary.size() > num){
            Dictionary.remove(num);
        }

        for(int i = 0; i<array.length;i++){
            Dictionary.add(i, array[i]);
        }


    }

    public static void Print_method(LinkedList<String> Dictionary){
            for (String e : Dictionary){
                System.out.println(e);
            }
    }
}
