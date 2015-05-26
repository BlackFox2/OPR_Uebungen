package uebung3.task2;

/**
 * This class represents a parallel circuit of 2 parts. These parts can be objects implementing the Circuit-Interface.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class Parallel extends CompoundCircuit {

    /**
     * Initialization of the parallel circuit.
     * @param c1    object implementing Circuit Interface, not null
     * @param c2    object implementing Circuit Interface, not null
     */
    public Parallel(Circuit c1, Circuit c2) {
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
        if(c1.getOhm() == 0 || c2.getOhm() == 0) {
            return 0;
        }
        return 1/(1/c1.getOhm()+1/c2.getOhm());
    }
}
