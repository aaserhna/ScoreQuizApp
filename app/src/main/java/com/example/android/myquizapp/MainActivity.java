package com.example.android.myquizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is used to compare the user's inputs with the right answers...
     * a question answered correctly scores one point. The maximum total score is 10.
     *
     * @param ans1  is the user's answer to question one.
     * @param ans2  is the user's answer to question two.
     * @param ans3  is the user's answer to question three.
     * @param ans4  is the user's answer to question four.
     * @param ans5  is the user's answer to question five.
     * @param ans6  is the user's answer to question six.
     * @param ans7  is the user's answer to question seven.
     * @param ans8  is the user's answer to question eight.
     * @param ans9  is the user's answer to question nine.
     * @param ans10 is the user's answer to question ten.
     * @return score which is the user's total score.
     */
    public int calculateScore(int ans1, String ans2, boolean ans3, int ans4, int ans5, int ans6,
                              String ans7, int ans8, int ans9, int ans10) {
        int score = 0;
        //String india = R.string.india;
        if (ans1 == 1) {
            score += 1;
        }
        if (ans2.equals("INDIA")) {
            score += 1;
        }
        if (ans3) {
            score += 1;
        }
        if (ans4 == 2) {
            score += 1;
        }
        if (ans5 == 1) {
            score += 1;
        }
        if (ans6 == 1) {
            score += 1;
        }
        if (ans7.equals("BOWLS")) {
            score += 1;
        }
        if (ans8 == 1) {
            score += 1;
        }
        if (ans9 == 0) {
            score += 1;
        }
        if (ans10 == 0) {
            score += 1;
        }
        return score;
    }

    /**
     * This method is called when the SUBMIT button is clicked. It evaluates the user's score
     */
    @SuppressLint("StringFormatInvalid")
    public void submitAnswers(View view) {
        RadioGroup questionOne = findViewById(R.id.q1_radiogroup);
        int userAnswer1ID = questionOne.getCheckedRadioButtonId();
        View userAnswer1 = questionOne.findViewById(userAnswer1ID);
        int userAnswer1Index = questionOne.indexOfChild(userAnswer1);
        //Log.v("MainActivity","Answer 1 is index 1: " + userAnswer1Index);

        EditText questionTwo = findViewById(R.id.q2_edittext);
        String userAnswer2Text = questionTwo.getText().toString();
        //Log.v("MainActivity","Answer 2 is index India: " + userAnswer2Text);

        CheckBox question3_opt1 = findViewById(R.id.q3_checkbox1);
        CheckBox question3_opt2 = findViewById(R.id.q3_checkbox2);
        CheckBox question3_opt3 = findViewById(R.id.q3_checkbox3);
        boolean userAnswer3_opt1 = question3_opt1.isChecked();
        boolean userAnswer3_opt2 = question3_opt2.isChecked();
        boolean userAnswer3_opt3 = question3_opt3.isChecked();
        boolean userAnswer3Combo = false;
        if (userAnswer3_opt1 && userAnswer3_opt2 && !userAnswer3_opt3) {
            userAnswer3Combo = true;
        }
        //Log.v("MainActivity","Answer 3 is index true: " + userAnswer3Combo);

        RadioGroup questionFour = findViewById(R.id.q4_radiogroup);
        int userAnswer4ID = questionFour.getCheckedRadioButtonId();
        View userAnswer4 = questionFour.findViewById(userAnswer4ID);
        int userAnswer4Index = questionFour.indexOfChild(userAnswer4);
        //Log.v("MainActivity","Answer 4 is index 2: " + userAnswer4Index);

        RadioGroup questionFive = findViewById(R.id.q5_radiogroup);
        int userAnswer5ID = questionFive.getCheckedRadioButtonId();
        View userAnswer5 = questionFive.findViewById(userAnswer5ID);
        int userAnswer5Index = questionFive.indexOfChild(userAnswer5);
        //Log.v("MainActivity","Answer 5 is index 1: " + userAnswer5Index);

        RadioGroup questionSix = findViewById(R.id.q6_radiogroup);
        int userAnswer6ID = questionSix.getCheckedRadioButtonId();
        View userAnswer6 = questionSix.findViewById(userAnswer6ID);
        int userAnswer6Index = questionSix.indexOfChild(userAnswer6);
        //Log.v("MainActivity","Answer 6 is index 1: " + userAnswer6Index);

        EditText questionSeven = findViewById(R.id.q7_edittext);
        String userAnswer7Text = questionSeven.getText().toString();
        //Log.v("MainActivity","Answer 2 is index Bowls: " + userAnswer7Text);

        RadioGroup questionEight = findViewById(R.id.q8_radiogroup);
        int userAnswer8ID = questionEight.getCheckedRadioButtonId();
        View userAnswer8 = questionEight.findViewById(userAnswer8ID);
        int userAnswer8Index = questionEight.indexOfChild(userAnswer8);
        //Log.v("MainActivity","Answer 8 is index 1: " + userAnswer8Index);

        RadioGroup questionNine = findViewById(R.id.q9_radiogroup);
        int userAnswer9ID = questionNine.getCheckedRadioButtonId();
        View userAnswer9 = questionNine.findViewById(userAnswer9ID);
        int userAnswer9Index = questionNine.indexOfChild(userAnswer9);
        //Log.v("MainActivity","Answer 9 is index 0: " + userAnswer9Index);

        RadioGroup questionTen = findViewById(R.id.q10_radiogroup);
        int userAnswer10ID = questionTen.getCheckedRadioButtonId();
        View userAnswer10 = questionTen.findViewById(userAnswer10ID);
        int userAnswer10Index = questionTen.indexOfChild(userAnswer10);
        //Log.v("MainActivity","Answer 10 is index 0: " + userAnswer10Index);

        // Call the calculateScore fxn to compare user's inputs with the correct...
        // answers, sum the points and return the total score.
        int userScore = calculateScore(userAnswer1Index, userAnswer2Text, userAnswer3Combo,
                userAnswer4Index, userAnswer5Index, userAnswer6Index, userAnswer7Text,
                userAnswer8Index, userAnswer9Index, userAnswer10Index);

        // Show quiz result as toast.
        if (userScore == 0) {
            Toast.makeText(this, getString(R.string.total_score_0, userScore), Toast.LENGTH_LONG).show();
        } else if (userScore <= 4) {
            Toast.makeText(this, getString(R.string.total_score_4, userScore), Toast.LENGTH_LONG).show();
        } else if (userScore <= 7) {
            Toast.makeText(this, getString(R.string.total_score_7, userScore), Toast.LENGTH_LONG).show();
        } else if (userScore <= 9) {
            Toast.makeText(this, getString(R.string.total_score_9, userScore), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.total_score_10, userScore), Toast.LENGTH_LONG).show();
        }

    }

}
