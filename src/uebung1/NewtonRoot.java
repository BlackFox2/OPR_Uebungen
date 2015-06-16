package uebung1;

import java.util.Scanner;

/**
 * Program to calculate an approximation to the square and cubic root with the Newton-Method.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class NewtonRoot {

    /**
     * Asks for a number > 0 to calculate the square and cubic root.
     *
     * @param args console arguments (not used)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double n;
        double sRoot, cRoot;
        NewtonRoot nR = new NewtonRoot();
        System.out.print("Bitte geben Sie eine Zahl groesser 0 ein: ");
        n = s.nextDouble();
        if (!(n > 0.0)) {
            System.out.println("Die Zahl muss groesser 0 sein!");
            System.exit(-1);
        }
        sRoot = nR.squareRoot(n);
        System.out.printf("Die Quadratwurzel von %e lautet %.15f\n", n, sRoot);
        cRoot = nR.cubicRoot(n);
        System.out.printf("Die Kubikwurzel von %e lautet %.15f\n", n, cRoot);
    }

    /**
     * Function to calculate a approximation to the the square root for a given number with a maximum deviation of
     * 0.000001
     *
     * @param n the number of which to calculate the approximation to the square root
     * @return the approximation to the square root of the given value
     */
    public double squareRoot(double n) {
        double target_diff = 0.000001;                      //maximum deviation
        double q = 1.0;
        double act_diff;                                    //actual deviation

        do {
            act_diff = Math.abs(n - q * q);                     //update the actual deviation
            q = (q + (n / q)) / 2;                                //calculate new q value
        } while (act_diff > target_diff);

        return q;
    }

    /**
     * Function to calculate a approximation to the the square root for a given number with a maximum deviation of
     * 0.000001
     *
     * @param n the number of which to calculate the approximation to the cubic root
     * @return the approximation to the cubic root of the given value
     */
    public double cubicRoot(double n) {
        double target_diff = 0.000001;                      //maximum deviation
        double q = 1.0;
        double act_diff;                                    //actual deviation
        do {
            act_diff = Math.abs(n - q * q * q);                   //update the actual deviation
            q = (2 * q + n / (q * q)) / 3;                            //calculate new q value
        } while (act_diff > target_diff);
        return q;
    }

}
