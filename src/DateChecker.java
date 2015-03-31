import java.util.Scanner;

/**
 * Created by blackfox on 31.03.15.
 */
public class DateChecker {

    public static void main(String[] args) {
        int d = 0;
        int m = 0;
        int y = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter day value: ");
        d = s.nextInt();
        System.out.print("Enter month value: ");
        m = s.nextInt();
        System.out.print("Enter year value: ");
        y = s.nextInt();
        System.out.printf("The date value %d/%d/%d is ", d, m, y);
        if(checkDate(y,m,d)) {
            System.out.print("a correct date");
        } else {
            System.out.print("not correct");
        }
        s.close();
    }

    public static boolean checkDate(int year, int month, int day) {
        boolean isDate = false;
        if(year <= 1582 && month <= 10 && day <= 15) {

        } else {
            if (month >= 1 && month <= 12) {
                if (day < 1) {
                    return false;
                }
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (day > 30) {
                            return false;
                        }
                        break;
                }
                if (month == 2) {
                    if (year % 400 == 0 || year % 4 == 0) {
                        //Schaltjahr
                        if (day > 29) {
                            return false;
                        }
                    } else {
                        if (day > 28) {
                            return false;
                        }
                    }
                }
                isDate = true;
            }
        }
        return isDate;
    }

}
