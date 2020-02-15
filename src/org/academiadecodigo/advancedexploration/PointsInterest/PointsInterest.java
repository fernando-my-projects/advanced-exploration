package org.academiadecodigo.advancedexploration.PointsInterest;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class PointsInterest implements Interactable {

    protected int reward;
    protected int penalty;
    protected double risk;
    protected FieldPosition pos;
    protected Rectangle rect;
    protected int cellSize;
    protected int PADDING;
    protected Picture pic;

    public PointsInterest (int col, int row, Field field){

        pos = new FieldPosition(col, row, field);
        cellSize = field.getCellSize();
        PADDING = field.PADDING;
    }

    @Override
    public void interact(Player player) {
        getExploreResult(player);
    }

    public abstract void getExploreResult(Player player);

    public FieldPosition getPos() {
        return pos;
    }


}
