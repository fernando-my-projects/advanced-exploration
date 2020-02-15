package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
        rect = new Rectangle(0, 0, PADDING*2+width*cellSize, PADDING*2+height*cellSize);
        rect.setColor(Color.DARK_GRAY);
        rect.fill();
         for(int i=0; i<width; i++){
             for(int j=0; j<height; j++){
                 Picture sandPixelArt = new Picture(PADDING+i*cellSize,PADDING+j*cellSize,"resources/images/sand_pixelArt.png");
                 sandPixelArt.draw();
             }
         }
        Picture pic = new Picture(PADDING,PADDING+height*cellSize-50, "resources/images/ScoreBoard2.png");
        pic.draw();
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
