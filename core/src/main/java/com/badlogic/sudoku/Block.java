package com.badlogic.sudoku;

public class Block {
    int xBlockIndex;
    int yBlockIndex;

    int arrayIndex;
    Cell[] cellArray;

    public Block(int xIndex, int yIndex) {
        this.xBlockIndex = xIndex;
        this.yBlockIndex = yIndex;

        this.arrayIndex = 0;
        this.cellArray = new Cell[9];
    }

    public void addCell(Cell cell) {
        cellArray[arrayIndex] = cell;
        cell.block = this;
        arrayIndex++;
    }

    @Override
    public String toString() {

        StringBuilder outputString = new StringBuilder();
        int cellValue;

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                outputString.append(" |\n");
            }
            cellValue = cellArray[i].value;
            outputString.append(" | ").append(cellValue);
        }

        outputString.append(" |");
        return outputString.toString();
    }
}
