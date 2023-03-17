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

        double calculate = myCalculator.calculate("( - ( + 35 5 ) 4 )");
        
        Assert.assertEquals(36.0, calculate, 0.5);
    }
}
