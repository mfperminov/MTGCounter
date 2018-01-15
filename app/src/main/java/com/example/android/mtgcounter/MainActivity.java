package com.example.android.mtgcounter;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    int scorePlayer1 = 20;
    int scorePlayer2 = 20;
    int poison1 = 0;
    int poison2 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays life points for Player 1.
     */
    public void displayForPlayer1(int score) {
        TextView scoreView = findViewById(R.id.player1_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays life points for Player2.
     */
    public void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player2_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays poison counter for Player 1.
     */
    public void displayPoisonForPlayer1(int score) {
        TextView scoreView = findViewById(R.id.poison_view_player1);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays poison counters for Player2.
     */
    public void displayPoisonForPlayer2(int score) {
        TextView scoreView = findViewById(R.id.poison_view_player2);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Reduce life points of Player1 by one. (executed then tapon textview Player1 score)
     */
    public void minusPlayer1(View v) {
        scorePlayer1 = scorePlayer1 - 1;
        displayForPlayer1(scorePlayer1);
    }
    /**
     * Add 1 life point to Player1
     */
    public void plus1Player1(View v) {
        scorePlayer1 = scorePlayer1 + 1;
        displayForPlayer1(scorePlayer1);
    }
    /**
     * Add 5 life points to Player1
     */
    public void plus5Player1(View v) {
        scorePlayer1 = scorePlayer1 + 5;
        displayForPlayer1(scorePlayer1);
    }
    /**
     * Reduce life points of Player2 by one. (executed then tapon textview Player2 score)
     */
    public void minusPlayer2(View v) {
        scorePlayer2 = scorePlayer2 - 1;
        displayForPlayer2(scorePlayer2);
    }
    /**
     * Add 1 life point to Player2
     */
    public void plus1Player2(View v) {
        scorePlayer2 = scorePlayer2 + 1;
        displayForPlayer2(scorePlayer2);
    }
    /**
     * Add 5 life points to Player2
     */
    public void plus5Player2(View v) {
        scorePlayer2 = scorePlayer2 + 5;
        displayForPlayer2(scorePlayer2);
    }
    /**
     * Add 5 life points to Player1
     */
    public void addPcounterPlayer1(View v) {
        poison1 = poison1 + 1;
        displayPoisonForPlayer1(poison1);
    }
    /**
     * Add 5 life points to Player2
     */
    public void addPcounterPlayer2(View v) {
        poison2 = poison2 + 1;
        displayPoisonForPlayer2(poison2);
    }
    /**
     * Reset all life points to 20 and poison counters to 0 and displays it
     */
    public void resetAll(View v) {
        scorePlayer1 = 20;
        poison1 = 0;
        scorePlayer2 = 20;
        poison2 = 0;
        displayForPlayer1(scorePlayer1);
        displayForPlayer2(scorePlayer2);
        displayPoisonForPlayer1(poison1);
        displayPoisonForPlayer2(poison2);
    }
    /**
     * Virtually rolls the dice: get the image of dice side which fits to generated random int number
     */
    public void diceRoll(View v) {
        // generates random integer number from [1;6] interval
        int diceSide = ThreadLocalRandom.current().nextInt(1, 7);
        // makes new string which looks like e.g. "dice1", "dice5"
        String diceImage = "dice" + String.valueOf(diceSide);
        /*we already save in drawable folder six images, named from "dice1" to "dice6".
        *now get the id of image with name diceImage
         */
        int id = getResources().getIdentifier(diceImage, "drawable", getPackageName());
        //find View by id = image_dice from xml file
        ImageView diceView = findViewById(R.id.image_dice);
        //sets the image in the ImageView under button to id which we get previously
        diceView.setImageResource(id);
    }

}
