package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.advancedexploration.Interactable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class HolyGrail implements Interactable {

    private FieldPosition pos;
    protected int cellSize;
    protected int PADDING;
    protected Rectangle rect;

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
    public void picInit() {
        rect = new Rectangle(PADDING + pos.getX(), PADDING + pos.getY(), cellSize, cellSize);
        rect.setColor(Color.LIGHT_GRAY);
    }

    @Override
    public void draw() {
        rect.fill();
    }

    @Override
    public void erase() {
        rect.delete();
    }
}
