package uebung3.task2;

/**
 * This interface has to be implemented by all classes which represent a circuit.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public interface Circuit {
    /**
     * Returns the resistance of the circuit
     * @return  the resistance value
     */
    double getOhm();

    /**
     * Returns the number of resistors in the circuit
     * @return  counter of resistors
     */
    int numberOfResistors();
}
