import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LinkedLExp {

    public static void main (String [] args) throws IOException {
        LinkedList<String> Dictionary = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader("Fixed/unsorteddict.txt"));
        String line = reader.readLine();
        Dictionary.add(line);
        line = reader.readLine();


        boolean checked = false;

        if (Dictionary.size() > 10) {

            int size = Dictionary.size();

            for (int i = 1; i<6; i++) {

                int half = size / 2 * i;
                System.out.println(Dictionary.get(half));
            }


        }

        {// given that checked is false if letter of string one is smaller in alphabetical order




            while (checked = false)
            {

            }
        }
    }
}
