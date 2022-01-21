package com.example.allyoucanpark;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {

    TextView welcomeTV;

    String username = Login.inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTV = findViewById(R.id.welcomeWelcomeTV);

        welcomeTV.setText("Willkommen " + username);

    }
}