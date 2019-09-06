package org.frozenarc.ai.neuralnetwork;

import org.junit.Test;

import java.security.SecureRandom;

/*
* Author: Manan
* Date: 20-08-2019 13:25
*/
public class NetworkTest {

    @Test
    public void test() {
        Network network = new Network(3, 2, new int[]{3, 10, 15, 20, 30, 0}, new SecureRandom());
        network.distributeStrengths();

        network.initialize(new double[]{0, 0, 1});
        network.fireSignal();
        System.out.println(network.display());

        network.reset();
        network.initialize(new double[]{0, 1, 0});
        network.fireSignal();
        System.out.println(network.display());

        network.reset();
        network.initialize(new double[]{1, 0, 0});
        network.fireSignal();
        System.out.println(network.display());
    }
}
