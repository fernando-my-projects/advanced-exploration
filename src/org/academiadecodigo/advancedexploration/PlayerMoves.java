package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Entities.Rock;
import org.academiadecodigo.advancedexploration.graphics.Color;
import org.academiadecodigo.advancedexploration.graphics.Rectangle;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardEvent;
import org.academiadecodigo.advancedexploration.keyboard.KeyboardHandler;
import org.academiadecodigo.advancedexploration.pictures.Picture;

public class PlayerMoves implements KeyboardHandler {

    private Picture nazi;
    private PossibleMoves possibleMoves;
    private Player player;
    private Rectangle rect;
    private Field field;
    private boolean scoreNotUpdated = false;
    private int energySpentMoving = -20;

    public PlayerMoves(Rock[] rocks, Field field, Player player) {
        //nazi = new Picture(0,0, "/Users/codecadet/IdeaProjects/advanced-exploration/images/nazi-hitler.PNG");
        //nazi.draw();
        this.field = field;
        rect = new Rectangle(player.getPos().getX() + field.PADDING, player.getPos().getY()
                + field.PADDING, field.getCellSize(), field.getCellSize());
        rect.setColor(Color.CYAN);
        rect.fill();
        possibleMoves = new PossibleMoves(rocks, field);
        this.player = player;
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (possibleMoves.checkRight(player)) {
                    player.getPos().setCol(1);
                    rect.translate(field.getCellSize(),0);
                    player.setScoreNotUpdated(false);
                    player.setEnergy(energySpentMoving);
                }

                break;
            case KeyboardEvent.KEY_LEFT:
                if (possibleMoves.checkLeft(player)) {
                    player.getPos().setCol(-1);
                    rect.translate(-field.getCellSize(),0);
                    player.setScoreNotUpdated(false);
                    player.setEnergy(energySpentMoving);
                }

                break;
            case KeyboardEvent.KEY_DOWN:
                if (possibleMoves.checkDown(player)) {
                    player.getPos().setRow(1);
                    rect.translate(0, field.getCellSize());
                    player.setScoreNotUpdated(false);
                    player.setEnergy(energySpentMoving);
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (possibleMoves.checkUp(player)) {
                    player.getPos().setRow(-1);
                    rect.translate(0, -field.getCellSize());
                    player.setScoreNotUpdated(false);
                    player.setEnergy(energySpentMoving);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        /**
         * Not Implemented
         */
    }
}
