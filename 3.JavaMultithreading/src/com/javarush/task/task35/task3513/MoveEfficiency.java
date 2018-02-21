package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency that) {
        if (this.numberOfEmptyTiles != that.numberOfEmptyTiles){
            return Integer.compare(this.numberOfEmptyTiles, that.numberOfEmptyTiles);
        } else if(this.score != that.score){
            return Integer.compare (this.score , that.score);
        }

        return 0;
    }
}
