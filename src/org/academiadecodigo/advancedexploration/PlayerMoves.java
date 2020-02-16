package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Entities.Rock;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerMoves implements KeyboardHandler {

    private PossibleMoves possibleMoves;
    private Player player;
    private Rectangle rect;
    private Field field;
    private boolean scoreNotUpdated = false;
    private int energySpentMoving = -20;
    private Picture picPlayer;
    private Game game;

    public PlayerMoves(PossibleMoves possibleMoves, Game game) {
        this.field = game.getField();
        this.possibleMoves = possibleMoves;
        this.player = game.getPlayer();
        this.game = game;
        picPlayer = new Picture(player.getPos().getX() + field.PADDING, player.getPos().getY()
                + field.PADDING, "resources/images/indy.png");
        picPlayer.draw();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (!player.hasMoved()) {

            switch (e.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    if (possibleMoves.checkRight()) {
                        player.getPos().setCol(1);
                        picPlayer.translate(field.getCellSize(), 0);
                        player.setScoreNotUpdated(false);
                        player.setEnergy(energySpentMoving);
                        player.setHasMoved(true);
                    }

                    break;
                case KeyboardEvent.KEY_LEFT:
                    if (possibleMoves.checkLeft()) {
                        player.getPos().setCol(-1);
                        picPlayer.translate(-field.getCellSize(), 0);
                        player.setScoreNotUpdated(false);
                        player.setEnergy(energySpentMoving);
                        player.setHasMoved(true);
                    }

                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (possibleMoves.checkDown()) {
                        player.getPos().setRow(1);
                        picPlayer.translate(0, field.getCellSize());
                        player.setScoreNotUpdated(false);
                        player.setEnergy(energySpentMoving);
                        player.setHasMoved(true);
                    }
                    break;
                case KeyboardEvent.KEY_UP:
                    if (possibleMoves.checkUp()) {
                        player.getPos().setRow(-1);
                        picPlayer.translate(0, -field.getCellSize());
                        player.setScoreNotUpdated(false);
                        player.setEnergy(energySpentMoving);
                        player.setHasMoved(true);
                    }
                    break;

                case KeyboardEvent.KEY_Q:
                    if (game.getGameOver()){
                        System.exit(0);
                    }
                    break;

            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        /**
         * Not Implemented
         */
    }

}
