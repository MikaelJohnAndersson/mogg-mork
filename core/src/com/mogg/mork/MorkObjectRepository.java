package com.mogg.mork;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.mogg.mork.entities.MorkEnemy;
import com.mogg.mork.utils.MorkDeserializer;

import java.util.ArrayList;

public class MorkObjectRepository {
    private final Json json = new Json();
    private static final MorkObjectRepository instance = new MorkObjectRepository();
    private final ArrayList<JsonValue> enemies;

    private MorkObjectRepository() {
        this.enemies = MorkDeserializer.deserializeEnemies();
    }

    public static MorkObjectRepository getInstance() {
        return instance;
    }

    public MorkEnemy getRandomEnemy() {
        int max = this.enemies.size() - 1;
        int min = 0;
        int rand = (int)Math.floor(Math.random()*(max-min+1)+min);

        return this.json.fromJson(MorkEnemy.class, String.valueOf(this.enemies.get(rand)));
    }
}
