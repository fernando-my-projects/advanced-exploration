package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Entities.Rock;

public class PossibleMoves {

    private FieldPosition posToCompare;
    private Rock[] rocks;
    private Field field;

    public PossibleMoves(Rock[] rocks, Field field){
        this.field = field;
        this.rocks = rocks;
    }

    public boolean checkRight(Player player){

        if (player.getPos().getCol() == (field.getWidth() - 1)){
            return false;
        }
        //create position at player right
        posToCompare = new FieldPosition(player.getPos().getCol() + 1, player.getPos().getRow());

        for (Rock rock : rocks) {

            if(rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public boolean checkLeft(Player player){

        if (player.getPos().getCol() == 0){
            return false;
        }
        //create position at player left
        posToCompare = new FieldPosition(player.getPos().getCol() - 1, player.getPos().getRow());

        for (Rock rock : rocks) {

            if (rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public boolean checkUp(Player player){

        if (player.getPos().getRow() == 0){
            return false;
        }
        //create position above player
        posToCompare = new FieldPosition(player.getPos().getCol(), player.getPos().getRow() - 1);

        for (Rock rock : rocks) {

            if (rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }

    public boolean checkDown(Player player){

        if (player.getPos().getRow() == (field.getHeight() - 2)){
            return false;
        }
        //create position above player
        posToCompare = new FieldPosition(player.getPos().getCol(), player.getPos().getRow() + 1);

        for (Rock rock : rocks) {

            if (rock.getPos().equals(posToCompare)){
                return false;
            }
        } return true;
    }






}
