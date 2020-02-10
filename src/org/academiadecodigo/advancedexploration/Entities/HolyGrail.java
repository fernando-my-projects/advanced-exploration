package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;

public class HolyGrail {

    private FieldPosition pos;

    public HolyGrail(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
    }

}
