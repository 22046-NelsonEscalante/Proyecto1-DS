import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Reader reader = new Reader();
        String response;

        while (true) {

            response = in.nextLine();
            
            reader.read(response);

            if (response.equals("exit")) {
                in.close();
                System.exit(0);
            }

        }
    }
}
