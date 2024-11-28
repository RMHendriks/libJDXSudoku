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

    TextButton startButton;
    TextButton optionsButton;
    TextButton scoreButton;
    TextButton exitButton;


    public MainMenuScreen(final Sudoku game) {
        this.game = game;

        this.stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        this.table = new Table();
        table.setFillParent(true);
        table.center();
        table.defaults().pad(10);
        table.debug();

        Label label = new Label("Main Menu", skin);
        startButton = new TextButton("Sudoku", skin);
        optionsButton = new TextButton("Options Menu", skin);
        scoreButton = new TextButton("Score Menu", skin);
        exitButton = new TextButton("Exit", skin);

        table.add(label).expandX();
        table.row();
        table.add(startButton).expandX().prefSize(250, 50);
        table.row();
        table.add(optionsButton).expandX().prefSize(250, 50);
        table.row();
        table.add(scoreButton).expandX().prefSize(250, 50);
        table.row();
        table.add(exitButton).expandX().prefSize(250, 50);

        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        stage.act(delta);
        stage.draw();

        game.batch.end();

        input();

    }

    public void input() {
        if (startButton.isPressed()) {
            System.out.println("Start");
            game.setScreen(new GameScreen(game));
            dispose();
        }
        else if (exitButton.isPressed()) {
            Gdx.app.exit();
            System.exit(-1);
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
