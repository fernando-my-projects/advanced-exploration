package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.pictures.Picture;

import java.awt.*;
import java.awt.image.BufferedImage;

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
        Picture pic1 = new Picture(PADDING, (PADDING+50), "images/desert_final_500x500.png");
        pic1.draw();
        Picture hitler = new Picture(100, 200, "images/hitler_final.png");
        hitler.draw();
        Picture crypt = new Picture(200, 300, "crypt_final.png");
        crypt.draw();
        Picture bush = new Picture(350, 400, "bush_final.png");
        bush.draw();
        /*Picture indi = new Picture(250,300,"images/indi_50x50.png");
        indi.draw();*/
    }




    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
