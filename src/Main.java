import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        LinkedList <String> Dictionary = new LinkedList<>();
        Alphabetical.Alphabetic_method(Dictionary);
        Alphabetical.Create_Filetxt(Dictionary);
        Alphabetical.Commands_input(Dictionary);

    }
}
