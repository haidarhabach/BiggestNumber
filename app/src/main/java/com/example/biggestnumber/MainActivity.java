package com.example.biggestnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2;
    private TextView tvResult;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle edge-to-edge layout padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        b1 = findViewById(R.id.number1);
        b2 = findViewById(R.id.number2);
        tvResult = findViewById(R.id.result);
        random = new Random();

        // Set initial values
        tvResult.setText("0");
        generateNewNumbers();
    }

    private void generateNewNumbers() {
        int x1 = random.nextInt(100); // 0–99
        int x2 = random.nextInt(100); // 0–99
        b1.setText(String.valueOf(x1));
        b2.setText(String.valueOf(x2));
    }

    public void button1_click(View view) {
        int v1 = Integer.parseInt(b1.getText().toString());
        int v2 = Integer.parseInt(b2.getText().toString());

        if (v1 >= v2) {
            updateScore();
        }
        generateNewNumbers();
    }

    public void button2_click(View view) {
        int v1 = Integer.parseInt(b1.getText().toString());
        int v2 = Integer.parseInt(b2.getText().toString());

        if (v2 >= v1) {
            updateScore();
        }
        generateNewNumbers();
    }

    private void updateScore() {
        int currentScore;
        try {
            currentScore = Integer.parseInt(tvResult.getText().toString());
        } catch (NumberFormatException e) {
            currentScore = 0;
        }
        tvResult.setText(String.valueOf(currentScore + 1));
    }
}
