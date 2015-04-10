import java.util.Scanner;

/**
 * Created by blackfox on 01.04.15.
 */
public class NewtonRoot {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double n;
        double sRoot , cRoot;
        System.out.print("Bitte geben Sie eine Zahl ein: ");
        n = s.nextDouble();
        sRoot = squareRoot(n);
        System.out.printf("Die Quadratwurzel von %e lautet %.15f\n", n, sRoot);
        cRoot = cubicRoot(n);
        System.out.printf("Die Kubikwurzel von %e lautet %.15f\n", n, cRoot);
    }

    public static double squareRoot(double n) {
        double target_diff = 0.000001;
        double q = 1.0;
        double act_diff;

        do {
            act_diff = Math.abs(n-q*q);
            q = (q+(n/q))/2;
        } while(act_diff > target_diff);

        return q;
    }

    public static double cubicRoot(double n) {
        double target_diff = 0.000001;
        double q = 1.0;
        double act_diff;
        do {
            act_diff = Math.abs(n-q*q*q);
            //q = 2/3*q + n/(3*q*q);
            q = (2*q+n/(q*q))/3;
        } while(act_diff > target_diff);
        return q;
    }

}
