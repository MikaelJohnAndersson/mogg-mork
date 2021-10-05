package com.mogg.mork.entities;

import com.mogg.mork.MorkDie;

public abstract class MorkCharacter {
    protected int hp;
    protected int xp;
    protected MorkDie d6;

    public MorkCharacter() {
        this.hp = 0;
        this.xp = 0;
        this.d6 = new MorkDie();
    }

    public MorkCharacter(int hp, int xp) {
        this.hp = hp;
        this.xp = xp;
        this.d6 = new MorkDie();
    }

    public int rollD6() {
        return this.d6.roll();
    }

    public void takeDmg(int dmg) {
        this.hp = Math.max((this.hp - dmg), 0);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
