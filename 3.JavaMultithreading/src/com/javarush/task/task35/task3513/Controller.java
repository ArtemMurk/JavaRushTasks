package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public void resetGame(){
        model.score=0;
        view.isGameWon=false;
        view.isGameLost = false;

        model.resetGameTiles();
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_A) model.autoMove();
        if (keyEvent.getKeyCode() == KeyEvent.VK_R) model.randomMove();
        if (keyEvent.getKeyCode()==KeyEvent.VK_Z) model.rollback();
        if (keyEvent.getKeyCode()==KeyEvent.VK_ESCAPE) resetGame();
        if (!model.canMove()) view.isGameLost = true;
        if (!view.isGameLost && !view.isGameWon){
            switch (keyEvent.getKeyCode()){
                case  KeyEvent.VK_LEFT: model.left(); break;
                case  KeyEvent.VK_RIGHT: model.right(); break;
                case  KeyEvent.VK_UP: model.up(); break;
                case  KeyEvent.VK_DOWN: model.down(); break;
            }
        }
        if (model.maxTile == WINNING_TILE){view.isGameWon=true;}
        view.repaint();
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }
}
