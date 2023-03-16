import java.util.ArrayList;
import java.util.HashMap;

public class Memory {
    private HashMap<String, Integer> vars = new HashMap<>();
    private HashMap<String, Function> functions = new HashMap<>();
    
    /**
     * This function returns a HashMap of the variables in the current scope
     * 
     * @return A HashMap of String, Integer
     */
    public HashMap<String, Integer> getMapVars() {
        return this.vars;
    }

    public HashMap<String, Function> getMapFunc() {
        return this.functions;
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

    public void addFunction(String name, ArrayList<String> params, ArrayList<String> lines) {
        functions.put(name, new Function(name, params, lines));
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

    public Function getFunc(String name) {
        return functions.get(name);
    }

}
