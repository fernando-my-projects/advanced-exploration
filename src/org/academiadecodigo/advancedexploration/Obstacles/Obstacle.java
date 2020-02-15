package org.academiadecodigo.advancedexploration.Obstacles;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Obstacle implements Interactable {

    protected int damage;
    protected int reward;
    protected FieldPosition pos;
    protected Rectangle rect;
    protected int cellSize;
    protected int PADDING;
    protected Picture pic;

    public Obstacle(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
        cellSize = field.getCellSize();
        PADDING = field.PADDING;
    }

    @Override
    public void interact(Player player) {
        getFightResult(player);
    }

    public abstract void getFightResult(Player player);

    public FieldPosition getPos() {
        return pos;
    }

/*
    public enum ObstacleType {
        NAZI("N", 40),
        SNAKE("S", 20);

        String type;
        int damage;

        ObstacleType(String string, int num){
            type = string;
            damage = num;
        }

        //public

    }*/

}
