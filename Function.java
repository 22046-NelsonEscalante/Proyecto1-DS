import java.util.ArrayList;

public class Function {
    
    String name;
    ArrayList<String> params;
    ArrayList<String> lines;

    public Function(String name, ArrayList<String> params, ArrayList<String> lines) {
        setName(name);
        setParams(params);
        setLines(lines);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
}
