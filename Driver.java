import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Reader reader = new Reader();
        ArrayList<String> fileContent = new ArrayList<>();
        String response;

        while (true) {

            response = in.nextLine();
            
            if (response.equals("exit")) {
                in.close();
                System.exit(0);
            } else if (response.equals("execute")) {
                reader.execute(fileContent, in);
            } else {
                try {
                    fileContent = reader.read(response);
                } catch (Exception e) {
                    System.out.println("Archivo no encontrado.");
                }
            }

        }
    }
}
