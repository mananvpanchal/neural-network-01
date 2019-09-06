package org.frozenarc.ai.neuralnetwork;

import org.junit.Test;

import java.security.SecureRandom;

/*
* Author: Manan
* Date: 20-08-2019 13:16
*/
public class LayerTest {

    @Test
    public void test() {
        Layer layer = new Layer(10, 10, new SecureRandom());
        layer.distributeStrengths();
        System.out.println(layer.toString());
    }
}
