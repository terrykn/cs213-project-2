package ruclinic;
import util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void test_lastNameLessBeforeFirstName() {
        Profile profile1 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        Profile profile2 = new Profile("Andrew", "Kyle", new Date("1/5/1999"));
        int expectedOutput = -1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #1: Last Name Less Before First Name **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_lastNameLessBeforeDOB() {
        Profile profile1 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        Profile profile2 = new Profile("Bob", "Kyle", new Date("1/4/1999"));
        int expectedOutput = -1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #2: Last Name Less Before DOB **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_lastNameGreaterBeforeFirstName() {
        Profile profile1 = new Profile("Andrew", "Kyle", new Date("1/5/1999"));
        Profile profile2 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        int expectedOutput = 1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #3: Last Name Greater Before First Name **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_lastNameGreaterBeforeDOB() {
        Profile profile1 = new Profile("Andrew", "Kyle", new Date("1/4/1999"));
        Profile profile2 = new Profile("Andrew", "Johnson", new Date("1/5/1999"));
        int expectedOutput = 1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #4: Last Name Greater Before DOB **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_sameLastNameFirstNameLessBeforeDOB() {
        Profile profile1 = new Profile("Andrew", "Johnson", new Date("1/5/1999"));
        Profile profile2 = new Profile("Bob", "Johnson", new Date("1/4/1999"));
        int expectedOutput = -1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #5: Same Last Name First Name Less Before DOB **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_sameLastNameFirstNameGreaterBeforeDOB() {
        Profile profile1 = new Profile("Bob", "Johnson", new Date("1/4/1999"));
        Profile profile2 = new Profile("Andrew", "Johnson", new Date("1/5/1999"));
        int expectedOutput = 1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #6: Same Last Name First Name Greater Before DOB **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_sameFirstLastNameDOBLess() {
        Profile profile1 = new Profile("Bob", "Johnson", new Date("1/4/1999"));
        Profile profile2 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        int expectedOutput = -1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #7: Same First/Last Names DOB Less **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_sameFirstLastNameDOBGreater() {
        Profile profile1 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        Profile profile2 = new Profile("Bob", "Johnson", new Date("1/4/1999"));
        int expectedOutput = 1;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #8: Same First/Last Names DOB Greater **";
        assertEquals(message, expectedOutput, actualOutput);
    }

    @Test
    public void test_sameFirstLastNameDOB() {
        Profile profile1 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        Profile profile2 = new Profile("Bob", "Johnson", new Date("1/5/1999"));
        int expectedOutput = 0;
        int actualOutput = profile1.compareTo(profile2);
        String message = "** Test Case #9: Same First/Last Names and DOB **";
        assertEquals(message, expectedOutput, actualOutput);
    }
}