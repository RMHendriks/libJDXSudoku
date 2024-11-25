package com.badlogic.sudoku;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public Cell cell;

    public Cell[][] boardCells;
    public Block[] blockCells;
    public Row[] horizontalRowCells;
    public Row[] verticalRowCells;

    public TextureRegion[] numberTextureAtlas;

    public Board(int xOffset, int yOffset) {
        boardCells = new Cell[9][9];
        blockCells = new Block[9];

        initialiseCellTextures();

        // initialises the cells in the board using the correct location (both in
        int xCord = xOffset;
        int yCord = yOffset;
        int cellDelta = 67;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                cell = new Cell(x, y, xCord, yCord, 0, boardCells, numberTextureAtlas);
                boardCells[x][y] = cell;
                yCord += cellDelta;
            }
            yCord = yOffset;
            xCord += cellDelta;
        }

        initialiseBlockArray();
        initialiseRowArray();
        loadBoard();

        System.out.println(horizontalRowCells[3]);
        System.out.println(verticalRowCells[2]);
    }

    private void initialiseBlockArray(){
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
                    if (block.xIndex == xIndex && block.yIndex == yIndex){
                        block.addCell(boardCells[x][y]);
                        break;
                    }
                }
            }
        }
    }

    private void initialiseRowArray() {
        horizontalRowCells = new Row[9];
        verticalRowCells = new Row[9];

        // initialise the horizontal row objects
        for (int x = 0; x < 9; x++) {
            horizontalRowCells[x] = new Row(x, 0, true);
        }

        // initialise the vertical row objects
        for (int y = 0; y < 9; y++) {
            verticalRowCells[y] = new Row(0, y, false);
        }

        // fill the horizontal row objects with cells and add the row to the hRow of the cell
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                horizontalRowCells[x].addCell(boardCells[x][y]);
                boardCells[x][y].addRow(horizontalRowCells[x], true);
            }
        }

        // fill the vertical row objects with cells and add the row to the vRow of the cell
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                verticalRowCells[y].addCell(boardCells[x][y]);
                boardCells[x][y].addRow(verticalRowCells[y], false);
            }
        }
    }

    // load in the number textures needed for the cells
    private void initialiseCellTextures() {
        Texture numberAtlas = new Texture(Gdx.files.internal("s_numbers_black.png"));

        int textureCounter = 0;
        numberTextureAtlas = new TextureRegion[10];

        for  (int x = 0; x < 520; x += 52) {
            TextureRegion region = new TextureRegion(numberAtlas, x, 0, 52, 52);
            numberTextureAtlas[textureCounter] = region;
            textureCounter++;
        }
    }

    // gets all the cells of the board as a 1d list
    public Iterable<Cell> getCells() {
        List<Cell> cellList = new ArrayList<>();
        for (Cell[] boardCell : boardCells) {
            cellList.addAll(Arrays.asList(boardCell));
        }

        return cellList;
    }

    // solves the board and fills in the missing values
    public void solveBoard() {
        for (Cell cell : getCells()) {
            List<Integer> valueList = cell.findPossibleNumbers();
            System.out.println(valueList);
            if (valueList.size() == 1) {
                cell.changeValue(valueList.getFirst());
                return;
            }
        }
    }

    // loads in the board from a 2d array
    public void loadBoard() {

        FileHandle file = Gdx.files.internal("boards/sudoku1.json");

        String jsonText = file.readString();
        System.out.println(jsonText);

        Json json = new Json();
        JsonLoader board = json.fromJson(JsonLoader.class, jsonText);

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                boardCells[x][y].changeValue(board.board[x][y]);
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
