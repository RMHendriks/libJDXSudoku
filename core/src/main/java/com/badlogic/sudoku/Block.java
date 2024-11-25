package com.badlogic.sudoku;

public class Block extends CellCollection {

    public Block(int xIndex, int yIndex) {
        super(xIndex, yIndex);
    }

    public void addCell(Cell cell) {
        super.addCell(cell);
        cell.block = this;
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
