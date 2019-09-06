package org.frozenarc.ai.neuralnetwork;

import java.security.SecureRandom;

/*
* Author: Manan
* Date: 20-08-2019 12:57
*/
public class Layer {

    private Neuron[] neurons;

    public Layer(int size, int nextSize, SecureRandom random) {
        neurons = new Neuron[size];
        for (int i = 0; i < size; i++) {
            neurons[i] = new Neuron(0, nextSize, random);
        }
    }

    public void distributeStrengths() {
        for(Neuron n : neurons) {
            n.distributeStrengths();
        }
    }

    public String toString() {
        double sum = 0;
        StringBuilder str = new StringBuilder("\n--------------------------------------------\n");
        for (int i = 0; i < neurons.length; i++) {
            sum = sum + neurons[i].getValue();
            str.append(neurons[i]).append((i < neurons.length - 1) ? "\n" : "");
        }
        return str + "\nSum : "+sum+"---------------------------------------\n";
    }

    public String display() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < neurons.length; i++) {
            str.append(neurons[i].getValue()).append((i < neurons.length - 1) ? ", " : "");
        }
        return str.append("]").toString();
    }

    public void setValue(int idx, double value) {
        neurons[idx].setValue(neurons[idx].getValue() + value);
    }

    public void reset() {
        for (Neuron neuron : neurons) {
            neuron.setValue(0);
        }
    }

    public void fireSignal(Layer nextLayer) {
        for (Neuron n : neurons) {
            n.fireSignal(nextLayer);
        }
    }
}
