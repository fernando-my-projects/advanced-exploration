package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HolyGrail implements Interactable {

    private FieldPosition pos;
    protected int cellSize;
    protected int PADDING;
    protected Rectangle rect;
    protected Picture pic;
    protected boolean hasInteracted = false;

    public HolyGrail(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
        cellSize = field.getCellSize();
        PADDING = field.PADDING;
        picInit();
    }

    @Override
    public void interact(Player player) {
        player.setPoints(200);
    }

    public FieldPosition getPos() {
        return pos;
    }

    @Override
    public boolean hasInteracted() {
        return hasInteracted;
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING+pos.getX(), PADDING+pos.getY(), "resources/images/holyGrail.png");
    }

    @Override
    public void draw() {
        pic.draw();
    }

    @Override
    public void erase() {
        pic.delete();
    }
}
