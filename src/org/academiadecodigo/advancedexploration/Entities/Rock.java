package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;

public class Rock {

    private FieldPosition pos;

    public Rock(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
    }

    public FieldPosition getPos() {
        return pos;
    }
}
