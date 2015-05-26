package uebung3.task2;

/**
 * This class implements a simple potentiometer.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class Potentiometer implements Circuit {

    private double ohm;
    private double max;

    /**
     * Initialisation of the maximum value for the resistance
     * @param max   double > 0
     */
    public Potentiometer(double max) {
        if(max < 0) {
            this.max = 0;
        } else {
            this.max = max;
        }
    }

    /**
     * Let's you change the resistance from the potentiometer.
     * @param ohm   double > 0
     */
    public void setOhm(double ohm) {
        if(ohm < 0) {
            this.ohm = 0;
        }else if(ohm > max) {
            this.ohm = max;
        } else {
            this.ohm = ohm;
        }

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
