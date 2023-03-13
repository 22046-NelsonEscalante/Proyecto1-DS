public class Printer {

    private String s;
    
    // Printing the value of s.
    public Printer() {
        System.out.println(s);
    }

    /**
     * This function takes a string as an argument and sets the value of the string s to the value of
     * the string passed in as an argument
     * 
     * @param s The string to print
     */
    public void setPrint(String s) {
        this.s = s;
    }

    /**
     * This function returns the string s
     * 
     * @return The string s is being returned.
     */
    public String getPrint() {
        return s;
    }
}
