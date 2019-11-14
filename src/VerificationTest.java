import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class VerificationTest {

    public static void TestMenu(LinkedList<String> Dictionary) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("              TEST                 ");
            System.out.println("===================================");
            System.out.println("1. Type 'Short' if you want to do a short test for your word.");
            System.out.println("2. Type 'Long' if you want to do the longer test.");
            System.out.println("3. Type 'Exit' if you want to go back to the General Menu.");
            System.out.println("4. Type 'Help' if you want some help.");
            System.out.println("Your input: ");
            String token = scan.nextLine();
            scan.reset();

            if (token.equalsIgnoreCase("short")) {
                System.out.println("Short Test Initialized...");
                System.out.println("Introduce your word: ");
                String word = scan.nextLine();
                scan.reset();
                if (Diccionario.contains(StringUtils.capitalize(word))) {
                    word = StringUtils.capitalize(word);
                    ShortTest(Diccionario, word);
                } else if (Diccionario.contains(StringUtils.decapitalize(word))){
                    word = StringUtils.decapitalize(word);
                    ShortTest(Diccionario, word);
                }else{
                    System.out.println("The word introduced is not contained in the txt file.");
                    System.out.println("Try again!");
                }

            } else if (token.equalsIgnoreCase("Long")) {
                System.out.println("Long Test Initialized...");
                System.out.println("Introduce your word: ");
                String word = scan.nextLine();
                scan.reset();
                if (Diccionario.contains(StringUtils.capitalize(word))) {
                    word = StringUtils.capitalize(word);
                    LongTest(Diccionario, word);
                } else if (Diccionario.contains(StringUtils.decapitalize(word))){
                    word = StringUtils.decapitalize(word);
                    LongTest(Diccionario, word);
                }else{
                    System.out.println("The word introduced is not contained in the txt file.");
                    System.out.println("Try again!");
                }

            } else if (token.equalsIgnoreCase("Exit")) {
                flag = false;
            } else if (token.equalsIgnoreCase("Help")) {
                System.out.println();
                System.out.println();
                System.out.println("a) Short test compares alphabetically the word introduced with 100 random words of the txt file.");
                System.out.println("b) Long test compares the word with every word contained in the txt file.");
                System.out.println();
                System.out.println();
            } else {
                System.out.println("Error 505: Introduced token not valid.");
            }
        }


    }

    public static void ShortTest(LinkedList<String> Dictionary, String word) {
        System.out.println();
        System.out.println();
        System.out.println("           SHORT TEST           ");
        System.out.println("================================");
        System.out.println("Generating random numbers...");
        for (int i = 0; i <= 100; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, Dictionary.size() - 1);
            int x = word.compareToIgnoreCase(Dictionary.get(random));
            String token = Dictionary.get(random);
            if (x < 0) {
                if (Dictionary.indexOf(word) < Dictionary.indexOf(token)) {
                    System.out.println(i + "." + word.toUpperCase() + " goes before " + Dictionary.get(random).toUpperCase() + ": YES");
                } else {
                    System.out.println(i + "." + word.toUpperCase() + " goes before " + Dictionary.get(random).toUpperCase() + ": NO");
                    System.out.println("CLOSING TEST, WORD IS NOT CORRECTLY ORDERED.");
                    break;
                }
            } else if (x > 0) {
                if (Dictionary.indexOf(word) > Dictionary.indexOf(token)) {
                    System.out.println(i + "." + word.toUpperCase() + " goes after " + Dictionary.get(random).toUpperCase() + ": YES");
                } else {
                    System.out.println(i + "." + word.toUpperCase() + " goes after " + Dictionary.get(random).toUpperCase() + ": NO");
                }
            }
        }
    }

    public static void LongTest(LinkedList<String> Dictionary, String word) {
        int testruncounter = 1;
        System.out.println();
        System.out.println();
        System.out.println("           LONG TEST           ");
        System.out.println("===============================");
        System.out.println("Generating random numbers...");
        ListIterator<String> iterator = Dictionary.listIterator();
        while (iterator.hasNext()) {
            String token = iterator.next();
            int x = word.compareToIgnoreCase(token);
            if (x < 0) {
                if (Dictionary.indexOf(word) < Dictionary.indexOf(token)) {
                    System.out.println(i + "." + word.toUpperCase() + " goes before " + token.toUpperCase() + ": YES");
                } else {
                    System.out.println(i + "." + word.toUpperCase() + " goes before " + token.toUpperCase() + ": NO");
                    System.out.println("CLOSING TEST, WORD IS NOT CORRECTLY ORDERED.");
                    break;
                }
            } else if (x > 0) {
                if (Dictionary.indexOf(word) > Dictionary.indexOf(token)) {
                    System.out.println(i + "." + word.toUpperCase() + " goes after " + token.toUpperCase() + ": YES");
                } else {
                    System.out.println(i + "." + word.toUpperCase() + " goes after " + token.toUpperCase() + ": NO");
                    System.out.println("CLOSING TEST, WORD IS NOT CORRECTLY ORDERED.");
                    break;
                }
            }
            testruncounter++;
        }
    }
}
