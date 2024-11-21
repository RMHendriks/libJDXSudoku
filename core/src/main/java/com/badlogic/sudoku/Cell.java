package com.badlogic.sudoku;

import com.badlogic.gdx.math.MathUtils;

public class Cell {

    public int x;
    public int y;

    public int value;

    public Cell[][] boardArray;

    public Block block;

    public Cell(int x, int y, int value, Cell[][] board_array) {
        this.x = x;
        this.y = y;
        this.value = MathUtils.random(1, 9);
    }

}
