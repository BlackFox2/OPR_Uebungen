package uebung3;

/**
 * This class is a simple implementation to calculate a cross total checksum for a given string.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class CrossTotal implements Checksum{

    private int checksum = 0;
    /**
     * Takes a string as input and calculates the checksum. In order to calculate the checksum the char representation
     * of every letter is taken and aggregated
     *
     * @param input string from which to calculate the checksum
     * @return the calculated checksum
     */
    @Override
    public int checksum(String input) {
        byte[] bytes = input.getBytes();
        for(byte x : bytes) {
            checksum = calculateSumOfChar(getDigits(x), false, true);
        }
        return checksum;
    }

    /**
     * This method extracts the digits of a byte and returns it in an int array.
     *
     * @param character the byte to work on
     * @return      the digits stored in an int array
     */
    private int[] getDigits(byte character) {
        int x = character;
        int[] result;
        int i = 0;
        if(x >= 100) {
            result = new int[3];
        } else if(x >= 10){
            result = new int[2];
        } else {
            result = new int[1];
        }
        while(x > 0) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }

    /**
     * This method calculates the cross total of the given digits.
     * It supports different modes, indicated by the two boolean variables.
     * To calculate the alternating cross total you have to set isAlternating. Furthermore it is needed to indicate
     * with which sign to start for this number.
     *
     * @param digits            the digits to work on
     * @param isAlternating     whether or not to calculate the alternating crosstotal
     * @param add               <code>true</code> start with an addition
     *                          <code>false</code> start with a subtraction
     * @return                  the checksum for these digits
     */
    private int calculateSumOfChar(int[] digits, boolean isAlternating, boolean add) {
        int sum = 0;
        for(int digit : digits) {
            if(add) {
                sum += digit;
            } else {
                sum -= digit;
            }
            if(isAlternating) {
                add = !add;
            }
        }
        return sum;
    }

}
