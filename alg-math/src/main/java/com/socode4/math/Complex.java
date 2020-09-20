package com.socode4.math;

/**
 * Simple complex number representation.
 */
public final class Complex {

    private double r = 0;
    private double i = 0;


    public Complex() {
    }

    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }


    public void set(double rr, double ii) {
        r = rr;
        i = ii;
    }

    /**
     * @return real part of complex number
     */
    public double getReal() {
        return r;
    }

    /**
     * @return imaginary part of complex number
     */
    public double getImg() {
        return i;
    }

    /**
     * Adds real number to this complex number.
     *
     * @param real
     */
    public void add(double real) {
        r += real;
    }

    /**
     * Adds complex number.
     *
     * @param real real part of complex number
     * @param img  imaginary part of complex number
     */
    public void add(double real, double img) {
        r += real;
        i += img;
    }

    /**
     * Adds complex number.
     *
     * @param b
     */
    public void add(Complex b) {
        set(r + b.r, i + b.i);
    }

    public void sub(double real) {
        r -= real;
    }

    public void sub(double real, double img) {
        r -= real;
        i -= img;
    }

    public void sub(Complex b) {
        set(r - b.r, i - b.i);
    }

    /**
     * Multiplies this complex number by the specified real number.
     *
     * @param real
     */
    public void mul(double real) {
        r *= real;
        i *= real;
    }

    /**
     * Multiplies this complex number by the specified complex number.
     *
     * @param b
     */
    public void mul(Complex b) {
        set(r * b.r - i * b.i, i * b.r + r * b.i);
    }

    public void pow2() {
        set(r * r - i * i, 2 * i * r);
    }

    public void powN(int n) {
        Complex t = new Complex(r, i);

        for (int i = 1; i < n; i++) {
            t.mul(this);
        }

        set(t.r, t.i);
    }

    /**
     * Divides this complex number by the specified real number.
     *
     * @param n
     */
    public void div(double n) {
        r /= n;
        i /= n;
    }

    /**
     * Divides this complex number by the specified complex number.
     *
     * @param b
     */
    public void div(Complex b) {
        set((r * b.r + i * b.i) / (b.r * b.r + b.i * b.i), (i * b.r - r * b.i)
                / (b.r * b.r + b.i * b.i));
    }

    /**
     * Calculates modulus of this complex number.
     *
     * @return
     */
    public double abs() {
        return Math.sqrt(r * r + i * i);
    }

    public double norm() {
        return r * r + i * i;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "r=" + r +
                ", i=" + i +
                '}';
    }
}
