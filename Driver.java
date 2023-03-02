import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        System.out.println("Menú");
        System.out.print("Escribe la opción que quieras realizar: ");
        Scanner in = new Scanner(System.in);

        while (true) {
            

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
