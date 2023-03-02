public class Reader {

    Calculator calc = new Calculator();

    public int operate(String function, int op1, int op2, String operation) {

        int result = calc.calculate(op1, op2, operation);

        return result;
    }

}
