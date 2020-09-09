package com.socode4.math;

import java.util.Arrays;

import static com.socode4.math.LinearAlgebra.*;
import static java.lang.Math.*;

/**
 *
 */
public class MatrixFloat {

    protected float[] m = new float[16];

    public MatrixFloat() {
    }

    public MatrixFloat(float[] nm) {
        System.arraycopy(nm, 0, m, 0, 16);
    }

    public void set(float[] nm) {
        System.arraycopy(nm, 0, m, 0, 16);
    }

    public void set(MatrixFloat b) {
        System.arraycopy(b.m, 0, m, 0, 16);
    }

    public MatrixFloat copy() {
        return new MatrixFloat(m);
    }

    public void setRow(int row, float m0, float m1, float m2, float m3) {
        row *= 4;
        m[row++] = m0;
        m[row++] = m1;
        m[row++] = m2;
        m[row] = m3;
    }

    public void setCol(int col, float m0, float m1, float m2, float m3) {
        m[col] = m0;
        m[col + 4] = m1;
        m[col + 8] = m2;
        m[col + 12] = m3;
    }

    public void setRow(int row, float[] src, int pos) {
        row *= 4;
        m[row++] = src[pos++];
        m[row++] = src[pos++];
        m[row++] = src[pos++];
        m[row] = src[pos];
    }

    public void setCol(int col, float[] src, int pos) {
        m[col] = src[pos++];
        m[col + 4] = src[pos++];
        m[col + 8] = src[pos++];
        m[col + 12] = src[pos];
    }

    public void copyRowTo(int row, float[] dst, int pos) {
        row *= 4;
        dst[pos++] = m[row++];
        dst[pos++] = m[row++];
        dst[pos++] = m[row++];
        dst[pos] = m[row];
    }

    public void copyColTo(int col, float[] dst, int pos) {
        dst[pos++] = m[col];
        dst[pos++] = m[col + 4];
        dst[pos++] = m[col + 8];
        dst[pos] = m[col + 12];
    }

    public float getEl(int row, int col) {
        return m[row * 4 + col];
    }

    public void setEl(int row, int col, float v) {
        m[row * 4 + col] = v;
    }

    public void swap(int ix, int iy, int jx, int jy) {
        int iInd = ix + iy * 4;
        int jInd = jx + jy * 4;

        final float t = m[iInd];
        m[iInd] = m[jInd];
        m[jInd] = t;
    }

    public void zero() {
        Arrays.fill(m, 0);
    }

    public void identity() {
        Arrays.fill(m, 0);
        m[EL0_0] = 1;
        m[EL1_1] = 1;
        m[EL2_2] = 1;
        m[EL3_3] = 1;
    }

    public void transpose() {
        for (int i = 0; i < 4; ++i)
            for (int j = i + 1; j < 4; ++j)
                swap(i, j, j, i);
    }

    //=====================================================================================
    public float mulRow(int r, float[] v) {
        r *= 4;
        return dotV4(v, m[r], m[r + 1], m[r + 2], m[r + 3]);
    }

    public float mulCol(int col, float[] v) {
        return dotV4(v, m[col], m[col + 4], m[col + 8], m[col + 12]);
    }

    public void multiply(MatrixFloat mf) {
        set(mulMatrix44(m, mf.m));
    }

    public void premultiply(MatrixFloat mf) {
        set(mulMatrix44(mf.m, m));
    }

    public float[] mulVector(float [] v){
       return mulMatrixVector(m, v);
    }

    public float[] premulVector(float [] v){
        return mulVectorMatrix(m,v);
    }

    public void mulScalar(float val) {
        mulMatrixScalar(m, val);
    }
    //=====================================================================================
    public void translate(float dx, float dy, float dz) {
        setRow(0, 1, 0, 0, dx);
        setRow(1, 0, 1, 0, dy);
        setRow(2, 0, 0, 1, dz);
        setRow(3, 0, 0, 0, 1);
    }

    /**
     * Sets the position component of this matrix.
     *
     * @param dx
     * @param dy
     * @param dz
     */
    public void setPos(float dx, float dy, float dz) {
        m[EL0_3] = dx;
        m[EL1_3] = dy;
        m[EL2_3] = dz;
    }

