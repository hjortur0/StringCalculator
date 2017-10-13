package is.ru.hjorturd15.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

}
