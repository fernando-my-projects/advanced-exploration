package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Rock {

    private FieldPosition pos;
    protected int cellSize;
    protected int PADDING;
    protected Picture pic;

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
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/rock2.png");
    }

    public void draw() {
        pic.draw();
    }


}
