package com.badlogic.sudoku;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

import java.util.*;

public class Cell {

    public int x;
    public int y;

    public int xCord;
    public int yCord;

    public int value;

    public Sprite sprite;

    public Cell[][] boardArray;
    public TextureRegion[] textureArray;

    public Block block;
    public Row hRow;
    public Row vRow;

    public Cell(int x, int y, int xCord, int yCord, int value, Cell[][] boardArray, TextureRegion[] textureArray) {
        this.x = x;
        this.y = y;
        this.xCord = xCord;
        this.yCord = yCord;
        this.value = MathUtils.random(0, 9);

        this.boardArray = boardArray;
        this.textureArray = textureArray;

        changeValue(this.value);
    }

    // adds a (horizontal/vertical) row to the cell
    public void addRow(Row row, boolean horizontal) {
        if (horizontal) {
            this.hRow = row;
        }
        else {
            this.vRow = row;
        }
    }

    // looks up all possible values and returns an array of possible values
    public List<Integer> findPossibleNumbers() {
        List<Integer> possibleNumberArray = new ArrayList<>();

        if (this.value != 0) {
            return possibleNumberArray;
        }
        else {
            Set<Integer> numberSet = new LinkedHashSet<>();
            numberSet.addAll(this.block.getValues());
            numberSet.addAll(this.hRow.getValues());
            numberSet.addAll(this.vRow.getValues());
            List<Integer> nonValidNumbers = new ArrayList<>(numberSet);
            System.out.println("Block: " + this.block.getValues());
            System.out.println("hRow: " + this.hRow.getValues());
            System.out.println("vRow: " + this.vRow.getValues());
            System.out.println(nonValidNumbers);

            for (int i = 1; i <= 9; i++) {
                if (!nonValidNumbers.contains(i)) {
                    possibleNumberArray.add(i);
                }
            }
        }

        return possibleNumberArray;
    }

    // changes the value of the cell to the new value and update the correct sprite
    public void changeValue(int value) {
        this.value = value;

        sprite = new Sprite(textureArray[value]);
        sprite.setPosition(xCord, yCord);

    }
}
