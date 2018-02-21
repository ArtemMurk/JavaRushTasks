package com.javarush.task.task35.task3513;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;


    private Tile[][] gameTiles;
    int score;
    int maxTile;

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    private void saveState(Tile[][] tiles){
        Tile[][] tilesForStack = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH ; i++) {
            for (int j = 0; j < FIELD_WIDTH ; j++) {
                tilesForStack[i][j] = new Tile(tiles[i][j].value);
            }
        }


        previousScores.push(score);
        previousStates.push(tilesForStack);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.empty()&& !previousScores.empty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < gameTiles.length ; i++) {
            for (int j = 0; j < gameTiles[i].length ; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();

        score=0;
        maxTile=2;
    }

    public List<Tile> getEmptyTiles(){
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length ; i++) {
            for (int j = 0; j < gameTiles.length ; j++) {
                if (gameTiles[i][j].isEmpty()){emptyTiles.add(gameTiles[i][j]);}
            }
        }

        return emptyTiles;
    }

    public void addTile(){
        List<Tile> emptyTile = getEmptyTiles();
        int selectEmptyTile = (int)(Math.random()*emptyTile.size());
        int selectNumberFourOrTwo = (Math.random() < 0.9 ? 2 : 4);

        emptyTile.get(selectEmptyTile).value=selectNumberFourOrTwo;
    }

    private boolean compressTiles(Tile[] tiles){
        boolean isChanged = false;

        for (int i = 0; i <tiles.length-1 ; i++) {
            for (int j = 0; j < tiles.length-1 ; j++) {
                if (tiles[j].value==0 && tiles[j+1].value !=0){
                    Tile buffTile = tiles[j];
                    tiles[j] = tiles[j+1];
                    tiles[j+1] =buffTile;
                    isChanged=true;
                }
            }
        }
        return isChanged;
    }


    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged = false;

        for (int i = 0; i <tiles.length-1 ; i++) {
            if (tiles[i].value!=0 && tiles[i].value == tiles[i+1].value){
                tiles[i].value  =tiles[i].value+tiles[i+1].value;
                tiles[i+1].value = 0;


                score +=tiles[i].value;
                if (tiles[i].value>maxTile) maxTile=tiles[i].value;
                isChanged=true;
            }
        }
        compressTiles(tiles);
        return isChanged;
    }


    public void left(){
        if (isSaveNeeded) {saveState(gameTiles);}

        boolean changesForAdd = false;
        for (int i = 0; i <gameTiles.length ; i++) {
            boolean changesComress=compressTiles(gameTiles[i]);
            boolean changesMerge = mergeTiles(gameTiles[i]);
            if (changesComress||changesMerge) changesForAdd=true;
        }
        if (changesForAdd) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = turnTileArrayToRight(gameTiles);
        gameTiles = turnTileArrayToRight(gameTiles);
        left();
        gameTiles = turnTileArrayToLeft(gameTiles);
        gameTiles = turnTileArrayToLeft(gameTiles);

    }
    public void down() {
        saveState(gameTiles);

        gameTiles = turnTileArrayToRight(gameTiles);
        left();
        gameTiles = turnTileArrayToLeft(gameTiles);

    }

    public void up() {
        saveState(gameTiles);

        gameTiles = turnTileArrayToLeft(gameTiles);
        left();
        gameTiles = turnTileArrayToRight(gameTiles);

    }



    private Tile[][] turnTileArrayToRight(Tile[][] tileArray){
        Tile[][] rightGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH ; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rightGameTiles[i][j] = tileArray[FIELD_WIDTH-j-1][i];
            }
        }
        return rightGameTiles;
    }

    private Tile[][] turnTileArrayToLeft(Tile[][] tileArray){
        Tile[][] leftGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH ; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                leftGameTiles[i][j] = gameTiles[j][FIELD_WIDTH-i-1];
            }
        }
        return leftGameTiles;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove(){
        for (int i = 0; i < gameTiles.length ; i++) {
            for (int j = 0; j < gameTiles.length ; j++) {
                if (gameTiles[i][j].value==0 || checkForMergeTile(i,j)) return true;
            }
        }
        return false;
    }

    private boolean checkForMergeTile(int rows,int columns){
        if (columns!=0 && gameTiles[rows][columns-1].value== gameTiles[rows][columns].value) return true;
        if (columns!=FIELD_WIDTH-1 && gameTiles[rows][columns+1].value== gameTiles[rows][columns].value) return true;
        if (rows!=0 && gameTiles[rows-1][columns].value== gameTiles[rows][columns].value) return true;
        if (rows!=FIELD_WIDTH-1 && gameTiles[rows+1][columns].value== gameTiles[rows][columns].value) return true;
    return false;
    }

    public void randomMove(){


        int randomNumberForDirection = ((int) (Math.random() * 100)) % 4;
                    switch (randomNumberForDirection) {
                case 0:
                    up();
                    break;
                case 1:
                    down();
                    break;
                case 2:
                    left();
                    break;
                case 3:
                    right();
                    break;
            }
    }

    public boolean hasBoardChanged(){
        return isDifferentTwoTileArrays(gameTiles,previousStates.peek());
    }

    private boolean isDifferentTwoTileArrays(Tile[][] tileOne, Tile[][] tileTwo){
        for (int i = 0; i < FIELD_WIDTH ; i++) {
            for (int j = 0; j < FIELD_WIDTH ; j++) {
                if (tileOne[i][j].value != tileTwo[i][j].value){
                    return true;
                }
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency efficiency;

        move.move();
        if (hasBoardChanged()){
            efficiency = new MoveEfficiency(getEmptyTiles().size(),score,move);

        }
        else{
            efficiency = new MoveEfficiency(-1,0,move);
        }
        rollback();
        return efficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> efficiencyPriorityQueue = new PriorityQueue<>(4,Collections.reverseOrder());
        efficiencyPriorityQueue.offer(getMoveEfficiency(this::left));
        efficiencyPriorityQueue.offer(getMoveEfficiency(this::right));
        efficiencyPriorityQueue.offer(getMoveEfficiency(this::up));
        efficiencyPriorityQueue.offer(getMoveEfficiency(this::down));
        efficiencyPriorityQueue.poll().getMove().move();
    }
}
