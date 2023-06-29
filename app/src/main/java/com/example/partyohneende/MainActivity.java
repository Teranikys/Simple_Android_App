package com.example.partyohneende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    ConstraintLayout layout;
    int[] colors = {Color.RED, Color.GREEN, Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        layout = findViewById(R.id.background);

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("IntValue", 0);
        layout.setBackgroundColor(colors[prefs.getInt("IntValue", 0)]);
        editor.apply();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("IntValue", (prefs.getInt("IntValue", 0) + 1) % 3);
                editor.apply();
                layout.setBackgroundColor(colors[prefs.getInt("IntValue", 1)]);
            }
        });
    }

}