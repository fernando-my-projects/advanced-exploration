package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Rectangle;

public class Field {

    private int width;
    private int height;
    private int cellSize = 50;
    public static final int PADDING = 10;


    public Field (int cols, int rows){
        width = cols;
        height = rows;
    }

    public void init(){
        Rectangle rect = new Rectangle(PADDING, PADDING, width*cellSize, height*cellSize);
         rect.fill();


    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCellSize() {
        return cellSize;
    }
}
