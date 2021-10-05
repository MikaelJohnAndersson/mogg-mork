package com.mogg.mork.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mogg.mork.Mork;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Mork";
		config.height = 700;
		config.width = 1000;
		new LwjglApplication(new Mork(), config);
	}
}
