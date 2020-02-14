package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Color;
import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class Field {

    private int width;
    private int height;
    private int cellSize = 50;
    public static final int PADDING = 10;
    private Rectangle rect;


    public Field (int cols, int rows){
        width = cols;
        height = rows;
    }

    public void init(){
        rect = new Rectangle(PADDING, PADDING, width*cellSize, height*cellSize);
         rect.fill();
         for(int i=0; i<width; i++){
             for(int j=0; j<height; j++){
                 Picture sandPixelArt = new Picture(PADDING+i*cellSize,PADDING+j*cellSize,"resources/sand_pixelArt.png");
                 sandPixelArt.draw();
             }
         }
    }

    public void setClear() {
        rect = new Rectangle(PADDING, PADDING, width*cellSize, height*cellSize);
        rect.setColor(Color.WHITE);
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
