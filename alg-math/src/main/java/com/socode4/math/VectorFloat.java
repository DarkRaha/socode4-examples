package com.socode4.math;

import static com.socode4.math.LinearAlgebra.*;
import static java.lang.Math.*;

/**
 * Vector in 3D space. For working with the transformation matrix vector has
 * four coordinates, where fourth coordinate d=1.
 */
public class VectorFloat {
    /**
     * Coordinates of vector
     */
    private final float[] v = new float[4];

    /**
     * Create new zero vector.
     */
    public VectorFloat() {
        v[0] = 0;
        v[1] = 0;
        v[2] = 0;
        v[3] = 1;
    }

    public VectorFloat(float x, float y, float z) {
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = 1;
    }

    public VectorFloat(float x, float y, float z, float d) {
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = d;
    }

    public void set(float x, float y, float z, float d) {
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = d;
    }

    public void set(float x, float y, float z) {
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = 1;
    }

    public void set(VectorFloat b) {
        v[0] = b.v[0];
        v[1] = b.v[1];
        v[2] = b.v[2];
        v[3] = b.v[3];
    }

    public float getX() {
        return v[0];
    }

    public float getY() {
        return v[1];
    }

    public float getZ() {
        return v[2];
    }

    public float getD() {
        return v[3];
    }

    /**
     * Add vector to this vector.
     *
     * @param b
     */
    public void add(VectorFloat b) {
        v[0] += b.v[0];
        v[1] += b.v[1];
        v[2] += b.v[3];
    }

    /**
     * Substract vector from this vector
     *
     * @param b
     */
    public void sub(VectorFloat b) {
        v[0] -= b.v[0];
        v[1] -= b.v[1];
        v[2] -= b.v[3];
    }

    /**
     * Multiply vector to specified scalar value.
     *
     * @param val
     */
    public void mul(double val) {
        v[0] *= val;
        v[1] *= val;
        v[2] *= val;
    }

    /**
     * Divides vector by the specified scalar value.
     *
     * @param val
     */
    public void div(double val) {
        v[0] /= val;
        v[1] /= val;
        v[2] /= val;
    }

    public float getDotProduct(VectorFloat b) {
        return dotV4(v, b.v);
    }

    public VectorFloat getCrossProduct(VectorFloat b) {
        VectorFloat ret = new VectorFloat();
        crossV3(v, b.v, ret.v);
        return ret;
    }

    /**
     * Get norm (length) of vector.
     *
     * @return
     */
    public float getNorm() {
        return normV3(v);
    }

    /**
     * Normalize vector
     */
    public void normalize() {
        normalizeV3(v);
    }

    /**
     * Get cosine between this vector and x-axis.
     *
     * @return
     */
    public float getCosX() {
        return v[0] / getNorm();
    }

    /**
     * Get cosine between this vector and y-axis.
     *
     * @return
     */
    public float getCosY() {
        return v[1] / getNorm();
    }

    /**
     * Get cosine between this vector and z-axis.
     *
     * @return
     */
    public float getCosZ() {
        return v[2] / getNorm();
    }

    /**
     * Get cosine between this vector and specified vector.
     *
     * @param b
     * @return
     */
    public float getCosV(VectorFloat b) {
        return cosV3(v, b.v);
    }

    /**
     * Checks if this vector is collinear with the specified vector.
     *
     * @param b
     * @return
     */
    public boolean isCollinear(VectorFloat b) {
        return isCollinearV3(v, b.v);
    }

    public boolean isCollinearCodirected(VectorFloat b) {
        return isCollinearCodirectedV3(v, b.v);
    }

    /**
     * Computes scalar triple product of this vector and two specified vectors.
     * It is also the signed volume of the parallelepiped defined by three vectors.
     *
     * @param b
     * @param c
     * @return
     */
    public float getTripleProduct(VectorFloat b, VectorFloat c) {
        return tripleV3(v, b.v, c.v);
    }

    /**
     * Checks if this vector and two specified vector lie on the same plane.
     *
     * @param b
     * @param c
     * @return
     */
    public boolean isCoplanar(VectorFloat b, VectorFloat c) {
        return abs(tripleV3(v, b.v, c.v)) <= EPS;
    }

    /**
     * Checks if this vector and two specified vectors form the right-handed coordinate system.
     *
     * @param b
     * @param c
     * @return
     */
    public boolean isRightHanded(VectorFloat b, VectorFloat c) {
        return tripleV3(v, b.v, c.v) > 0;
    }


    /**
     * Move from homogeneous coordinates to 3D.
     */
    public void to3D() {
        v[X] /= v[D];
        v[Y]/=v[D];
        v[Z]/=v[D];
        v[D] = 1;
    }

    /**
     * @param halfWidthOfScreen
     * @param direction         usually any positive value dependent x-axis direction
     * @return
     */
    public int getScreenX(int halfWidthOfScreen, int direction) {
        return (int) (signum(direction) * v[0] / v[D] * halfWidthOfScreen + halfWidthOfScreen);
    }

    /**
     * @param halfHeightOfScreen
     * @param direction          positive or negative value dependent y-axis direction
     * @return
     */
    public int getScreenY(int halfHeightOfScreen, int direction) {
        return (int) (signum(direction) * v[1] / v[D] * halfHeightOfScreen + halfHeightOfScreen);
    }

}
