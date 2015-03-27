import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by blackfox on 27.03.15.
 */
public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        double result = Calculator.add(1,1);
        assertEquals(2,result, 0.0001);
    }
}