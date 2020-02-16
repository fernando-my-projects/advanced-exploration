package org.academiadecodigo.advancedexploration;

import java.io.*;

public class HighScore {
    private static final String file = "resources/highScore.txt";

    public static int load() {
        int highScore = 0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fileReader);
            String highScoreStr = bReader.readLine();
            highScore = Integer.parseInt(highScoreStr);
            bReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return highScore;
        }
    }

    public static void save(int newHighScore){
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);

            bWriter.write(String.valueOf(newHighScore));

            bWriter.flush();
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
