package e.dell.mobileproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    QuizActivity quizActivity;
    TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText("Score: " +  quizActivity.score);
    }
}
