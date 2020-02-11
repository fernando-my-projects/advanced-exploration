package org.academiadecodigo.advancedexploration.Entities;

import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.FieldPosition;
import org.academiadecodigo.advancedexploration.Interactable;

public class HolyGrail implements Interactable {

    private FieldPosition pos;

    public HolyGrail(int col, int row, Field field){
        pos = new FieldPosition(col, row, field);
    }

    @Override
    public void interact(Player player) {
        player.setPoints(200);
    }

    public FieldPosition getPos() {
        return pos;
    }
}
