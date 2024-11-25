package com.badlogic.sudoku;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final Sudoku game;

    int screenXOffset = 300;
    int screenYOffset = 200;

    Texture grid;
    Texture numberAtlas;

    Board board;

    TextureRegion[] numberTextureAtlas;


    public GameScreen(final Sudoku game) {
        this.game = game;

        board = new Board(screenXOffset + 6, screenYOffset + 6);
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
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            board.solveBoard();
        }
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.WHITE);

        // draw the board
        game.batch.begin();
        for (int x = screenXOffset; x < screenXOffset + 600; x += 200) {
            for (int y = screenYOffset; y < screenYOffset + 600; y += 200) {
                game.batch.draw(grid, x, y, 200, 200);
            }
        }

        // draw the cells on the board
        for (Cell cell: board.getCells()) {
            cell.sprite.draw(game.batch);
        }

        game.batch.end();
    }

    // loads the sprites for the game
    public void loadSprites() {
        grid = new Texture(Gdx.files.internal("grid.png"));

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
