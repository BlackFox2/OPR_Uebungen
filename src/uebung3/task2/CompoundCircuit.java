package uebung3.task2;


/**
 * This class makes it possible to build complex circuits. The class is abstract so you cannot create an object of it.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public abstract class CompoundCircuit implements Circuit{

    Circuit c1;
    Circuit c2;

    /**
     * Returns the number of resistors in the circuit
     *
     * @return counter of resistors
     */
    @Override
    public int numberOfResistors() {
        return c1.numberOfResistors() + c2.numberOfResistors();
    }
}
