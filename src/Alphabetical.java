import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;


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
        System.out.println("List of words");
        System.out.println("==============");
            for (String e : Dictionary){
                System.out.println(e);
            }
    }

    public static void Create_Filetxt(LinkedList<String> Dictionary) throws IOException {
        FileWriter writer = new FileWriter("Fixed/sorteddict.txt");
        for (String e : Dictionary){
            writer.write(e);
            writer.write("\n");
            writer.flush();
        }
    }


    public static void Get_String (LinkedList<String>Dictionary, int index){

        if(Dictionary.size()<=index){
            System.out.println("There is no String stored in that position. Try again!");
        }else{
            System.out.println("The word of the position " + index + " is: " + Dictionary.get(index));
        }
    }

    public static void Get_index (LinkedList<String> Dictionary, String line){
        boolean flag = true;
        for (String e : Dictionary){
            if(e.equalsIgnoreCase(line)){
                System.out.println("The position of the word "+e+" is: "+ Dictionary.indexOf(e));
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        if(flag == false){
                System.out.println("-1");
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void Commands_input(LinkedList<String> Dictionary){
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            String command = Menu();
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
                    command = Menu();
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
    public static String Menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("============");
        System.out.println("1. If you want to input a String or Integer (enter y): " +
                "\n2. If you wanna exit (enter n) " +
                "\nYour command: ");
        return in.nextLine();
    }
}
