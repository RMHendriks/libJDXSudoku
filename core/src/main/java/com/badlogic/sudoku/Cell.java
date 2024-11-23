package com.badlogic.sudoku;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class Cell {

    public int x;
    public int y;

    public int value;

    public Sprite sprite;

    public Cell[][] boardArray;
    public Sprite[] spriteArray;

    public Block block;

    public Cell(int x, int y, int value, Cell[][] boardArray) {
        this.x = x;
        this.y = y;
        this.value = MathUtils.random(1, 9);

        this.boardArray = boardArray;
    }


}
