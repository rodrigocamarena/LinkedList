public class Amaurytrial<i> {


    public static boolean checkagainstword(String input1, String input2) {

        boolean checked = false;

        //while (i>input1.length() && i>input2.length() )
        for (int i = 0; i < input1.length() && i < input2.length(); i++) {

            if (input1.charAt(i) == input2.charAt(i)) {
                checked = true;
                System.out.println("the letter is the same");
                

            }

            if (input1.charAt(i)>input2.charAt(i)){
                System.out.println("not the same");
                checked = false;
                break;
            }

        }
        return checked;
    }

        public static void main (String [] args)
        {
            System.out.println(Amaurytrial.checkagainstword("yeehsbnakkis", "yeehbjsnjsu"));

    }
}