package com.socode4.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixFloatTest {

    @Test
    public void testTranspose() {
        MatrixFloat m = getTestMatrix();
        MatrixFloat expected = new MatrixFloat();
        float[] t = new float[4];

        expected.setRow(0, 11, 21, 31, 41);
        expected.setRow(1, 12, 22, 32, 42);
        expected.setRow(2, 13, 23, 33, 43);
        expected.setRow(3, 14, 24, 34, 44);
        m.transpose();
        assertArrayEquals(expected.m, m.m, 0f);
    }

    @Test
    public void translate() {
        MatrixFloat m = new MatrixFloat();
        m.translate(10, 12, 13);
        float[] v = {5, 5, 5, 1};
        float[] expected = {15, 17, 18, 1};

        float[] t = LinearAlgebra.mulMatrixVector(m.m, v);

        assertArrayEquals(expected, t, 0.01f);
    }

    @Test
    public void scale() {
        MatrixFloat m = new MatrixFloat();
        m.scale(2, 4, 8);
        float[] v = {5, 5, 5, 1};
        float[] expected = {10, 20, 40, 1};
        float[] t = LinearAlgebra.mulMatrixVector(m.m, v);
        assertArrayEquals(expected, t, 0.01f);
    }

    @Test
    public void rotateZ() {
        MatrixFloat m = new MatrixFloat();
        float alpha = 30 * LinearAlgebra.TO_RAD_F;
        m.rotateZ(alpha);
        float[] v = {5, 5, 5, 1};
        float[] expected = {
                (float) (v[0] * Math.cos(alpha)),
                (float) (v[1] * Math.sin(alpha)),
                v[2], 1};
    }


    public MatrixFloat getTestMatrix() {
        MatrixFloat m = new MatrixFloat();
        m.setRow(0, 11, 12, 13, 14);
        m.setRow(1, 21, 22, 23, 24);
        m.setRow(2, 31, 32, 33, 34);
        m.setRow(3, 41, 42, 43, 44);
        return m;
    }

}