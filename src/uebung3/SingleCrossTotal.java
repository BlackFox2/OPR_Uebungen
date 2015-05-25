package uebung3;

/**
 * This class is an implementation to calculate the single digit cross total of a given string.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class SingleCrossTotal extends CrossTotal {

    /**
     * Takes a string as input and calculates the checksum. In order to calculate the checksum the char representation
     * of every letter is taken and aggregated
     *
     * @param input string from which to calculate the checksum
     * @return the calculated checksum
     */
    @Override
    public int checksum(String input) {
        super.checksum(input);
        while(getSum() >= 10) {
            String x = Integer.toString(getSum());
            super.checksum(x);
        }
        return getSum();
    }
}
