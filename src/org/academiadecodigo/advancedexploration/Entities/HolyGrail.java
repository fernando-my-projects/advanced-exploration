package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Position;

public class HolyGrail {

    private Position pos;

    public HolyGrail(int col, int row, Field field){
        pos = new Position(col, row, field);
    }

}
