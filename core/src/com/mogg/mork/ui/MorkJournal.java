package com.mogg.mork.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;

public class MorkJournal extends Label {
    private final static ArrayList<String> log = new ArrayList<>();
    private final static MorkJournal instance = new MorkJournal();

    private MorkJournal() {
        super("", new Skin(Gdx.files.internal("uiskin.json")));
    }

    public static MorkJournal getInstance() {
        return instance;
    }

    public void appendText(String text) {
        log.add(text);
        StringBuilder sb = new StringBuilder();

        for (String s : log)
        {
            sb.append(s);
            sb.append("\n");
        }

        this.setText(sb.toString());
    }
}
