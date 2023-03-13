import java.util.ArrayList;
import java.util.HashMap;


public class Memory {
    private HashMap<String, Integer> vars = new HashMap<>();
    
    /**
     * This function returns a HashMap of the variables in the current scope
     * 
     * @return A HashMap of String, Integer
     */
    public HashMap<String, Integer> getMap() {
        return this.vars;
    }
    
    /**
     * It takes an array of strings, and adds the first element of the array as a key to the vars map,
     * and the second element of the array as the value
     * 
     * @param input The input string, split by spaces.
     */
    public void addMemory(String[] input) {
        vars.put(input[0], Integer.parseInt(input[1]));
    }
    
    /**
     * This function returns the value of the variable passed in as a parameter
     * 
     * @param variable The variable name
     * @return The value of the variable.
     */
    public int getVal(String variable) {
        return vars.get(variable);
    }

    private HashMap<String, ArrayList<String>> functionMap = new HashMap<>();

    /**
     * This function takes an ArrayList of Strings and a String as parameters and adds the ArrayList to
     * the functionMap HashMap with the String as the key
     * 
     * @param valueArrayList An ArrayList of Strings that contains the function's parameters.
     * @param keyString The name of the function
     */
    public void addFunction(ArrayList<String> valueArrayList, String keyString) {
        functionMap.put(keyString, valueArrayList);
    }

    /**
     * It takes a HashMap as a parameter, and prints out the key and the value of each entry in the
     * HashMap
     * 
     * @param map HashMap<String, ArrayList<String>>
     */
    public void showFunctions(HashMap<String, ArrayList<String>> map) {
        for(String string : map.keySet()) {
            System.out.println("La función " + string + " tiene los valores " + map.get(string));
        }
    }
}
