import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by blackfox on 01.04.15.
 */
public class DateCheckerTest {

    @Test
    public void testCheckDate() throws Exception {
        int year = 0, month = 0, day = 0;
        boolean result;
        //test no input
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        //test out of gregorian time
        year = 1582;
        month = 10;
        day = 15;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        //test in gregorian time
        day = 16;
        result = DateChecker.checkDate(year, month, day);
        assertTrue(result);

        //test invalid month input
        month = -1;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        //test invalid month input
        month = 13;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        //test invalid day input
        day = -1;
        month = 1;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        //test invalid day input
        day = 32;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        //test month with 31 days
        month = 1;
        day = 31;
        result = DateChecker.checkDate(year, month, day);
        assertTrue(result);

        //test month with 30 days
        month = 4;
        day = 31;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);


        //test leapyear (29 days in february)
        year = 2000;
        month = 2;
        day = 29;
        result = DateChecker.checkDate(year, month, day);
        assertTrue(result);

        //test normal year (28 days in february)
        year = 2001;
        result = DateChecker.checkDate(year, month, day);
        assertFalse(result);

        day = 28;
        result = DateChecker.checkDate(year, month, day);
        assertTrue(result);

    }
}