package org.academiadecodigo.advancedexploration.Items;

import org.academiadecodigo.advancedexploration.Entities.Player;
import org.academiadecodigo.advancedexploration.Field;
import org.academiadecodigo.advancedexploration.PrintRunTimeInfo;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;



public class Whip extends Item {

    protected boolean hasInteracted = false;
    protected int reward = 50;
    private File whipSoundFile;

    public Whip(int col, int row, Field field){
        super(col, row, field);
        picInit();
        whipSoundFile = new File("resources/gameSounds/whip.wav");
    }

    @Override
    public void equip(Player player) {
        erase();
        playWhipMusic();
        player.pickWhip();
        hasInteracted = true;
    }

    @Override
    public boolean hasInteracted() {
        return hasInteracted;
    }

    @Override
    public void picInit() {
        pic = new Picture(PADDING + pos.getX(), PADDING + pos.getY(), "resources/images/whip.png");
    }

    @Override
    public void draw() {
        pic.draw();
    }

    @Override
    public void erase() {
        pic.delete();
    }

    private void playWhipMusic() {


        try {

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(whipSoundFile);
            AudioFormat audioFormat = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip audioFileWhip = (Clip) AudioSystem.getLine(info);
            audioFileWhip.open(audioStream);
            audioFileWhip.start();


        } catch (Exception e) {
            e.getMessage();
        }

    }

    public int getReward() {
        return reward;
    }
}
