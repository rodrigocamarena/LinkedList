import sun.awt.image.ImageWatched;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        LinkedList <String> Dictionary = new LinkedList<>();
        Alphabetical.Alphabetic_method(Dictionary);
        Alphabetical.Create_Filetxt(Dictionary);

        while(flag){
            System.out.println("Do u wanna get any String or Index from the Dictionary?(y/n):  ");
            String command = in.nextLine();
            if(command.equalsIgnoreCase("y")){
                for(int i=0; i<10; i++){
                    System.out.println("Introduce the String or Index: ");
                    String line = in.nextLine();
                    boolean token = Alphabetical.isNumeric(line);
                    if(token) {
                        int x = Integer.parseInt(line);
                        System.out.println("You entered : " + x);
                        Alphabetical.Get_String(Dictionary, x);
                    }else{
                        System.out.println("You entered: " + line);
                        Alphabetical.Get_index(Dictionary, line);
                    }
                }
            }else if(command.equalsIgnoreCase("n")){
                System.out.println("Closing Program.");
                flag = false;
            }else{
                System.out.println("Error, Please introduce a correct command.");
            }
            flag = false;
        }

    }
}
