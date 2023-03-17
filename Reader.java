import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Reader {
    Memory mem = new Memory();

    /**
     * It reads a file and returns an ArrayList of Strings
     * 
     * @param path The path to the file you want to read.
     * @return The file is being returned.
     */
    public ArrayList<String> read(String path) throws Exception {
        ArrayList<String> file = new ArrayList<>(); // Utilización de ArrayList de String. Se utilizó con la finalidad de guardar fácilmente los datos de un archivo.

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
     * It returns true if the input is a number or a boolean, and false otherwise
     * 
     * @param input The string to be checked
     */
    public boolean atom(String input) {

        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {

        }

        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return true;
        }

        return false;
    }

    /**
     * It takes a file and a scanner as parameters, and then it executes the code in the file
     * 
     * @param file ArrayList of strings, each string is a line of code
     * @param in Scanner
     */
    public void execute(ArrayList<String> file, Scanner in, HashMap<String, String> parameters) {
        ArrayList<Integer> toSkip = new ArrayList<>(); // Utilización de ArrayList de Enteros para almacenar de una forma sencilla qué datos se omitirán.
        Calculator calc = new Calculator();
        Memory memo2 = new Memory();


        if (parameters != null) {
            for (String k : parameters.keySet()) {
                int preIndx = 0;
                for (String preReplaceLine : file) {
                    String value = parameters.get(k);
                    String replacedLine = preReplaceLine.replaceAll(k, value);
                    file.set(preIndx, replacedLine);
                    preIndx++;
                }
            }
        }

        int index;
        //System.out.println(file);

        // Reading the file and executing the code.
        for (String s: file) {
            index = file.indexOf(s);
            String noParentheses = s.replaceAll("[()]", "");
            noParentheses = noParentheses.trim();
            //System.out.println(s);

            String[] noParenthesesWords; //Utilización de una Lista de String para guardar palabras sin paréntesis. Se utilizó por la facilidad la acceder a sus elementos.
            noParenthesesWords = noParentheses.split(" ");
            s.split(" ");

            if (toSkip.contains(index)) {
                noParenthesesWords[0] = "Skip";
            }

            // Reading the file and executing the code.
            switch (noParenthesesWords[0]) {
                case "print":
                    String toPrint = "";
                    ArrayList<String> wordsToPrint = new ArrayList<>(); // Utilización de un ArrayList de String que guarda los datos que serán mostrados. Se utilizó por la facilidad a la hora de agregar elementos.
                    for (int i = 1; i < noParenthesesWords.length; i++) {
                        noParenthesesWords[i] = noParenthesesWords[i].replace("\"", "");
                        wordsToPrint.add(noParenthesesWords[i]);
                    }
                    toPrint = String.join(" ", wordsToPrint);
                    System.out.println(toPrint);
                    break;

                case "defvar":
                    String[] variable = {noParenthesesWords[1], "0"}; // Utilización de Lista de String que almacena el valor de las variables. Se utilizó para acceder fácilmente a los elementos que serán almacenados en los HashMaps.
                    mem.addMemory(variable);
                    break;

                case "setq":
                    if (noParenthesesWords[2].equals("read")) {
                        boolean f1 = true;
                        while (f1) {
                            String value = in.nextLine();
                            if (value.matches("^[0-9]+$")) {
                                String[] vars = {noParenthesesWords[1], value}; // Utilización de Lista de String que almacena el valor de las variables. Se utilizó para acceder fácilmente a los elementos que serán almacenados en los HashMaps.
                                mem.addMemory(vars);
                                f1 = false;
                            } else {
                                System.out.println("Ingrese un valor apropiado.");
                            }
                        }
                    } else {
                        String[] vars = {noParenthesesWords[1], noParenthesesWords[2]}; // Utilización de Lista de String que almacena el valor de las variables. Se utilizó para acceder fácilmente a los elementos que serán almacenados en los HashMaps.
                        mem.addMemory(vars);
                    }
                    break;

                case "defun":
                    String name = noParenthesesWords[1];
                    ArrayList<String> params = new ArrayList<>(); // Utilización de ArrayLists de String para añadir los nombres y valoresa de las funciones a los Hashmaps.
                    ArrayList<String> lines = new ArrayList<>();
                    String line = "";
                    for (int i = 2; i < noParenthesesWords.length; i++) {
                        params.add(noParenthesesWords[i]);
                    }

                    int tempIndex = index + 1;
                    
                    line = file.get(tempIndex);

                    while (!line.equals(")")) {
                        line = file.get(tempIndex);
                        lines.add(line);
                        toSkip.add(tempIndex);
                        tempIndex++;
                    }

                    mem.addFunction(name, params, lines);

                    break;

                case "format":
                    if (noParenthesesWords[1].equals("t")) {
                        String toPrint2 = "";
                        String[] noQuotes; // Utilización de listas de String para almacenar los textos que se mostrarán al usuario. Se utilizaron por la facilidad de acceder a sus elementos por índices.
                        String[] noQuotes2;
                        noQuotes = s.split("\"");
                        noQuotes2 = noQuotes[1].split(" ");
                        for (String aWord : noQuotes2) {
                            if (aWord.equals("~D")) {
                                toPrint2 = toPrint2 + calc.calculate(noQuotes[2]);
                            } else {
                                toPrint2 = toPrint2 + aWord + " ";
                            }
                        }
                        System.out.println(toPrint2); 
                    }
                    break;

                case "atom":
                    System.out.println(atom(noParenthesesWords[1])); 

                    break;
                

                case "Skip":
                    break;

                case "if":
                    int ifTempIndx = 0;
                    int ifTempIndx2 = 0;
                    if (noParenthesesWords[1] == "=") {
                        if (noParenthesesWords[2] == noParenthesesWords[3]) {
                            ifTempIndx = index + 1;
                            toSkip.add(ifTempIndx);
                            String toReturn = "" + file.get(ifTempIndx);
                        } else {
                            ifTempIndx2 = index + 2;
                            toSkip.add(ifTempIndx2);
                            
                        }
                    }

                default:
                    if (mem.getMapFunc().keySet().contains(noParenthesesWords[0])) {
                        Function funcToDo = mem.getFunc(noParenthesesWords[0]);
                        ArrayList<String> linesToDo = funcToDo.getLines();
                        ArrayList<String> paramsToUse = funcToDo.getParams();
                        HashMap<String, String> paramMap = new HashMap<>();
                        int counter = 1;
                        for (String paramToUse : paramsToUse) {
                            String tempParam = noParenthesesWords[counter];
                            tempParam = "" + mem.getVal(tempParam);
                            paramMap.put(paramToUse, tempParam);
                        }
                        execute(linesToDo, in, paramMap);
                    }
                    break;
            }
        }
    }
}
