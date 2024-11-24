package com.badlogic.sudoku;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final Sudoku game;


    public MainMenuScreen(final Sudoku game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);

        game.viewport.apply();
        game.viewport.getCamera().position.set(400, 400, 0);

        game.batch.begin();
        //draw text. Remember that x and y are in meters
        game.font.draw(game.batch, "Welcome to Sudoku!!! ", 100, 100);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 125);


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
