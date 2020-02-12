package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class Field {

    private int width;
    private int height;
    private int cellSize = 25;
    public static final int PADDING = 10;


    public Field (int cols, int rows){
        width = cols;
        height = rows;
    }

    public void init(){
        Rectangle rect = new Rectangle(PADDING, PADDING, width*cellSize, height*cellSize);
         rect.fill();
         for(int i=0; i<width; i++){
             for(int j=0; j<height; j++){
                 Picture sandPixelArt = new Picture(PADDING+i*cellSize,PADDING+j*cellSize,"/Users/codecadet/Desktop/advanced-exploration/images/sand_pixelArt.png");
                 sandPixelArt.draw();
             }
         }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
