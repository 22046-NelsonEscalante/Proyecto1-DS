import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProjectTest {
    @Test
    public void testAtom() {
        Reader testFunction = new Reader();

        Assert.assertEquals(false, testFunction.atom("Atom"));
    }

    @Test
    public void testAtomFalse() {
        Reader testFunction = new Reader();

        Assert.assertEquals(false, testFunction.atom("5"));
    }

    @Test
    public void testAtomTrue() {
        Reader testFunction = new Reader();

        Assert.assertEquals(true, testFunction.atom("5 4 9"));
    }

    @Test
    public void testCalculator() {
        Calculator myCalculator = new Calculator();

        double calculate = myCalculator.calculate("( + ( / 6 3 ) ( * 2 8 ) )");
        
        Assert.assertEquals(18.0, calculate, 0.5);
    }

    @Test
    public void testSetq() {
        Reader myReader = new Reader();
        Scanner in = new Scanner(System.in);
        ArrayList<String> op = new ArrayList<>();
        op.add("(defvar v)");
        op.add("(setq v (23))");

        myReader.execute(op, in, null);

        Assert.assertEquals(23, myReader.mem.getVal("v"));
    }

    @Test
    public void testDefun() {
        Reader myReader = new Reader();
        Scanner in = new Scanner(System.in);
        ArrayList<String> op = new ArrayList<>();
        op.add("(defvar F)");
        op.add("(defun Sum (F)");
        op.add("(setq F (23))");
        op.add(")");
        op.add("(Sum (F))");

        myReader.execute(op, in, null);

        //op2 = myReader.mem.getMapFunc().entrySet();

        Assert.assertTrue(myReader.mem.getMapFunc().keySet().contains("Sum"));
    }
}
