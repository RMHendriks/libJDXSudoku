package com.badlogic.sudoku;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;

public class Sudoku extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public FillViewport viewport;


    public void create() {
        batch = new SpriteBatch();
        // use libGDX's default font
        font = new BitmapFont();
        viewport = new FillViewport(800, 600);

        //font has 15pt, but we need to scale it to our viewport by ratio of viewport height to screen height
        font.setUseIntegerPositions(false);

        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
