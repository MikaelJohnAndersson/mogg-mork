package com.mogg.mork;

import com.mogg.mork.entities.MorkEnemy;
import com.mogg.mork.entities.MorkPlayer;
import com.mogg.mork.ui.MorkJournal;

public class MorkBattle {
    private final MorkPlayer player;
    private final MorkEnemy enemy;

    public MorkBattle(MorkPlayer player, MorkEnemy enemy) {
        this.player = player;
        this.enemy = enemy;

        MorkJournal.getInstance().appendText(
                String.format("In battle with a %s, roll for attack.", enemy.getName())
        );
        MorkJournal.getInstance().appendText(
                String.format("%s HP: %d", enemy.getName(), enemy.getHp())
        );
    }

    public MorkEnemy getEnemy() {
        return this.enemy;
    }

    public void playerRoll(int roll) {
        MorkJournal.getInstance().appendText(
                String.format("You rolled %d", roll)
        );

        int dmgRoll = this.player.rollD4();

        if (roll >= this.enemy.getXp()) {
            MorkJournal.getInstance().appendText(
                    String.format("%s has %d points", this.enemy.getName(), this.enemy.getXp())
            );
            MorkJournal.getInstance().appendText(
                    String.format("You rolled damage roll %d", dmgRoll)
            );
            this.enemy.takeDmg(this.player.rollD4());
        } else {
            MorkJournal.getInstance().appendText(
                    "Did not roll over enemy points"
            );
            this.player.takeDmg(dmgRoll);
        }

        if (this.enemy.getHp() == 0) {
            MorkJournal.getInstance().appendText(
                    String.format("Killed %s", enemy.getName())
            );
            this.player.gainXp(this.enemy.getXp());
            MorkJournal.getInstance().appendText(
                    String.format("Gained %d XP", enemy.getXp())
            );
            this.player.setBattle(null);
        } else {
            MorkJournal.getInstance().appendText(
                    String.format("%s HP: %d", enemy.getName(), enemy.getHp())
            );
        }
    }
}
