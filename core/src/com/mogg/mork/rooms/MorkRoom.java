package com.mogg.mork.rooms;

import com.mogg.mork.MorkBattle;
import com.mogg.mork.MorkDie;
import com.mogg.mork.MorkObjectRepository;
import com.mogg.mork.entities.MorkEnemy;
import com.mogg.mork.entities.MorkPlayer;
import com.mogg.mork.ui.MorkJournal;

public class MorkRoom {
    private int noDoors;
    private final MorkBattle battle;
    private MorkPlayer player;

    public MorkRoom() {
        // TODO: Should not happen, prevent default constructor?
        this.noDoors = this.rollDoors();
        this.battle = null;
        this.player = null;
    }

    public MorkRoom(MorkPlayer player) {
        super();
        this.player = player;
        MorkJournal.getInstance().appendText(
                "You enter a new room"
        );

        int roll = MorkDie.rollStatic();
        if (roll % 2 == 0) {
            this.battle = this.generateBattle();
        } else {
            this.battle = null;
            MorkJournal.getInstance().appendText(
                    "Nothing in particular in this room"
            );
        }
    }

    public MorkRoom(int noDoors, MorkBattle battle) {
        this.noDoors = noDoors;
        this.battle = battle;
    }

    private int rollDoors() {
        int max = 4;
        int min = 1;

        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public MorkBattle generateBattle() {
        MorkEnemy enemy = MorkObjectRepository.getInstance().getRandomEnemy();
        return new MorkBattle(this.player, enemy);
    }

    public MorkBattle getBattle() {
        return this.battle;
    }
}
