import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
    Memory mem = new Memory();

    /**
     * It reads a file and returns an ArrayList of Strings
     * 
     * @param path The path to the file you want to read.
     * @return The file is being returned.
     */
    public ArrayList<String> read(String path) throws Exception {
        ArrayList<String> file = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    file.add(line);
                    line = reader.readLine();
                }
                reader.close();
                return file;
            } catch (Exception e) {
                throw new Exception();
            }

    }

    /**
     * It takes a file and a scanner as parameters, and then it executes the code in the file
     * 
     * @param file ArrayList of strings, each string is a line of code
     * @param in Scanner
     */
    public void execute(ArrayList<String> file, Scanner in) {
        //System.out.println(file);

        for (String s: file) {
            s = s.replaceAll("[()]", "");
            //System.out.println(s);

            String[] words;
            words = s.split(" ");

            switch (words[0]) {
                case "print":
                    String toPrint = "";
                    ArrayList<String> wordsToPrint = new ArrayList<>();
                    for (int i = 1; i < words.length; i++) {
                        words[i] = words[i].replace("\"", "");
                        wordsToPrint.add(words[i]);
                    }
                    toPrint = String.join(" ", wordsToPrint);
                    System.out.println(toPrint);
                    break;
                case "defvar":
                    String[] variable = {words[1], "0"};
                    mem.addMemory(variable);
                    break;
                case "setq":
                    if (words[2].equals("read")) {
                        boolean f1 = true;
                        while (f1) {
                            String value = in.nextLine();
                            if (value.matches("^[0-9]+$")) {
                                String[] vars = {words[1], value};
                                mem.addMemory(vars);
                                f1 = false;
                            } else {
                                System.out.println("Ingrese un valor apropiado.");
                            }
                        }
                    } else {
                        String[] vars = {words[1], words[2]};
                        mem.addMemory(vars);
                    }
                    break;
            }

        }
    }

}
