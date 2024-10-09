package util;
import java.util.Calendar;
/**
 * Class for maintaining appointment dates
 * @author Terry Nguyen, Olivia Schroeder
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    private int LESSTHAN = -1;
    private int GREATERTHAN = 1;
    private int EQUAL = 0;
    /**
     * Default constructor for a new Date object
     */
    public Date() {
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }
    /**
     * Constructor for creating a new Date object with a given date
     * @param date Date to set the date object to, in format "mm/dd/yyyy"
     */
    public Date(String date) {
        String[] splitInput = date.split("/");
        if(splitInput.length != 3) {
            // invalid date (not in month/day/year format)
            this.year = 0;
            this.month = 0;
            this.day = 0;
        }
        this.month = Integer.parseInt(splitInput[0]);
        this.day = Integer.parseInt(splitInput[1]);
        this.year = Integer.parseInt(splitInput[2]);
    }
    /**
     * Checks if a Date object is a valid date
     * @return True if valid, false otherwise
     */
    public boolean isValid() {
        if(year < 1900) return false;
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false); //date has to be valid, not lenient
        calendar.set(year, month - 1, day); //months start at 0 with Calendar class
        try {
            java.util.Date time = calendar.getTime(); //if this doesn't work, then date is not valid
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    /**
     * Gets today's date
     * @return Date object containing today's date
     */
    public static Date TODAY() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        return new Date(month + "/" + day + "/" + year);
    }
    /**
     * Gets the date six months from today
     * @return Date object containing the date six months from today
     */
    public static Date sixMonthsFromToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 6); // add 6 months from today
        int futureMonth = calendar.get(Calendar.MONTH) + 1; // because months are 0 based here, we add 1
        int futureDay = calendar.get(Calendar.DAY_OF_MONTH);
        int futureYear = calendar.get(Calendar.YEAR);
        return new Date(futureMonth + "/" + futureDay + "/" + futureYear);
    }

    /**
     * Checks if the current instance of Date contains today's date
     * @return True if the date is today, false otherwise
     */
    public boolean isToday() {
        return this.equals(TODAY());
    }
    /**
     * Checks if the current instance of Date is a weekday using the Calendar class
     * @return True if it is a weekday (Monday-Friday), false otherwise (Saturday or Sunday)
     */
    public boolean isWeekday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.getYear(), Calendar.JANUARY,this.getDay());
        calendar.set(Calendar.MONTH, this.getMonth() - 1); // need to set month appropriately (0 based)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // Get the day of the week (numerical value 1-7)
        return (dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.FRIDAY);
    }
    /**
     * Compare the current instance of Date with a given Date object for equality,
     * which is when their day, month, and year match
     * @param dateToCompareTo Object to compare with (should be Date)
     * @return True if "equal", false otherwise
     */
    @Override
    public boolean equals(Object dateToCompareTo) {
        if (dateToCompareTo instanceof Date dateCasted) {
            return this.compareTo(dateCasted) == 0;
        }
        return false;
    }
    /**
     * Return a textual representation of the current Date instance in the format "day/month/year"
     * @return String containing the textual representation of the Date object
     */
    @Override
    public String toString() {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }
    /**
     * Compare the current Date instance with another Date object based on which date comes before or after
     * @param dateToCompareTo Date object to compare with
     * @return 1 if current Date instance occurs after the other Date object, -1 if before, 0 if equal
     */
    @Override
    public int compareTo(Date dateToCompareTo) {
        if (this.year == dateToCompareTo.getYear()) {
            if (this.month == dateToCompareTo.getMonth()) {
                if (this.day == dateToCompareTo.getDay()) {
                    return EQUAL;
                } else if (this.day < dateToCompareTo.getDay()) {
                    return LESSTHAN;
                } else {return GREATERTHAN;}
            } else if (this.month < dateToCompareTo.getMonth()) {return LESSTHAN; // this.date < dateToCompareTo
            } else {return GREATERTHAN;}
        } else if (this.year < dateToCompareTo.getYear()) {return LESSTHAN; // this.date < dateToCompareTo
        } else {return GREATERTHAN;
        }
    }
    /**
     * Gets the day parameter of the current Date instance
     * @return Day associated with the Date object
     */
    public int getDay() {return day;}
    /**
     * Gets the year parameter of the current Date instance
     * @return Year associated with the Date object
     */
    public int getYear() {return year;}
    /**
     * Gets the month parameter of the current Date instance
     * @return Month associated with the Date object
     */
    public int getMonth() {return month;}
    /**
     * A testbed main() implementing the test cases in the test specification.
     * @param args Arguments given to handle in the Date class
     */
    public static void main(String[] args) {
        test_yearOutOfRange();
        test_daysInFeb_NonLeap();
        test_monthOutOfRange();
        test_zeroForMonthDaysAndYear();
        test_daysInFeb_Leap();
        test_daysInDecember();
    }
    /**
     * Test Case #1
     */
    private static void test_yearOutOfRange() {
        Date date = new Date("5/11/1899");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("** Test Case #1: year is out of range **");
        testResults(date, expectedOutput, actualOutput);
    }
    /**
     * Test Case #2
     */
    private static void test_daysInFeb_NonLeap() {
        Date date = new Date("2/29/2023");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("** Test Case #2: 29 is out of range of Feb on Non-leap year (2023) **");
        testResults(date, expectedOutput, actualOutput);
    }
    /**
     * Test Case #3
     */
    private static void test_monthOutOfRange() {
        Date date = new Date("13/4/2024");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("** Test Case #3: month is out of range **");
        testResults(date, expectedOutput, actualOutput);
    }
    /**
     * Test Case #4
     */
    private static void test_zeroForMonthDaysAndYear() {
        Date date = new Date("0/0/0");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("** Test Case #4: invalid input (range) for month, day, & year **");
        testResults(date, expectedOutput, actualOutput);
    }
    /**
     * Test Case #5
     */
    private static void test_daysInFeb_Leap() {
        Date date = new Date("2/29/2024");
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("** Test Case #5: 29 is in range of Feb on leap year (2024) **");
        testResults(date, expectedOutput, actualOutput);
    }
    /**
     * Test Case #6
     */
    private static void test_daysInDecember() {
        Date date = new Date("12/31/2003");
        boolean expectedOutput = true;
        boolean actualOutput = date.isValid();
        System.out.println("** Test Case #6: December has 31 days **");
        testResults(date, expectedOutput, actualOutput);
    }
    /**
     * Helper method for printing the test case input, expected output, actual output, and PASS/FAIL result
     * @param date Date to be tested with the isValid() method
     * @param expectedOutput String containing expected output of the test case
     * @param actualOutput String containing actual output of the test case
     */
    private static void testResults(Date date, boolean expectedOutput, boolean actualOutput) {
        System.out.println("Test Input: " + date);
        System.out.println("Expected Output: " + expectedOutput);
        String result = " (FAIL)\n";
        if(expectedOutput == actualOutput) {result = " (PASS)\n";}
        System.out.println("Actual Output: " + actualOutput + result);
    }
}
