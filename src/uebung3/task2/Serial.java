package uebung3.task2;

/**
 * This class represents a serial circuit of 2 parts. These parts can be objects implementing the Circuit-Interface.
 *
 * @see Circuit
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class Serial extends CompoundCircuit {

    /**
     * Creates a new Serial object.
     *
     * @param c1    object which implements the Circuit Interface, not null
     * @param c2    object which implements the Circuit Interface, not null
     */
    public Serial(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * Returns the resistance of the circuit
     *
     * @return the resistance value
     */
    @Override
    public double getOhm() {
        return c1.getOhm() + c2.getOhm();
    }
}
