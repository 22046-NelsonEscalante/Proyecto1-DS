import java.util.ArrayList;
import java.util.Stack;

public class Calculator {

    private float op1;
    private float op2;
    private String sign;
    private float res;
    private Stack<ArrayList<String>> pila = new Stack<>();
    private boolean chapuzS = false;

    public float calculate(String op) {

        try {
            String[] operandos = op.split("\\s+");
            
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
                            op1 = Float.parseFloat(evaluateArrayList.get(1));
                            op2 = Float.parseFloat(evaluateArrayList.get(2));
            
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
            
        } catch (Exception e) {
            System.out.println("Error: ingresa una expresión válida.");
            chapuzS = true;
        }
        
        if(chapuzS == false) {
            System.out.println("El resultado es: " + res);
        }

        return res;
    }
}