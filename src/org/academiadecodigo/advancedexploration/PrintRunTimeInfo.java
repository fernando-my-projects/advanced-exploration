package org.academiadecodigo.advancedexploration;

import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.Timer;
import java.util.TimerTask;

public class PrintRunTimeInfo {

    public static void timerPrint(String message){

        final Text print = new Text(20, 527, message);
        print.draw();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                print.delete();
            }
        };

        Timer timed = new Timer(){
        };

        timed.schedule(timerTask, 2000);
    }
}
