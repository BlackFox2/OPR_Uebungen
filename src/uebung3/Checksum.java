package uebung3;

/**
 * This interface has to be implemented by all classes which implement an algorithm for calculating checksums.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public interface Checksum {

    /**
     * Takes a string as input and calculates the checksum
     * @param input     string from which to calculate the checksum
     * @return          the calculated checksum
     */
    int checksum(String input);
}
