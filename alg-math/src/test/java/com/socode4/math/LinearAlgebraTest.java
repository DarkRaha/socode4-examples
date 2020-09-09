package com.socode4.math;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LinearAlgebraTest {

    @Test
    public void transposeMatrix44() {
        float[] m = new float[]{11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44};
        float[] expected = new float[]{11, 21, 31, 41, 12, 22, 32, 42, 13, 23, 33, 43, 14, 24, 34, 44};
        LinearAlgebra.transposeMatrix44(m);
        assertArrayEquals(expected, m, 0.01f);
    }

    @Test
    public void mulVectorScalar() {
        float[] v = new float[]{2, 2, 2, 1};
        float[] expected = new float[]{6, 6, 6, 3};
        LinearAlgebra.mulVectorScalar(v, 3);
        assertArrayEquals(expected, v, 0.01f);
    }

    @Test
    public void mulMatrixScalar() {
        float[] m = new float[16];
        Arrays.fill(m, 2);
        float[] expected = new float[16];
        Arrays.fill(expected, 6);
        LinearAlgebra.mulMatrixScalar(m, 3);
        assertArrayEquals(expected, m, 0.01f);
    }

    @Test
    public void dotV4() {
        float[] v1 = new float[]{2, 3, 4, 1};
        float[] v2 = new float[]{20, 30, 40, 1};
        float expected = 2 * 20 + 3 * 30 + 4 * 40 + 1;
        assertTrue(LinearAlgebra.dotV4(v1, v2) == expected);
        assertTrue(LinearAlgebra.dotV4(v1, 20f, 30f, 40f, 1f) == expected);
        assertTrue(LinearAlgebra.dotV4(v1, 0, 20f, 30f, 40f, 1f) == expected);
        assertTrue(LinearAlgebra.dotV4(2, 3, 4, 1, 20, 30, 40, 1) == expected);
    }


    @Test
    public void mulMatrixVector() {
        float[] m = new float[]{ // translate  20,25,30
                1, 0, 0, 20,
                0, 1, 0, 25,
                0, 0, 1, 30,
                0, 0, 0, 1
        };

        float[] v = new float[]{10, 10, 10, 1};
        float[] expected = new float[]{30, 35, 40, 1};
        float[] result = LinearAlgebra.mulMatrixVector(m, v);

        assertArrayEquals(expected, result, 0.01f);
    }

    @Test
    public void mulVectorMatrix() {
        float[] m = new float[]{ // translate  20,25,30
                1, 0, 0, 20,
                0, 1, 0, 25,
                0, 0, 1, 30,
                0, 0, 0, 1
        };

        LinearAlgebra.transposeMatrix44(m);

        float[] v = new float[]{10, 10, 10, 1};
        float[] expected = new float[]{30, 35, 40, 1};
        float[] result = LinearAlgebra.mulVectorMatrix(m, v);

        assertArrayEquals(expected, result, 0.01f);
    }

}