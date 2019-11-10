public class Othertrial {

    public static boolean checkagainstword(String input1, String input2) {

        boolean checked = false;

        //while (i>input1.length() && i>input2.length() )
        for (int i = 0; i < input1.length() && i < input2.length(); i++) {

            if (input1.charAt(i) > input2.charAt(i)) {
                checked = true;
                System.out.println("the letter further in alphabetical order");


            }

            if (input1.charAt(i) < input2.charAt(i)) {
                System.out.println("letter is less in alphabetical order");
                checked = false;
                break;
            }

        }
        return checked;
    }
    public static void main (String [] args)
    {

        System.out.println(checkagainstword("dhadwazwa","dhadwaiwp"));
    }
}