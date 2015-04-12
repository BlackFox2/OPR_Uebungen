/**
 * A program to check one or more given passwords for important attributes regarding the password strength.
 * These attributes are the length, capital/lower case letters, numbers, special characters and combinations of them.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class PasswordChecker {
    /**
     * Boolean whether or not the password is long enough (8 characters in our case)
     */
    boolean isLongEnough = false;
    /**
     * Boolean whether or not the password contains at least two numbers and two letters
     */
    boolean hasTwoNumsLets = false;
    /**
     * Boolean whether or not the password has at least one small letter
     */
    boolean hasSmallLet = false;
    /**
     * Boolean whether or not the password has at least one big letter
     */
    boolean hasBigLet = false;
    /**
     * Boolean whether or not the password contains at least one special character
     */
    boolean hasSpecialChar = false;
    /**
     * Boolean whether or not the password contains at least one special character and one number
     */
    boolean oneNumSpecChar = false;
    /**
     * The password to check
     */
    String pw;

    /**
     *  Regex to check if a special character is in the password
     *  (.) any character; * zero or more times
     */

    final String SPECIALREGEX = "(.)*[!\"#$%&'()*+,-./:;<=>?@](.)*";


    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: <password to check>");
            System.exit(0);
        }

        PasswordChecker pwc = new PasswordChecker();
        for (String x : args) {
            pwc.reset();
            pwc.setPw(x);
            pwc.isLongEnough = pwc.checkLength();
            pwc.hasTwoNumsLets = pwc.checkNumsLet();
            pwc.checkSmallCapitalLet();
            pwc.hasSpecialChar = pwc.checkSpecialChar(pwc.SPECIALREGEX);
            pwc.oneNumSpecChar = pwc.checkNumOrSpecChar();
            pwc.printResult();

        }

    }


    /**
     * Set the password to check
     *
     * @param pw Password to check
     */
    public void setPw(String pw) {
        this.pw = pw;
    }

    /**
     * Reset all values in the class for a new check
     */
    public void reset() {
        isLongEnough = false;
        hasTwoNumsLets = false;
        hasSmallLet = false;
        hasBigLet = false;
        hasSpecialChar = false;
        oneNumSpecChar = false;
        pw = "";
    }

    /**
     * Check the length of the given password.
     *
     * @return  Boolean whether or not the password is long enough
     */
    private boolean checkLength() {
        return pw.length() >= 8;
    }

    /**
     * Check whether or not the password contains at least two numbers and two letters.
     *
     * @return Whether or not the password fulfills the requirements.
     */
    private boolean checkNumsLet() {
        int letterCount = 0;
        int numCount = 0;
        for (int i = 0; i < pw.length(); i++) {
            //if we have already found 2 letters we don't need to look for them.
            if (letterCount < 2 && (pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z'
                    || pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z')) {
                letterCount++;
            } else if (numCount < 2 && (pw.charAt(i) >= '0' && pw.charAt(i) <= '9')) {
                numCount++;
            }
            if (numCount >= 2 && letterCount >= 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the password contains at least one small and one capital letter.
     * Check is performed with regex classes
     */
    private void checkSmallCapitalLet() {
        if (pw.matches("(.)*[\\p{javaLowerCase}](.)*")) {   // [\\p{Lower}] POSIX character class
            hasSmallLet = true;
        }
        if (pw.matches("(.)*[\\p{Upper}](.)*")) {   // [\\p{Upper}] POSIX character class
            hasBigLet = true;
        }
    }

    /**
     * Checks if the password contains a special character.
     *
     * @param regex Regex string with all allowed special characters
     * @return true when one of the characters is in the password
     */
    private boolean checkSpecialChar(String regex) {
        return pw.matches(SPECIALREGEX);
    }

    /**
     * Checks if the password contains at least one number and one special character.
     * Method checkSpecialChar is used to determine if a special character is in the password.
     *
     * @return true if the password includes at least one number and special character
     */
    private boolean checkNumOrSpecChar() {
        checkSpecialChar(this.SPECIALREGEX);
        return hasSpecialChar || pw.matches("(.)*[\\d](.)*");   // [\\d] Regex digit-class
    }

    /**
     * Prints the result of all checks with further information which requirement the password doesn't fulfill
     */
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