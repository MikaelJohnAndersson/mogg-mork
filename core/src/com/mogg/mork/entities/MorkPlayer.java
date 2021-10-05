package com.mogg.mork.entities;

import com.mogg.mork.MorkBattle;
import com.mogg.mork.MorkDie;
import com.mogg.mork.rooms.MorkRoom;
import com.mogg.mork.ui.MorkJournal;

import java.util.ArrayList;

public class MorkPlayer extends MorkCharacter {
    private int silver;
    private MorkBattle battle;
    private MorkRoom currentRoom;
    private ArrayList<MorkRoom> roomsExplored;
    private MorkDie d4;

    public MorkPlayer() {
        super(20, 0);
        this.silver = 15;
        this.roomsExplored = new ArrayList<>();
        this.battle = null;
        this.d4 = new MorkDie(4);
    }

    public int getSilver() {
        return silver;
    }

    public int getRoomsExplored() {
        return roomsExplored.size();
    }

    public int rollD6() {
        int roll = super.rollD6();
        if (this.inBattle()) {
            this.battle.playerRoll(roll);
        }
        return roll;
    }

    public int rollD4() {
        return this.d4.roll();
    }

    public void openRoom(MorkRoom room) {
        this.currentRoom = room;
        this.battle = currentRoom.getBattle();
        this.roomsExplored.add(room);
    }

    public boolean inBattle() {
        return this.battle != null;
    }

    public MorkBattle getBattle() {
        return this.battle;
    }

    public void setBattle(MorkBattle battle) {
        this.battle = battle;
    }

    public void gainXp(int xpGained) {
        this.xp = this.xp + xpGained;
    }

    public void takeDmg(int dmg) {
        MorkJournal.getInstance().appendText(
                String.format("You take %d damage", dmg)
        );

        this.hp = Math.max((this.hp - dmg), 0);
    }
}
