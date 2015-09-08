package com.celci2015.math;

/**
 * Created by pablo on 9/7/15.
 */
public class Tuple {
    private int multiplier;
    private int xExponent;
    private int yExponent;
    public Tuple(int pMultiplier, int pXExponent, int pYExponent) {
        multiplier = pMultiplier;
        xExponent = pXExponent;
        yExponent = pYExponent;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {

        return multiplier;
    }

    public int getxExponent() {
        return xExponent;
    }

    public int getyExponent() {
        return yExponent;
    }

    public int getValue()
    {

        return (int) (yExponent * Math.pow(10, Math.log10(yExponent)+1) + xExponent);
    }
}
