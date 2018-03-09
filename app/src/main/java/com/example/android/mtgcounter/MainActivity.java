package com.example.android.mtgcounter;

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
    int poison2 = 0;

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
        TextView scoreView = findViewById(R.id.player2_score);
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
     * Reduce life points of Player1 by one. (executed then tap on TextView "player1_score")
     */
    public void minusOneLifePointPlayer1(View v) {
        scorePlayer1 = scorePlayer1 - 1;
        displayForPlayer1(scorePlayer1);
        checkForLoser(v);
    }

    /**
     * Add 1 life point to Player1
     */
    public void plusOneLifePointPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 1;
        displayForPlayer1(scorePlayer1);
        checkForLoser(v);
    }

    /**
     * Add 5 life points to Player1
     */
    public void plusFiveLifePointsPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 5;
        displayForPlayer1(scorePlayer1);
        checkForLoser(v);
    }

    /**
     * Reduce life points of Player2 by one. (executed then tap on TextView "player2_score")
     */
    public void minusOneLifePointPlayer2(View v) {
        scorePlayer2 = scorePlayer2 - 1;
        displayForPlayer2(scorePlayer2);
        checkForLoser(v);
    }

    /**
     * Add 1 life point to Player2
     */
    public void plusOneLifePointPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 1;
        displayForPlayer2(scorePlayer2);
        checkForLoser(v);
    }

    /**
     * Add 5 life points to Player2
     */
    public void plusFiveLifePointsPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 5;
        displayForPlayer2(scorePlayer2);
        checkForLoser(v);
    }

    /**
     * Add 1 poison counter to Player1
     */
    public void addPoisonCounterPlayer1(View v) {
        poison1 = poison1 + 1;
        displayPoisonForPlayer1(poison1);
        checkForLoser(v);
    }

    /**
     * Add 1 poison counter to Player2
     */
    public void addPoisonCounterPlayer2(View v) {
        poison2 = poison2 + 1;
        displayPoisonForPlayer2(poison2);
        checkForLoser(v);
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
        TextView loserWarning = findViewById(R.id.loser_warning);
        loserWarning.setText("");
    }
    /**
     * Check all conditions for player to loose: if life points reduced to zero or
     * number of poison counters is equal or more than ten.
     * A suitable inscription is displayed in TextView "loser_warning"
     */
    public void checkForLoser(View v){
        TextView loserWarning = findViewById(R.id.loser_warning);
        if ((scorePlayer1 <= 0 && scorePlayer2 <= 0) || (poison1 >= 10 && poison2 >=10)
                || (scorePlayer1 <= 0 && poison2 >=10) || (scorePlayer2 <= 0 && poison1 >=10))
            loserWarning.setText(R.string.players_lose);
        else if (scorePlayer1 <= 0 || poison1 >= 10)
            loserWarning.setText(R.string.player1_lose);
        else if (scorePlayer2 <= 0 || poison2 >= 10)
            loserWarning.setText(R.string.player2_lose);
        else
            loserWarning.setText("");
    }

    /**
     * Virtually rolls the dice: get the image of dice side which fits to generated random int number
     */
    public void diceRoll(View v) {
        // generates random integer number from [1;6] interval
        int diceSide = ThreadLocalRandom.current().nextInt(1, 7);
        // makes new string which looks like e.g. "dice1", "dice5"
        String diceImageName = "dice" + String.valueOf(diceSide);
        /*
         * there are six images in drawable folder named from "dice1" to "dice6".
         *   get the id of image with name diceImageName
         */
        int id = getResources().getIdentifier(diceImageName, "drawable", getPackageName());
        //find View by id = image_dice from xml file
        ImageView diceView = findViewById(R.id.image_dice);
        //set the image in the ImageView to id generated previously
        diceView.setImageResource(id);
        diceView.setContentDescription("Dice side"+String.valueOf(diceSide));
    }

}
