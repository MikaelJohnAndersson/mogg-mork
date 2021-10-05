package com.mogg.mork.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mogg.mork.entities.MorkEnemy;

import java.util.ArrayList;

public class MorkDeserializer {
    private final static Json json = new Json();

    public static ArrayList<JsonValue> deserializeEnemies() {
        JsonReader jsonReader = new JsonReader();
        JsonValue base = jsonReader.parse(Gdx.files.internal("enemies.json"));
        ArrayList<JsonValue> enemiesJson = new ArrayList<>();
        for (JsonValue component : base) {
            enemiesJson.add(component);
        }
        return enemiesJson;
    }
}
