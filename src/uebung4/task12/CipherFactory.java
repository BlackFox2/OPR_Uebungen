package uebung4.task12;

/**
 * This class is a factory for encryption algorithms.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class CipherFactory {
    public static final String defaultCipher = "AdditiveSubstitution";
    /**
     * Creates and returns an object of the given algorithm name.
     *
     * @param name      Encryption algorithm to create object for
     * @return          Object for the specified algorithm
     * @throws IllegalArgumentException     when name does not match an available algorithm
     */
    public static Cipher getInstance(String name) throws IllegalArgumentException {
        switch (name) {
            case "XORSubstitution":
                return new XorSub();
            case "StreamCipher":
                return new StreamCipher();
            case "AdditiveSubstitution":
                return new AddSub();
            default:
                throw new IllegalArgumentException(name + " is not a valid algorithm!");
        }
    }

    /**
     * Creates and returns an AddSub object.
     * @return  AddSub object.
     */
    public static Cipher getInstance() {
        return new AddSub();
    }
}
