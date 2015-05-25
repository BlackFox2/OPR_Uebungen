package uebung3.task2;

/**
 * This class implements a simple resistor.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class Resistor implements Circuit {
    private double ohm;

    public Resistor(double ohm) {
        this.ohm = ohm;
    }

    /**
     * Returns the resistance of the circuit
     *
     * @return the resistance value
     */
    @Override
    public double getOhm() {
        return ohm;
    }

    /**
     * Returns the number of resistors in the circuit
     *
     * @return counter of resistors
     */
    @Override
    public int numberOfResistors() {
        return 1;
    }
}
