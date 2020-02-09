package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Entities.Rock;

public class PossibleMoves {

    private Position posToCampare;
    private Rock[] rocks;

    public PossibleMoves(Rock[] rocks){
        this.rocks = rocks;
    }

    /*
    RIGHT
        playerPos + col
        if has rock OR outOfBounds

        playerPos.equals(rock.getPos)

    LEFT
     playerPos - col
        if has rock OR outOfBounds

    UP
     playerPos - row
        if has rock OR outOfBounds

    DOWN
     playerPos + row
        if has rock OR outOfBounds
     */


    public boolean checkRight(Player player){

        if (player.getPos().getCol() == (player.getField().getWidth() - 1)){
            return false;
        }

        posToCampare = new Position(player.getPos().getCol() + 1, player.getPos().getRow());

        for (Rock rock : rocks) {

            if(rock.getPos().equals(posToCampare)){
                return false;
            }
        } return true;

    }


}
