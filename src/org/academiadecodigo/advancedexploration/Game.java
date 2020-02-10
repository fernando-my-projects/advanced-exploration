package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.graphics.Rectangle;

public class Game {

    private Field field;
    private Rectangle grid;


    public Game (int cols, int rows){
        field = new Field(cols, rows);
    }

    public void init(){
        field.init();
    }


}
