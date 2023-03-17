import java.util.ArrayList;
import java.util.Stack;

public class Calculator {

    private float op1;
    private float op2;
    private String sign;
    private float res;
    private Stack<ArrayList<String>> pila = new Stack<>();

    public float calculate(String op) {
        
        String[] operandos = op.split("");
        
        ArrayList<String> chapuz = new ArrayList<>();
        pila.push(chapuz);

        for (String string : operandos) {
                if(string.equals("(")) {

                    ArrayList<String> operacion = new ArrayList<>();


                    pila.push(operacion);

                } else {

                    if(string.equals("+")) {
                        pila.peek().add("+");
        
                    } else if(string.equals("-")) {
                        pila.peek().add("-");
        
                    } else if(string.equals("*")) {
                        pila.peek().add("*");
                    
                    } else if(string.equals("/")) {
                        pila.peek().add("/");
        
                    } else if(string.equals(")")){

                        ArrayList<String> evaluateArrayList = pila.pop();

                        sign = evaluateArrayList.get(0); 
                        op1 = Float.valueOf(evaluateArrayList.get(1));
                        op2 = Float.valueOf(evaluateArrayList.get(2));
        
                        if(sign.equals("+")) {
                            res = op1 + op2;
        
                        } else if(sign.equals("-")) {
                            res = op1 - op2;
        
                        } else if(sign.equals("*")) {
                            res = op1 * op2;
        
                        } else if(sign.equals("/")) {
                            res = op1 / op2;
        
                        }
                        
                        pila.peek().add("" + res);
                    
                    } else {
                        pila.peek().add(string);

                    }
            }
                
        }
        System.out.println("El resultado es: " + res);
        return res;
    }
}