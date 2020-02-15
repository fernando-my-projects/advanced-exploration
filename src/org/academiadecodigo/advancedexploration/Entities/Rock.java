package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Rock {

    private FieldPosition pos;
    private Rectangle rect;
    protected int cellSize;
    protected int PADDING;

    public Rock(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
        cellSize = field.getCellSize();
        PADDING = field.PADDING;
        rockInit();
    }

    public FieldPosition getPos() {
        return pos;
    }

    public void rockInit(){
        rect = new Rectangle(PADDING + pos.getX(), PADDING + pos.getY(), cellSize, cellSize);
        rect.setColor(Color.MAGENTA);
    }

    public void draw() {
        rect.fill();
    }


}
