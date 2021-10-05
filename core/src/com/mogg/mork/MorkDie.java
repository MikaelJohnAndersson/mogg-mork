package com.mogg.mork;

public class MorkDie {
    private int max;

    public MorkDie() {
        this.max = 6;
    }

    public MorkDie(int max) {
        this.max = max;
    }

    public int roll() {
        return (int)(Math.random() * this.max) + 1;
    }

    public static int rollStatic() {
        return (int)(Math.random() * 6) + 1;
    }
}
