import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    public String input;
    public int position;

    public Menu(String input, int position) {
        this.input = input;
        this.position = position;
    }

    public static String PrintMenu(LinkedList<String> Diccionario) {
        String token = "";

        System.out.println("              MENU               ");
        System.out.println("==================================");
        System.out.println("1. Introduce a word to find out its position index on the txt file. ");
        System.out.println("2. Introduce the position of the word.");
        System.out.println("3. Introduce the integer '-1' in order to run an alphabetical test with a word.");
        System.out.println("3. Introduce 'Help' if you want some advice.");
        System.out.println("4. Introduce 'EXIT' if you want to close the program.");
        System.out.println("Your input: ");

        //Initializing scanner
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int input = sc.nextInt();
            System.out.println("You entered : " + input);
            IntegerInput(input, Diccionario);

        } else {
            String word = sc.nextLine();
            sc.reset();
            System.out.println("You entered : " + word);
            token = word;
            if (word.equalsIgnoreCase("Help")) {
                System.out.println("a) If u introduce a non-existent position the program will return -1.");
                System.out.println("b) The menu will only be displayed at a maximum of 10 times.");
                System.out.println();
                System.out.println();
            } else {
                StringInput(word, Diccionario);
            }
        }

        return token;
    }

    public static void IntegerInput(int input, LinkedList<String> Diccionario) {
        if (input < -1 || input > Diccionario.size() - 1) {
            System.out.println("Introduced Position does not exist. Must be GREATER than 0 and lower than " + (Diccionario.size() - 1));
        } else if (input == -1) {
            System.out.println("Initializing test...");
            VerificationTest.TestMenu(Diccionario);

        } else {
            String line = Diccionario.get(input - 1);
            System.out.println("The word is: " + line);
        }
    }

    public static void StringInput(String word, LinkedList<String> Diccionario) {
        if (Diccionario.contains(word)) {
            System.out.println("The position of " + word + " in the txt file is: " + (Diccionario.indexOf(word) + 1));
            System.out.println("The position of " + word + " in the Dictionary file is: " + Diccionario.indexOf(word));
        } else if (word.equalsIgnoreCase("exit")) {
            System.out.println("CLosing Program...");
        } else {
            System.out.println("-1");
        }
    }
}
