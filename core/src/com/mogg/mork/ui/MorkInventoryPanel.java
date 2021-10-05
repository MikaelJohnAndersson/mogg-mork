package com.mogg.mork.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.mogg.mork.entities.MorkPlayer;

public class MorkInventoryPanel extends Table {
    private final MorkPlayer player;
    private final Label hpValueLabel;
    private final Label xpValueLabel;
    private final Label silverValueLabel;
    private final Label roomsExploredLabel;

    public MorkInventoryPanel(MorkPlayer player, Skin skin) {
        super();

        this.player = player;

        // Create HP stats
        final Label hpDescLabel = new Label("HP", skin);
        this.add(hpDescLabel).left().expandX();

        this.hpValueLabel = new Label(String.valueOf(this.player.getHp()), skin);
        this.hpValueLabel.setAlignment(Align.right);
        this.add(hpValueLabel).right().expandX();
        this.row();

        // Create XP stats
        final Label xpDescLabel = new Label("XP", skin);
        this.add(xpDescLabel).left().expandX();

        this.xpValueLabel = new Label(String.valueOf(this.player.getXp()), skin);
        this.xpValueLabel.setAlignment(Align.right);
        this.add(xpValueLabel).right().expandX();
        this.row();

        // Create silver stats
        final Label silverDescLabel = new Label("Silver", skin);
        this.add(silverDescLabel).left().expandX();

        this.silverValueLabel = new Label(String.valueOf(this.player.getSilver()), skin);
        this.silverValueLabel.setAlignment(Align.right);
        this.add(silverValueLabel).right().expandX();
        this.row();

        // Create rooms explored stats
        final Label roomsExpDescLabel = new Label("Rooms explored", skin);
        this.add(roomsExpDescLabel).left().expandX();

        this.roomsExploredLabel = new Label(String.valueOf(this.player.getRoomsExplored()), skin);
        this.roomsExploredLabel.setAlignment(Align.right);
        this.add(roomsExploredLabel).right().expandX();
        this.row();
    }

    public void update() {
        this.hpValueLabel.setText(String.valueOf(this.player.getHp()));
        this.xpValueLabel.setText(String.valueOf(this.player.getXp()));
        this.silverValueLabel.setText(String.valueOf(this.player.getSilver()));
        this.roomsExploredLabel.setText(String.valueOf(this.player.getRoomsExplored()));
    }
}
