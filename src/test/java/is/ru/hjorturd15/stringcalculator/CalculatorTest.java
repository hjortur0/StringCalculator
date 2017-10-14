package is.ru.hjorturd15.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(10, Calculator.add("2,3,5"));
    }

    @Test
    public void testMultipleDigitNumbers() {
        assertEquals(345, Calculator.add("300,40,5"));
    }

    @Test
    public void testNewLineAndCommaSeparators() {
        assertEquals(10, Calculator.add("2,3\n5"));
    }

    @Test
    public void testNegativeNumberExceptionMessage() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negatives not allowed: -5");
        Calculator.add("-5");
    }

    @Test
    public void testNegativeNumbersExceptionMessage() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negatives not allowed: -5,-10,-15");
        Calculator.add("5,-5,10,-10,20,-15");
    }

    @Test
    public void testOverOneThousand() {
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testSingleCharacterDelimiter() {
        assertEquals(10, Calculator.add("//;\n7;3"));
    }
}
