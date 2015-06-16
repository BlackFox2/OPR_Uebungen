package uebung1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitTest for testing the uebung1.DateChecker class and it's functionality.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class DateCheckerTest {

    /**
     * Checks the testCheckDate function from uebung1.DateChecker class with different inputs.
     *
     * @throws Exception
     */
    @Test
    public void testCheckDate() throws Exception {
        int year = 0, month = 0, day = 0;
        boolean result;
        DateChecker d = new DateChecker();
        //test no input
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test out of gregorian time
        year = 1582;
        month = 10;
        day = 15;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test in gregorian time
        day = 16;
        result = d.checkDate(year, month, day);
        assertTrue(result);

        //test invalid month input (too low)
        month = -1;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test invalid month input (too high)
        month = 13;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test invalid day input    (too low)
        day = -1;
        month = 1;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test invalid day input    (too high)
        day = 32;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test month with 31 days
        month = 1;
        day = 31;
        result = d.checkDate(year, month, day);
        assertTrue(result);

        //test month with 30 days with wrong day input
        month = 4;
        day = 31;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test month with 30 days with correct day input
        day = 30;
        result = d.checkDate(year, month, day);
        assertTrue(result);

        //test leapyear (29 days in february)
        year = 2000;
        month = 2;
        day = 29;
        result = d.checkDate(year, month, day);
        assertTrue(result);

        //test leapyear (29 days in february) with wrong day input
        day = 30;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test normal year (28 days in february) with wrong day input
        day = 30;
        year = 2001;
        result = d.checkDate(year, month, day);
        assertFalse(result);

        //test normal year (28 days in february)
        day = 28;
        result = d.checkDate(year, month, day);
        assertTrue(result);

    }
}