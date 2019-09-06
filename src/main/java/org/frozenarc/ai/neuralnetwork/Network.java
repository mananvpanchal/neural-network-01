package org.frozenarc.ai.neuralnetwork;

import java.security.SecureRandom;

/*
* Author: Manan
* Date: 20-08-2019 12:57
*/
public class Network {

    private Layer[] pLayer, rLayer;

    public Network(int pSize, int rSize, int[] prArray, SecureRandom random) {
        pLayer = new Layer[pSize];
        rLayer = new Layer[rSize];

        for (int i = 0; i < pSize; i++) {
            pLayer[i] = new Layer(prArray[i], prArray[i + 1], random);
        }

        for (int i = 0; i < rSize; i++) {
            rLayer[i] = new Layer(prArray[pSize + i], prArray[pSize + i + 1], random);
        }
    }

    public void distributeStrengths() {
        for (Layer l : pLayer) {
            l.distributeStrengths();
        }
        for (Layer l : rLayer) {
            l.distributeStrengths();
        }
    }

    public void initialize(double[] values) {
        for (int i = 0; i < values.length; i++) {
            pLayer[0].setValue(i, values[i]);
        }
    }

    public void reset() {
        for (int i = 0; i < pLayer.length; i++) {
            pLayer[i].reset();
        }

        for (int i = 0; i < rLayer.length; i++) {
            rLayer[i].reset();
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < pLayer.length; i++) {
            str.append(pLayer[i]);
        }

        for (int i = 0; i < rLayer.length; i++) {
            str.append(rLayer[i]);
        }
        return str.toString();
    }

    public String display() {
        return pLayer[0].display() + " ----> " + rLayer[rLayer.length - 1].display();
    }

    public void fireSignal() {
        for (int i = 0; i < pLayer.length - 1; i++) {
            pLayer[i].fireSignal(pLayer[i + 1]);
        }
        pLayer[pLayer.length - 1].fireSignal(rLayer[0]);
        for (int i = 0; i < rLayer.length - 1; i++) {
            rLayer[i].fireSignal(rLayer[i + 1]);
        }
    }

}
