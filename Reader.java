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
    public void execute(ArrayList<String> file, Scanner in, HashMap<String, String> parameters) {

        if (parameters != null) {
            for (String k : parameters.keySet()) {
                for (String preReplaceLine : file) {
                    preReplaceLine.replaceAll(k, parameters.get(k));
                }
            }
        }


        int index;
        //System.out.println(file);

        for (String s: file) {
            index = file.indexOf(s);
            String noParentheses = s.replaceAll("[()]", "");
            //System.out.println(s);

            String[] words;
            String[] noParenthesesWords;
            words = s.split(" ");
            noParenthesesWords = noParentheses.split(" ");

            switch (noParenthesesWords[0]) {
                case "print":
                    String toPrint = "";
                    ArrayList<String> wordsToPrint = new ArrayList<>();
                    for (int i = 1; i < noParenthesesWords.length; i++) {
                        noParenthesesWords[i] = noParenthesesWords[i].replace("\"", "");
                        wordsToPrint.add(noParenthesesWords[i]);
                    }
                    toPrint = String.join(" ", wordsToPrint);
                    System.out.println(toPrint);
                    break;
                case "defvar":
                    String[] variable = {noParenthesesWords[1], "0"};
                    mem.addMemory(variable);
                    break;
                case "setq":
                    if (noParenthesesWords[2].equals("read")) {
                        boolean f1 = true;
                        while (f1) {
                            String value = in.nextLine();
                            if (value.matches("^[0-9]+$")) {
                                String[] vars = {noParenthesesWords[1], value};
                                mem.addMemory(vars);
                                f1 = false;
                            } else {
                                System.out.println("Ingrese un valor apropiado.");
                            }
                        }
                    } else {
                        String[] vars = {noParenthesesWords[1], noParenthesesWords[2]};
                        mem.addMemory(vars);
                    }
                    break;
                case "defun":
                    String name = noParenthesesWords[1];
                    ArrayList<String> params = new ArrayList<>();
                    ArrayList<String> lines = new ArrayList<>();
                    String line = "";
                    for (int i = 2; i < noParenthesesWords.length; i++) {
                        params.add(noParenthesesWords[i]);
                    }

                    int tempIndex = index++;
                    line = file.get(tempIndex);

                    while (!line.equals(")")) {
                        lines.add(line);
                        file.remove(tempIndex);
                        tempIndex++;
                    }

                    mem.addFunction(name, params, lines);

                    break;
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
