package uebung3;

/**
 * This class is a simple implementation to calculate a cross total checksum for a given string.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class CrossTotal implements Checksum{


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
        int sum = 0;
        for(byte x : bytes) {
            sum += calculateSumOfChar(getDigits(x), false, true);
        }
        return sum;
    }

    /**
     * This method extracts the digits of a byte and returns it in an int array.
     *
     * @param character the byte to work on
     * @return      the digits stored in an int array
     */
    protected int[] getDigits(int character) {
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
            i++;
        }
        return result;
    }

    /**
     * This method calculates the cross total of the given digits in reverse order.
     * It supports different modes, indicated by the two boolean variables.
     * To calculate the alternating cross total you have to set isAlternating. Furthermore it is needed to indicate
     * with which sign to start for this number.
     *
     * @param digits            the digits to work on
     * @param isAlternating     <code>true</code> calculate the alternating cross total
     *                          <code>false</code> calculate the normal cross total
     * @param add               <code>true</code> start with an addition
     *                          <code>false</code> start with an subtraction
     * @return                  the checksum for these digits
     */
    protected int calculateSumOfChar(int[] digits, boolean isAlternating, boolean add) {
        int temp = 0;
        for(int i = digits.length-1; i >= 0; i--) {
            if(add) {
                temp += digits[i];
            } else {
                temp -= digits[i];
            }
            if(isAlternating) {
                add = !add;
            }
        }
        return temp;
    }

}
