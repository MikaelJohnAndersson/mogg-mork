package com.mogg.mork.entities;

public class MorkEnemy extends MorkCharacter {
    private String name;

    public MorkEnemy() {
        super();
        this.name = "";
    }

    public MorkEnemy(String name, int hp, int xp) {
        super(hp, xp);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
