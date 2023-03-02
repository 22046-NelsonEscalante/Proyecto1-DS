import java.util.Scanner;
import  java.lang.Runtime;

public class Driver {
    
    public static void main(String[] args) {
        System.out.println("Menú");
        System.out.print("Escribe la opción que quieras realizar: ");
        Scanner in = new Scanner(System.in);
        Runtime run = Runtime.getRuntime();

        while (true) {
            
            run.getRuntime().exec(args);

            if (writeLine(in).equals("exit")) {
                System.exit(0);
            }
        }

    }

    public static String writeLine(Scanner in) {
        String response = in.nextLine();
        return response;
    }

}
