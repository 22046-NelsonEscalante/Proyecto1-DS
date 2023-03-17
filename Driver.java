import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Reader reader = new Reader();
        ArrayList<String> fileContent = new ArrayList<>();
        String response;
        int i = 0;

        //Calculator myCalculator = new Calculator();
        //myCalculator.calculate("( - ( + 35 5 ) 4 )");

        // A loop that will run forever until the user types "exit"
        while (true) {
            if(i > 0){
                System.out.println("'execute' para ejecutar el programa, 'exit' para salir");
                response = in.nextLine();
            }
            else {
                System.out.println("Nombre del archivo .lsp: ");
                response = in.nextLine();
            }
            i++;
            
            if (response.equals("exit")) {
                in.close();
                System.exit(0);
            } else if (response.equals("execute")) {
                reader.execute(fileContent, in, null);
            } else {
                try {
                    fileContent = reader.read(response);
                } catch (Exception e) {
                    System.out.println("Archivo no encontrado.");
                    i--;
                }
            }

        }
    }
}
