package com.socode4.math;

import java.util.Arrays;

public class LinearAlgebra {

    /**
     * Default precision
     */
    public static final float EPS = 0.00001f;

    public static final int X = 0, Y = 1, Z = 2, D = 3;

    public static final int
            EL0_0 = 0, EL0_1 = 1, EL0_2 = 2, EL0_3 = 3,
            EL1_0 = 4, EL1_1 = 5, EL1_2 = 6, EL1_3 = 7,
            EL2_0 = 8, EL2_1 = 9, EL2_2 = 10, EL2_3 = 11,
            EL3_0 = 12, EL3_1 = 13, EL3_2 = 14, EL3_3 = 15;


    public static final float TO_RAD_F = (float) (Math.PI / 180);
    public static final float TO_DEGREE_F = 1 / TO_RAD_F;

    //------------------------------------------------------------------------------------------
    // float

    public static void sumV3(float[] v1, float[] v2, float[] dst) {
        dst[0] = v1[0] + v2[0];
        dst[1] = v1[1] + v2[1];
        dst[2] = v1[2] + v2[2];
    }

    public static void subV3(float[] v1, float[] v2, float[] dst) {
        dst[0] = v1[0] - v2[0];
        dst[1] = v1[1] - v2[1];
        dst[2] = v1[2] - v2[2];
    }

    public static void mulVectorScalar(float[] v, float scalar) {
        v[0] *= scalar;
        v[1] *= scalar;
        v[2] *= scalar;
        v[3] *= scalar;
    }


    /**
     * Checks,  is two vectors are collinear.
     *
     * @param v1
     * @param v2
     * @param eps precision, number like 0.0001f
     * @return
     */
    public static boolean isCollinearV3(float[] v1, float[] v2, float eps) {
        return Math.abs(v1[0] / v2[0] - v1[1] / v2[1]) < eps &&
                Math.abs(v1[1] / v2[1] - v1[2] / v2[2]) < eps;
    }

    public static boolean isCollinearV3(float[] v1, float[] v2) {
        return isCollinearV3(v1, v2, EPS);
    }

    /**
     * Checks, is two vectors are collinear and have same direction.
     *
     * @param v1
     * @param v2
     * @param eps precision, number like 0.0001f
     * @return
     */
    public static boolean isCollinearCodirectedV3(float[] v1, float[] v2, float eps) {
        float f = v1[1] / v2[1];
        return Math.abs(v1[0] / v2[0] - f) < eps &&
                Math.abs(f - v1[2] / v2[2]) < eps && f > 0;
    }

    public static boolean isCollinearCodirectedV3(float[] v1, float[] v2) {
        return isCollinearCodirectedV3(v1, v2, EPS);
    }

    /**
     * Computes length of given vector.
     *
     * @param v
     * @return
     */
    public static float normV3(float[] v) {
        return (float) Math.sqrt((v[0] * v[0] + v[1] * v[1] + v[2] * v[2]));
    }

