package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Rock;
import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class Game {

    private Field field;
    private Rectangle grid;
    private Rock[] rocks;

    public Game (int cols, int rows){
        field = new Field(cols, rows);
        rocks = new Rock[16];
    }

    public void init(){
        field.init();
        makeRocks();

    }


    public void makeRocks(){

        rocks[0] = new Rock(1,0,field);
        rocks[1] = new Rock(1,1,field);
        rocks[2] = new Rock(2,1,field);
        rocks[3] = new Rock(3,1, field);
        rocks[4] = new Rock(4,1,field);
        rocks[5] = new Rock(6,0,field);
        rocks[6] = new Rock (6, 1,field);
        rocks[7] = new Rock (3 , 4,field);
        rocks[8] = new Rock (4, 4,field);
        rocks[9] = new Rock (5, 4,field);
        rocks[10] = new Rock (4, 5,field);
        rocks[11] = new Rock (4, 6,field);
        rocks[12] = new Rock (4, 7,field);
        rocks[13] = new Rock (4, 8,field);
        rocks[14] = new Rock (3, 8,field);
        rocks[15] = new Rock (5, 8,field);

    }


}
