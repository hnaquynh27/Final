package com.vector;

public class TestVectors {
    public static void main(String[] args) {
        /* TODO */
        double[] i = new double[]{1, 2, 3, 4, 5};
        ArrayVector arrayVector1 = new ArrayVector(i);
        ArrayVector arrayVector2 = new ArrayVector(new double[]{});
        for (double j : arrayVector1.elements()) {
            arrayVector2.append(-j);
        }
        System.out.println(arrayVector2.magnitude());
        System.out.println(arrayVector1.distanceTo(arrayVector2));
        System.out.println(arrayVector1.dot(arrayVector2));
        System.out.println(arrayVector1.plus(arrayVector2));
        System.out.println(arrayVector1.minus(arrayVector2));
        arrayVector1.insert(6, 0);
        arrayVector1.remove(6);
        System.out.println(arrayVector1);
    }
}
