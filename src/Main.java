import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        boolean flag = true;
        int flagcounter = 1;
        HashMap<Character, Integer> Alphabet = new HashMap();
        Methods.InitializeAlphabet(Alphabet);
        LinkedList <String> Dictionary = new LinkedList<>();
        Methods.BufferedReader(Dictionary, Alphabet);
        Methods.PrintLinkedList(Dictionary);
        Methods.Create_Filetxt(Dictionary);
        while(flag){
            flagcounter++;
            String token = Menu.PrintMenu(Dictionary);
            if(token.equalsIgnoreCase("Exit") || flagcounter == 11){
                flag = false;
            }
        }




    }
}
