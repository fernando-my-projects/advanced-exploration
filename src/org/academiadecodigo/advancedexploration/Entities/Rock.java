package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.Position;

public class Rock {

    private Position pos;

    public Rock(int col, int row, Field field){
        pos = new Position(col, row, field);
    }

    public Position getPos() {
        return pos;
    }
}
