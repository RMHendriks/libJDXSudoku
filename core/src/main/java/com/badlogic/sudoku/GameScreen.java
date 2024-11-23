package com.badlogic.sudoku;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

    Sprite[] numberSprites;


    public GameScreen(final Sudoku game) {
        this.game = game;

        board = new Board();
        loadSprites();

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
        for (int x = 300; x < 900; x += 200) {
            for (int y = 200; y < 800; y += 200) {
                game.batch.draw(grid, x, y, 200, 200);
            }
        }

        game.batch.end();
    }

    // loads the sprites for the game
    public void loadSprites() {
        grid = new Texture(Gdx.files.internal("grid.png"));
        numberAtlas = new Texture(Gdx.files.internal("s_numbers_b.png"));

        // Loads in Number Textures
        int spriteCounter = 0;
        numberSprites = new Sprite[9];

        for  (int x = 0; x < 192; x += 64) {
            for (int y = 0; y < 192; y += 64) {
                TextureRegion region = new TextureRegion(numberAtlas, x, y, 64, 64);
                numberSprites[spriteCounter] = new Sprite(region);
                spriteCounter++;
            }
        }
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
