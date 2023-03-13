import java.util.ArrayList;

import javax.swing.Spring;

public class Calculator {

    private int op1;
    private int op2;
    private String sign;
    private int res;

    public int calculate(String op) {
        
        String[] operandos = op.split("");

        for (String string : operandos) {
            if(string.equals("(")) {
                ArrayList<String> operacion = new ArrayList<>();

                for (String string2 : operandos) {

                    if(string2.equals("+")) {
                        operacion.add(string2);

                    } else if(string2.equals("-")) {
                        operacion.add(string2);

                    } else if(string2.equals("*")) {
                        operacion.add(string2);
                    
                    } else if(string2.equals("/")) {
                        operacion.add(string2);

                    } else if(string2.equals(")")){
                        op1 = Integer.parseInt(operacion.get(0));
                        
                        op2 = Integer.parseInt(operacion.get(1));
                        
                        sign = operacion.get(3);

                        operacion.remove(op1);
                        operacion.remove(op2);
                        operacion.remove(sign);

                        if(sign.equals("+")) {
                            res = op1 + op2;

                        } else if(sign.equals("-")) {
                            res = op1 - op2;

                        } else if(sign.equals("*")) {
                            res = op1 * op2;

                        } else if(sign.equals("/")) {
                            res = op1 / op2;

                        }

                    } else {
                        operacion.add(string2);

                    }
                }
            }
        }
        return res;
    }
}