    public void scale(float sx, float sy, float sz) {
        setRow(0, sx, 0, 0, 0);
        setRow(1, 0, sy, 0, 0);
        setRow(2, 0, 0, sz, 0);
        setRow(3, 0, 0, 0, 1);
    }

    /**
     * Sets the scale component of this matrix.
     *
     * @param sx
     * @param sy
     * @param sz
     */
    public void setScale(float sx, float sy, float sz) {
        m[EL0_0] = sx;
        m[EL1_1] = sy;
        m[EL2_2] = sz;
    }

    /**
     * Rotate around z-axis
     *
     * @param angleRad
     */
    public void rotateZ(float angleRad) {
        setRow(0, (float) cos(angleRad), (float) -sin(angleRad), 0, 0);
        setRow(1, (float) sin(angleRad), (float) cos(angleRad), 1, 0);
        setRow(2, 0, 0, 1, 0);
        setRow(3, 0, 0, 0, 1);
    }

    /**
     * Rotate around x-axis
     *
     * @param angleRad
     */
    public void rotateX(float angleRad) {
        setRow(0, 1, 0, 0, 0);
        setRow(1, 0, (float) cos(angleRad), (float) -sin(angleRad), 0);
        setRow(2, 0, (float) sin(angleRad), (float) cos(angleRad), 0);
        setRow(3, 0, 0, 0, 1);
    }

    /**
     * Rotate around y-axis
     *
     * @param angleRad
     */
    public void rotateY(float angleRad) {
        setRow(0, (float) cos(angleRad), 0, (float) sin(angleRad), 0);
        setRow(1, 0, 1, 0, 0);
        setRow(2, (float) -sin(angleRad), 0, (float) cos(angleRad), 0);
        setRow(3, 0, 0, 0, 1);
    }

    /**
     * v(x,y,z) must be normalized.
     *
     * @param vx
     * @param vy
     * @param vz
     * @param angleRad
     */
    public void rotateAxis(float vx, float vy, float vz, float angleRad) {
        float c = (float) cos(angleRad);
        float s = (float) sin(angleRad);
        float t = 1 - c;

        setRow(0, vx * vx * t + c, t * vx * vy - s * vz, t * vx * vz + s * vy, 0);
        setRow(1, t * vx * vy + s * vz, vy * vy * t + c, t * vy * vz - s * vx, 0);
        setRow(2, t * vx * vz - s * vy, t * vy * vz + s * vx, vz * vz * t + c, 0);
        setRow(3, 0, 0, 0, 1);
    }

    public void shear(float shx, float shy, float shz) {
        setRow(0, 1, shy, shz, 0);
        setRow(1, shx, 1, shz, 0);
        setRow(2, shx, shy, 1, 0);
        setRow(3, 0, 0, 0, 1);
    }

    //=====================================================================================
    public void perspective(float left, float right, float top, float bottom, float near, float far) {
        float width = right - left;
        float height = top - bottom;
        float depth = far - near;
        setRow(0, 2 * near / width, 0, (right + left) / width, 0);
        setRow(1, 0, 2 * near / height, (top + bottom) / height, 0);
        setRow(2, 0, 0, (far + near) / -depth, -2 * far * near / depth);
        setRow(3, 0, 0, -1, 0);
    }

    public void orthographic(float left, float right, float top, float bottom, float near, float far) {
        float width = right - left;
        float height = top - bottom;
        float depth = far - near;
        setRow(0, 2 / width, 0, 0, (right + left) / width);
        setRow(1, 0, 2 / height, 0, (top + bottom) / height);
        setRow(2, 0, 0, -2 * far / depth, (far + near) / depth);
        setRow(3, 0, 0, 0, 1);
    }

    //=====================================================================================
    public String rowToString(int row) {
        int offset = row * 4;
        return " " + m[offset] + " " + m[offset + 1] + " "
                + m[offset + 2] + " " + m[offset + 3];
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "[" + rowToString(0) + "]\n" +
                "[" + rowToString(1) + "]\n" +
                "[" + rowToString(2) + "]\n" +
                "[" + rowToString(3) + "]\n" +
                '}';
    }
}
