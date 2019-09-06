package org.frozenarc.ai.neuralnetwork;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        /*System.out.println("Hello World!");
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10 ;i++) {
            System.out.println(random.nextDouble());
        }*/

        double[] array = new double[]{2.0, 7.0, 5.0, 3.0, 9.0, 4.0, 1.0, 8.0, 6.0, 10.0};
        Arrays.sort(array);

        for (int i = 0; i < array.length / 2; i++) {
            double tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
