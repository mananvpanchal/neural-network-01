package org.frozenarc.ai.neuralnetwork;

import java.util.Arrays;

/*
* Author: Manan
* Date: 20-08-2019 18:19
*/
public class Util {

    public static double[] reverseSort(double[] source) {

        double[] array = new double[source.length];

        System.arraycopy(source, 0, array, 0, source.length);

        Arrays.sort(array);

        for (int i = 0; i < array.length / 2; i++) {
            double tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }

        return array;
    }

    public static int convertToIdx(int size, double random) {
        int idx = (int)(size * random);
        if(idx == size) {
            idx = idx - 1;
        }
        return idx;
    }
}
