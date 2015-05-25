package uebung3;

/**
 * This class is an implementation to calculate alternating cross total of a given string.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class AlternatingCrossTotal extends CrossTotal implements Checksum {

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
        boolean add = true;
        int sum = 0;
        for(byte x: bytes) {
            sum += calculateSumOfChar(getDigits(x), true, add);
            if((int)x > 100 || (int) x < 10){
                add = !add;
            } else {
                add = true;
            }
        }
        return sum;
    }
}
