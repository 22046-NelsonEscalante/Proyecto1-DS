public class Calculator {

    private int op1;
    private int op2;
    private String op;
    private int res;

    // Calling the calculate method.
    public Calculator() {
        
        calculate(op1, op2, op);
        
    }

    /**
     * It takes two integers and a string as input, and returns an integer
     * 
     * @param op1 The first operand
     * @param op2 The second operand
     * @param op the operator
     * @return The result of the calculation.
     */
    int calculate(int op1, int op2, String op) {
        if(op.equals("+")) {
            res = op1 + op2;

        } else if(op.equals("-")) {
            res = op1 - op2;

        } else if(op.equals("*")) {
            res = op1 * op2;

        } else if(op.equals("/")) {
            res = op1 / op2;

        }

        return res;
    }
}