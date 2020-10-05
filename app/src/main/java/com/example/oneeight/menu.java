package com.example.oneeight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {

    //Variables
    private Button easy;
    private Button hardcore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        easy = (Button) findViewById(R.id.easy);
        hardcore = (Button) findViewById(R.id.hardcore);

    }

    public void chooseDifficulty(View v) {
        if(easy.getId() == v.getId()){
            setContentView(R.layout.activity_easy);
        }
        if(hardcore.getId() == v.getId()){
            setContentView(R.layout.activity_hardcore);
        }
    }

}

