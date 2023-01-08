package com.vector;

import java.util.ArrayList;
import java.util.List;

public class ListVector implements IVector {
    private List<Double> data;

    public ListVector() {
        /* TODO */
        data = new ArrayList<>();
    }

    public ListVector(List<Double> data) {
        /* TODO */
        this.data = data;
    }

    @Override
    public void append(double value) {
        /* TODO */
        data.add(value);
    }

    @Override
    public void insert(double value, int index) {
        /* TODO */
        data.add(index, value);
    }

    @Override
    public void remove(int index) {
        /* TODO */
        data.remove(index);
    }

    @Override
    public int length() {
        /* TODO */
        return data.size();
    }

    @Override
    public double magnitude() {
        /* TODO */
        double summary = 0;
        for (Double dat : data) {
            summary += dat * dat;
        }
        return Math.sqrt(summary);
    }

    public double distanceTo(ListVector another) {
        /* TODO */
        if (length() != another.length()) {
            return -1;
        }
        double summary = 0;
        for (int i = 0; i < length(); i++) {
            summary += (data.get(i) - another.data.get(i)) * (data.get(i) - another.data.get(i));
        }
        return Math.sqrt(summary);
    }

    @Override
    public double[] elements() {
        /* TODO */
        double[] res = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            res[i] = data.get(i);
        }
        return res;
    }

    public double element(int index) {
        /* TODO */
        return data.get(index);
    }

    public ListVector minus(ListVector another) {
        /* TODO */
        if (length() != another.length()) {
            return null;
        }
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < length(); i++) {
            temp.add(data.get(i) - another.data.get(i));
        }
        return new ListVector(temp);
    }

    public ListVector plus(ListVector another) {
        /* TODO */
        if (length() != another.length()) {
            return null;
        }
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < length(); i++) {
            temp.add(data.get(i) + another.data.get(i));
        }
        return new ListVector(temp);
    }

    public ListVector scale(double factor) {
        /* TODO */
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < length(); i++) {
            temp.add(data.get(i) * factor);
        }
        return new ListVector(temp);

    }

    public double dot(ListVector another) {
        /* TODO */
        if (length() != another.length()) {
            return -1;
        }
        double summary = 0;
        for (int i = 0; i < length(); i++) {
            summary += data.get(i) * another.data.get(i);
        }
        return summary;
    }

    /*
     * Hàm trả ra format của vector dạng: [a1, a2, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < length(); i++) {
            string.append(data.get(i));
            if (i != length() - 1) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }
}
