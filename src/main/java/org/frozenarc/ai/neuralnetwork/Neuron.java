package org.frozenarc.ai.neuralnetwork;

import java.security.SecureRandom;

/*
* Author: Manan
* Date: 20-08-2019 12:46
*/
public class Neuron {

    private double value;
    private double[] next;
    private SecureRandom random;

    public Neuron(double value, int nextSize, SecureRandom random) {
        this.value = value;
        this.next = new double[nextSize];
        this.random = random;
    }

    public double[] getNext() {
        return next;
    }

    public String toString() {
        double sum = 0;
        StringBuilder str = new StringBuilder(value + ": ").append("[");
        for (int i = 0; i < next.length; i++) {
            sum = sum + next[i];
            str.append(next[i]).append((i < next.length - 1) ? ", " : "");
        }
        return str + "] Sum: "+sum;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void distributeStrengths() {
        double sum = 0;
        if (next.length == 0) return;
        boolean[] done = new boolean[next.length];
        while (sum != 1.0) {
            int idx = getIdx(done);
            next[idx] = (1 - sum) * (isIdxLast(done, idx) ? 1 : random.nextDouble());
            sum = sum + next[idx];
            done[idx] = true;
            //System.out.println("Sum: " + sum + ", value: " + next[idx]);
        }
    }

    private int getIdx(boolean[] done) {
        int idx = Util.convertToIdx(next.length, random.nextDouble());
        //System.out.println("* " + idx);
        if (done[idx]) {
            while (idx > 0 && done[idx]) {
                idx = idx - 1;
                //System.out.println("- " + idx);
            }
        }
        if (done[idx]) {
            while (idx < next.length - 1 && done[idx]) {
                idx = idx + 1;
                //System.out.println("+ " + idx);
            }
        }
        return idx;
    }

    private boolean isIdxLast(boolean[] done, int idx) {
        int count = 0;
        for (boolean aDone : done) {
            count = count + (!aDone ? 1 : 0);
        }
        return count == 1 && !done[idx];
    }

    public void fireSignal(Layer nextLayer) {
        for (int i = 0; i < next.length; i++) {
            nextLayer.setValue(i, value * next[i]);
        }
    }

    /*public boolean isAllDone(boolean[] done) {
        int count = 0;
        for (int i = 0; i < done.length; i++) {
            count = count + (!done[i] ? 1 : 0);
        }
        return count == 0;
    }*/
}
