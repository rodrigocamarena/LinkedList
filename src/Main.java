import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        int i = 0;
        Scanner in = new Scanner(System.in);
        HashMap<Integer, String> Dictionary = new HashMap<Integer, String>();
        BufferedReader reader = new BufferedReader(new FileReader("unsorteddict.txt"));
        String line = reader.readLine();
        while (line != null) {
            Dictionary.put(i, line);
            i++;
            line = reader.readLine();
        }
        /**
         * while(in.hasNext()){
         *             int id = in.nextInt();
         *             // Write code here
         *             if(Dictionary.containsKey(id)){
         *                 System.out.println(id + " = "+ Dictionary.get(id));
         *             }else{
         *                 System.out.println("Not found");
         *             }
         *         }
         */
        String[] word = new String[0];
        for (Map.Entry<Integer, String> entry : Dictionary.entrySet()) {
            word = new String[Dictionary.size()];
            for (int j = 0; j < Dictionary.size(); j++) {
                word[i] = entry.getValue();
            }

        }

        for(int x=0; x<word.length; x++){
                if (word[x].compareTo(word[x+1])>0) {
                    String temp = word[x];
                    word[x] = word[x+1];
                    word[x+1] = temp;
                }
        }

        System.out.print("Names in Sorted Order:");
        for (int y = 0; y < word.length - 1; y++)
        {
            System.out.print(word[y]);
        }


    }
}

