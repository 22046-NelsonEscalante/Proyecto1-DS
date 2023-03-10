import java.util.HashMap;

public class Memory {
    private HashMap<String, Integer> vars = new HashMap<>();

    public HashMap<String, Integer> getMap() {
        return this.vars;
    }

    public void addMemory(String[] input) {
        vars.put(input[0], Integer.parseInt(input[1]));
    }

    public int getVal(String variable) {
        return vars.get(variable);
    }
}
