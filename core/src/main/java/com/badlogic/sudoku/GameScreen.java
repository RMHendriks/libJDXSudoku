package com.badlogic.sudoku;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final Sudoku game;

    Texture grid;
    Texture numberAtlas;

    Board board;


    public GameScreen(final Sudoku game) {
        this.game = game;
        grid = new Texture(Gdx.files.internal("grid.png"));
        numberAtlas = new Texture(Gdx.files.internal("s_numbers_b.png"));
        board = new Board();
        System.out.println(board);
        System.out.println(board.blockCells[1]);

    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
    }

    @Override
    public void render(float delta) {
        input();
        logic();
        draw();
    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.WHITE);

        game.batch.begin();
        for (int x = 5; x < 11; x += 2) {
            for (int y = 3; y < 9; y += 2) {
                game.batch.draw(grid, x, y, 2, 2);
            }
        }

        // TODO fix the number Texture system
        for (int x = 0; x < 66; x += 64){
            for (int y = 0; y < 66; y += 64){
                game.batch.draw(numberAtlas, x, y, 2, 2);
            }
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
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
