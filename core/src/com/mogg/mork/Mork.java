package com.mogg.mork;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mogg.mork.entities.MorkPlayer;
import com.mogg.mork.rooms.MorkRoom;
import com.mogg.mork.ui.MorkInventoryPanel;
import com.mogg.mork.ui.MorkJournal;

// Mork is our main class. It extends ApplicationAdapter, containing lifecycle methods for the application.
// https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/ApplicationAdapter.html
public class Mork extends ApplicationAdapter {
	Stage stage;
	MorkPlayer player;
	MorkInventoryPanel inventoryPanel;

	// create() is called when the application is first created
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		this.player = new MorkPlayer();

		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

		// Create a table that fills the screen. Everything else will go inside this table.
		Table table = new Table();
		// table.setDebug(true);
		table.setFillParent(true);
		stage.addActor(table);

		final Container container = new Container(MorkJournal.getInstance()).pad(10).left().top();
		ScrollPane scrollPane = new ScrollPane(container, skin);
		table.add(scrollPane).expand().fill();

		this.inventoryPanel = (MorkInventoryPanel) new MorkInventoryPanel(this.player, skin).pad(10).right().top();
		table.add(this.inventoryPanel).expandY().fill();
		table.row();

		Table table3 = new Table();
		final Label battlePaneLabel = new Label("Battle:", skin);
		table3.add(battlePaneLabel).left().top();
		table.add(table3);
		table.row();

		Table table2 = new Table();
		final TextButton rollButton = new TextButton("Roll", skin);
		rollButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				player.rollD6();
			}
		});

		table2.add(rollButton).pad(10);

		final TextButton roomButton = new TextButton("Go to next room", skin);
		roomButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (!player.inBattle()) {
					player.openRoom(new MorkRoom(player));
				}
			}
		});

		table2.add(roomButton).pad(10);

		table.add(table2).expandX().fill();

		player.openRoom(new MorkRoom(player));

//		final TextField textField = new TextField("TEXT_INPUT", skin);
//		table.add(textField).height(50).colspan(2).expandX().fill();
	}

	// render() is called on each frame
	@Override
	public void render () {
		this.inventoryPanel.update();

		ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

//	@Override
//	public void resize (int width, int height) {
//		stage.getViewport().update(width, height, true);
//	}

	// dispose() is called when the application exists. Should contain cleanup for assets (removal from memory).
	@Override
	public void dispose () {
	}
}
