/**
 * Created by blackfox on 31.03.15.
 */
public class PasswordChecker {
    boolean isLongEnough = false;
    boolean hasTwoNumsLets = false;
    boolean hasSmallLet = false;
    boolean hasBigLet = false;
    boolean hasSpecialChar = false;
    boolean oneNumSpecChar = false;
    String pw;

    // (.) any character; * zero or more times
    final String SPECIALREGEX = "(.)*[!\"#$%&'()*+,-./:;<=>?@](.)*";

    public static void main(String[] args) {
        System.out.println(args.length);
        if (args.length < 1) {
            System.out.println("Usage: <password to check>");
            System.exit(0);
        }

        PasswordChecker pwc = new PasswordChecker();
        for (String x : args) {
            pwc.reset();
            pwc.setPw(x);
            pwc.checkLength();
            pwc.checkNumsLet();
            pwc.checkSmallCapitalLet();
            pwc.checkSpecialChar();
            pwc.checkNumOrSpecChar();
            pwc.printResult();
        }

    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void reset() {
        isLongEnough = false;
        hasTwoNumsLets = false;
        hasSmallLet = false;
        hasBigLet = false;
        hasSpecialChar = false;
        oneNumSpecChar = false;
    }

    private void checkLength() {
        if (pw.length() >= 8) {
            isLongEnough = true;
        }
    }

    private void checkNumsLet() {
        int letterCount = 0;
        int numCount = 0;
        for (int i = 0; i < pw.length(); i++) {
            if (letterCount < 2 && (pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z'
                    || pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z')) {
                letterCount++;
            } else if (numCount < 2 && (pw.charAt(i) >= '0' && pw.charAt(i) <= '9')) {
                numCount++;
            }
            if (numCount >= 2 && letterCount >= 2) {
                hasTwoNumsLets = true;
                break;
            }


        }
    }

    private void checkSmallCapitalLet() {
        if (pw.matches("(.)*[\\p{Lower}](.)*")) {
            hasSmallLet = true;
        }
        if (pw.matches("(.)*[\\p{Upper}](.)*")) {
            hasBigLet = true;
        }
    }

    private void checkSpecialChar() {
        if (pw.matches(SPECIALREGEX)) {
            hasSpecialChar = true;
        }
    }

    private void checkNumOrSpecChar() {
        checkSpecialChar();
        if (hasSpecialChar || pw.matches("(.)*[\\d](.)*")) {
            oneNumSpecChar = true;
        }
    }

    private void printResult() {
        System.out.println("You entered the following password: " + pw);
        if (!isLongEnough) {
            System.out.println("The password is shorter than 8 characters!");
        }
        if (!hasTwoNumsLets) {
            System.out.println("The password does not contain at least two letters and two numbers!");
        }
        if (!hasSmallLet || !hasBigLet) {
            System.out.println("The password does not contain at least one minuscule and one capital!");
        }
        if (!hasSpecialChar) {
            System.out.println("The password does not contain at least one special character!");
        }
        if (!oneNumSpecChar) {
            System.out.println("The password does not contain at least one special character or number!");
        }
        if (isLongEnough && hasTwoNumsLets && hasSmallLet && hasBigLet && hasSpecialChar && oneNumSpecChar) {
            System.out.println("The password complies with the rules!");
        }
    }

}