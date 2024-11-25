package com.badlogic.sudoku;

import java.util.ArrayList;
import java.util.List;

public class CellCollection {
    int xIndex;
    int yIndex;

    int arrayIndex;
    Cell[] cellArray;

    public CellCollection(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;

        this.arrayIndex = 0;
        this.cellArray = new Cell[9];
    }

    // gets all the values of the cells and returns them as a list of integers
    public List<Integer> getValues() {
        List<Integer> values = new ArrayList<Integer>();

        for (Cell cell : cellArray) {
            values.add(cell.value);
        }

        return values;
    }

    public void addCell(Cell cell) {
        cellArray[arrayIndex] = cell;
        arrayIndex++;
    }


}
