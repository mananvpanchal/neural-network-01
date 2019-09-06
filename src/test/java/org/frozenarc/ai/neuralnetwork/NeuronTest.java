package org.frozenarc.ai.neuralnetwork;

import org.junit.Test;

import java.security.SecureRandom;

/*
* Author: Manan
* Date: 20-08-2019 12:50
*/
public class NeuronTest {

    @Test
    public void test() {
        int size = 10;
        Neuron n = new Neuron(10, size, new SecureRandom());
        n.distributeStrengths();
        double[] next = n.getNext();
        for (int i = 0; i < size; i++) {
            System.out.println(next[i]);
        }
    }
}
