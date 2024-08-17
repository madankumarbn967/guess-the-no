package com.example.guessthenumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private TextView resultTextView;
    private EditText guessEditText;
    private Button guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        guessEditText = findViewById(R.id.guessInput);
        guessButton = findViewById(R.id.guessButton);

        generateRandomNumber();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeGuess();
            }
        });
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
    }

    private void makeGuess() {
        String guessString = guessEditText.getText().toString();
        if (guessString.isEmpty()) {
            resultTextView.setText("Please enter a number.");
            return;
        }

        int guess = Integer.parseInt(guessString);
        if (guess < randomNumber) {
            resultTextView.setText("Too low! Try again.");
        } else if (guess > randomNumber) {
            resultTextView.setText("Too high! Try again.");
        } else {
            resultTextView.setText("Congratulations! You guessed it right.");
            generateRandomNumber();  // Generate a new number for a new game
        }
    }
}
