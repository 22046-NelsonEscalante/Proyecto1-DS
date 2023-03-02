public class Calculator {

    private int op1;
    private int op2;
    private String op;
    private int res;

    public Calculator() {
        
        calculate(op1, op2, op);
        
    }

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