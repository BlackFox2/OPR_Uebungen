import java.util.Scanner;

/**
 * Program to check if a given date is correct or not.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class DateChecker {

    /**
     * You need to input day, month and year. After that the date gets checked and a response will be generated.
     *
     * @param args Console arguments
     */
    public static void main(String[] args) {
        DateChecker date = new DateChecker();
        int day;
        int month;
        int year;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter day value: ");
        day = s.nextInt();
        System.out.print("Enter month value: ");
        month = s.nextInt();
        System.out.print("Enter year value: ");
        year = s.nextInt();
        System.out.printf("The date value %d/%d/%d is ", day, month, year);
        if(date.checkDate(year,month,day)) {
            System.out.print("a correct date");
        } else {
            System.out.print("not correct");
        }
        s.close();
    }

    /**
     * Checks the combination of year, month, day
     *
     * @param year year-value of the date
     * @param month month-value of the date
     * @param day day-value of the date
     * @return true if the given date is valid
     */
    public boolean checkDate(int year, int month, int day) {
        if(year <= 1582 && month <= 10 && day <= 15) {      // date is not in the Gregorian time
            return false;
        } else {
            if (month >= 1 && month <= 12) {                // valid value for month
                if (day < 1) {                              // day value is wrong
                    return false;
                }
                switch (month) {                            // check day value in connection to month
                    case 1:                                 // following months have 31 days
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:                                // end of months with 31 days
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 4:                                 // following months have 30 days
                    case 6:
                    case 9:
                    case 11:                                // end of months with 30 days
                        if (day > 30) {
                            return false;
                        }
                        break;
                }
                if (month == 2) {                           // february is different
                    if (year % 400 == 0 || year % 4 == 0) { // leapyear => 29 days
                        if (day > 29) {
                            return false;
                        }
                    } else {                                // not a leapyear => 28 days
                        if (day > 28) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
