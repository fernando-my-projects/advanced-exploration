package org.academiadecodigo.advancedexploration;

public class Field {

    private int width;
    private int height;


    public Field (int cols, int rows){
        width = cols;
        height = rows;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
