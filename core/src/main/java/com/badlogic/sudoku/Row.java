package com.badlogic.sudoku;

public class Row extends CellCollection {

    boolean horizontal;

    public Row (int xIndex, int yIndex, boolean horizontal) {
        super(xIndex, yIndex);

        this.horizontal = horizontal;
    }

    @Override
    public String toString() {

        StringBuilder outputString = new StringBuilder();

        outputString.append("Row: X:").append(this.xIndex).append(" Y:").append(this.yIndex).append("\n");
        outputString.append("Orientation: ").append(this.horizontal ? "Horizontal" : "Vertical").append("\n | ");

        if (horizontal) {
            for (Cell cell : this.cellArray) {
                outputString.append(cell.value).append(" | ");
            }
        }
        else {
            for (Cell cell : this.cellArray) {
                outputString.append(cell.value).append(" |\n | ");
            }
            outputString.setLength(outputString.length() - 3);
        }

        outputString.append("\n");

        return outputString.toString();
    }
}
