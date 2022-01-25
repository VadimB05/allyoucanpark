package com.example.allyoucanpark;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Instanzvariablen der xml-Elemente
    Button loginBtn;
    Button registerBtn;
    // MapView mapView;
    // todo: navigation / menü

    // todo: Map?



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml-Elemente verknüpfen per "find view by ID"
        loginBtn = findViewById(R.id.loginMainActivityBtn);
        registerBtn = findViewById(R.id.registerMainActivityBtn);
        // mapView = findViewById(R.id.mapMainActivityMapView);
        // todo: navigation

        // OnClickListener für den Login-Button, der zur Loginseite weiterführt
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        // todo: Map
        // tdo Navigate / menü

    }
}