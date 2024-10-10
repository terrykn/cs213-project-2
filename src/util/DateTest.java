package util;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void test_yearOutOfRange() {
        Date date = new Date("5/11/1899");
        boolean actualOutput = date.isValid();
        String message = "** Test Case #1: year is out of range **";

        assertFalse(message, actualOutput);
    }

    @Test
    public void test_daysInFeb_NonLeap() {
        Date date = new Date("2/29/2023");
        boolean actualOutput = date.isValid();
        String message = "** Test Case #2: 29 is out of range of Feb on Non-leap year (2023) **";

        assertFalse(message, actualOutput);
    }

    @Test
    public void test_monthOutOfRange() {
        Date date = new Date("13/4/2024");
        boolean actualOutput = date.isValid();
        String message = "** Test Case #3: month is out of range **";

        assertFalse(message, actualOutput);
    }

    @Test
    public void test_zeroForMonthDaysAndYear() {
        Date date = new Date("0/0/0");
        boolean actualOutput = date.isValid();
        String message = "** Test Case #4: invalid input (range) for month, day, & year **";

        assertFalse(message, actualOutput);
    }

    @Test
    public void test_daysInFeb_Leap() {
        Date date = new Date("2/29/2024");
        boolean actualOutput = date.isValid();
        String message = "** Test Case #5: 29 is in range of Feb on leap year (2024) **";

        assertTrue(message, actualOutput);
    }

    @Test
    public void test_daysInDecember() {
        Date date = new Date("12/31/2003");
        boolean actualOutput = date.isValid();
        String message = "** Test Case #6: December has 31 days **";

        assertTrue(message, actualOutput);
    }
}