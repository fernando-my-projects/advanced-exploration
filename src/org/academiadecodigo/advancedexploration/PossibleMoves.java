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


    public void checkRight(Player player){



        for (Rock rock : rocks) {



        }

    }


}
