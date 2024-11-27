package com.badlogic.sudoku;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final Sudoku game;
    Stage stage;
    Table table;
    Skin skin;


    public MainMenuScreen(final Sudoku game) {
        this.game = game;

        this.stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        this.table = new Table();
        table.setFillParent(true);
        table.top();

        Label label = new Label("UI test!", skin);
        TextButton button = new TextButton("Click Me!", skin);

        table.add(label).expandX().pad(10);
        table.row();
        table.add(button).expandX().pad(10);

        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();
        //draw text. Remember that x and y are in meters
        game.font.draw(game.batch, "Welcome to Sudoku!!! ", 100, 100);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 125);

        stage.act(delta);
        stage.draw();

        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }
}
