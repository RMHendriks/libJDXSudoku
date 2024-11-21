package com.badlogic.sudoku;

import java.lang.reflect.Array;

public class Board {

    Cell cell;

    Cell[][] boardCells;
    Block[] blockCells;

    public Board() {
        boardCells = new Cell[9][9];
        blockCells = new Block[9];

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                cell = new Cell(x, y, 0, boardCells);
                boardCells[x][y] = cell;
            }
        }

        determineBlockArray();
    }

    private void determineBlockArray(){
        int xIndex, yIndex;

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blockCells[k] = new Block(i, j);
                k++;
            }
        }

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                xIndex = x / 3;
                yIndex = y / 3;

                for (Block block : blockCells){
                    if (block.xBlockIndex == xIndex && block.yBlockIndex == yIndex){
                        block.addCell(boardCells[x][y]);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        int cellValue;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                cellValue = boardCells[x][y].value;
                outputString.append(" | ").append(cellValue);
            }
            outputString.append(" |\n");
        }

        return outputString.toString();
    }
}
