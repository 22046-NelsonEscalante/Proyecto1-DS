import java.util.ArrayList;

public class Function {
    
    String name;
    ArrayList<String> params;
    ArrayList<String> lines;

    // A constructor.
    public Function(String name, ArrayList<String> params, ArrayList<String> lines) {
        setName(name);
        setParams(params);
        setLines(lines);
    }

    /**
     * This function returns a name
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * This function sets the name of the object to the name passed in as a parameter
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function returns an ArrayList of Strings
     * 
     * @return The ArrayList of Strings
     */
    public ArrayList<String> getParams() {
        return params;
    }

    /**
     * This function sets the params variable to the params variable passed in
     * 
     * @param params The parameters of the method.
     */
    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    /**
     * This function returns an ArrayList of Strings
     * 
     * @return The lines ArrayList is being returned.
     */
    public ArrayList<String> getLines() {
        return lines;
    }

    /**
     * This function sets the lines of the file to the lines of the parameter
     * 
     * @param lines The lines of the file
     */
    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
}