    /**
     * Normalize given vector.
     *
     * @param v
     */
    public static void normalizeV3(float[] v) {
        float len = (float) Math.sqrt((v[0] * v[0] + v[1] * v[1] + v[2] * v[2]));
        v[0] /= len;
        v[1] /= len;
        v[2] /= len;
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param v1
     * @param v2
     * @return
     */
    public static float dotV3(float[] v1, float[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param v1
     * @param v2
     * @return
     */
    public static float dotV4(float[] v1, float[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2] + v1[3] * v2[3];
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param v1
     * @param offset1
     * @param v2
     * @param offset2
     * @return
     */
    public static float dotV4(float[] v1, int offset1, float[] v2, int offset2) {
        return v1[offset1] * v2[offset2]
                + v1[offset1 + 1] * v2[offset2 + 1]
                + v1[offset1 + 2] * v2[offset2 + 2]
                + v1[offset1 + 3] * v2[offset2 + 3];
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param v
     * @param v2_0
     * @param v2_1
     * @param v2_2
     * @param v2_3
     * @return
     */
    public static float dotV4(float[] v, float v2_0, float v2_1, float v2_2, float v2_3) {
        return v[0] * v2_0 + v[1] * v2_1 + v[2] * v2_2 + v[3] * v2_3;
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param v      array with first vector
     * @param offset offset of x coordinate of first vector
     * @param v2_0   x coordinate of second vector
     * @param v2_1   y coordinate of second vector
     * @param v2_2   z coordinate of second vector
     * @param v2_3
     * @return
     */
    public static float dotV4(float[] v, int offset, float v2_0, float v2_1, float v2_2, float v2_3) {
        return v[offset] * v2_0 + v[offset + 1] * v2_1 + v[offset + 2] * v2_2 + v[offset + 3] * v2_3;
    }

    /**
     * Calculates the dot product of two vectors that specified by their coordinates.
     *
     * @param v1_0
     * @param v1_1
     * @param v1_2
     * @param v1_3
     * @param v2_0
     * @param v2_1
     * @param v2_2
     * @param v2_3
     * @return
     */
    public static float dotV4(float v1_0, float v1_1, float v1_2, float v1_3,
                              float v2_0, float v2_1, float v2_2, float v2_3) {
        return v1_0 * v2_0 + v1_1 * v2_1 + v1_2 * v2_2 + v1_3 * v2_3;
    }


    public static void crossV3(float[] v1, float[] v2, float[] dst) {
        float x = v1[Y] * v2[Z] - v1[Z] * v2[Y];
        float y = v1[Z] * v2[X] - v1[X] * v2[Z];
        float z = v1[X] * v2[Y] - v1[Y] * v2[X];
        dst[0] = x;
        dst[1] = y;
        dst[2] = z;
    }


    /**
     * Computes cos of angle between two vectors.
     *
     * @param v1 first vector
     * @param v2 second vector
     * @return
     */
    public static float cosV3(float[] v1, float[] v2) {
        float dot3 = dotV3(v1, v2);
        float norm1 = normV3(v1);
        float norm2 = normV3(v2);
        return dot3 / (norm1 * norm2);
    }


    /**
     * Computes cos of angle between vector and x-axis
     *
     * @param v
     * @return
     */
    public static float cosxV3(float[] v) {
        return v[0] / normV3(v);
    }

    /**
     * Computes cos of angle between vector and y-axis
     *
     * @param v
     * @return
     */
    public static float cosyV3(float[] v) {
        return v[1] / normV3(v);
    }

    /**
     * Computes cos of angle between vector and z-axis
     *
     * @param v
     * @return
     */
    public static float coszV3(float[] v) {
        return v[2] / normV3(v);
    }

    /**
     * Computes scalar triple production, i.e det(v1,v2,v3).
     *
     * @param v1 first vector
     * @param v2 second vector
     * @param v3 third vector
     * @return
     */
    public static float tripleV3(float[] v1, float[] v2, float[] v3) {
        return v1[0] * v2[1] * v3[2] +
                v1[1] * v2[2] * v3[0] +
                v1[2] * v2[0] * v3[1] -
                v1[2] * v2[1] * v3[0] -
                v1[0] * v2[2] * v3[1] -
                v1[1] * v2[0] * v3[2];
    }

    /**
     * @param mColMajor
     * @param v
     * @param dst
     */
    public static void mulMatrixVector(float[] mColMajor, float[] v, float[] dst) {
        dst[0] = dotV4(mColMajor, 0, v, 0);
        dst[1] = dotV4(mColMajor, 4, v, 0);
        dst[2] = dotV4(mColMajor, 8, v, 0);
        dst[3] = dotV4(mColMajor, 12, v, 0);
    }

    public static float[] mulMatrixVector(float[] mColMajor, float[] v) {
        float[] dst = new float[4];
        mulMatrixVector(mColMajor, v, dst);
        return dst;
    }

    /**
     * @param mRowMajor
     * @param v
     * @param dst
     */
    public static void mulVectorMatrix(float[] mRowMajor, float[] v, float[] dst) {
        dst[0] = dotV4(v, mRowMajor[0], mRowMajor[EL1_0], mRowMajor[EL2_0], mRowMajor[EL3_0]);
        dst[1] = dotV4(v, mRowMajor[EL0_1], mRowMajor[EL1_1], mRowMajor[EL2_1], mRowMajor[EL3_1]);
        dst[2] = dotV4(v, mRowMajor[EL0_2], mRowMajor[EL1_2], mRowMajor[EL2_2], mRowMajor[EL3_2]);
        dst[3] = dotV4(v, mRowMajor[EL0_3], mRowMajor[EL1_3], mRowMajor[EL2_3], mRowMajor[EL3_3]);
    }

    public static float[] mulVectorMatrix(float[] mRowMajor, float[] v) {
        float[] dst = new float[4];
        mulVectorMatrix(mRowMajor, v, dst);
        return dst;
    }

    /**
     * Multiply each element on specified value.
     *
     * @param v      matrix, array with length 16
     * @param scalar
     */
    public static void mulMatrixScalar(float[] v, float scalar) {
        for (int i = 0; i < 16; ++i) {
            v[i] *= scalar;
        }
    }

    /**
     * Multiply two matrices and save result in specified matrix
     *
     * @param m1  first matrix,  array with length 16
     * @param m2  second matrix,  array with length 16
     * @param dst matrix for result, array with length 16
     */
    public static void mulMatrix44(float[] m1, float[] m2, float[] dst) {
        int indEl = 0;
        for (int row = 0; row < 4; ++row)
            for (int col = 0; col < 4; ++col, ++indEl) {
                dst[indEl] = dotV4(m1, row * 4, m2[col], m2[col + 4], m2[col + 8], m2[col + 12]);
            }
    }

    public static float[] mulMatrix44(float[] m1, float[] m2) {
        float[] dst = new float[16];
        mulMatrix44(m1, m2, dst);
        return dst;
    }

    public static void transposeMatrix44(float[] m) {
        for (int i = 0; i < 4; ++i)
            for (int j = i + 1; j < 4; ++j) {
                int iInd = i + j * 4;
                int jInd = j + i * 4;

                final float t = m[iInd];
                m[iInd] = m[jInd];
                m[jInd] = t;
            }
    }

    /**
     * After projection operation you can get homogenous coordinate (forth coordinate != 1).
     *
     * @param v
     */
    public static void to3DV4(float[] v) {
        v[0] /= v[4];
        v[1] /= v[4];
        v[2] /= v[4];
        v[3] = 1;
    }

}
