package com.example.oneeight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //Variables
    private boolean[] poleBoolean = new boolean[10];
    private Button[] poleButton = new Button[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init of variables
        poleButton[0] = (Button) findViewById(R.id.reroll);
        poleButton[1] = (Button) findViewById(R.id.one);
        poleButton[2] = (Button) findViewById(R.id.two);
        poleButton[3] = (Button) findViewById(R.id.three);
        poleButton[4] = (Button) findViewById(R.id.four);
        poleButton[5] = (Button) findViewById(R.id.five);
        poleButton[6] = (Button) findViewById(R.id.six);
        poleButton[7] = (Button) findViewById(R.id.seven);
        poleButton[8] = (Button) findViewById(R.id.eight);
        poleButton[9] = (Button) findViewById(R.id.nine);

        //Inicializacia random booleanu a button listenerov pre kazdy button
        for(int i = 0; i < poleBoolean.length; i++){
            poleBoolean[i] = (Math.random() < 0.5);
            poleButton[i].setOnClickListener(onClickListener);
        }

        rerollClick();

    }

    //Metoda na rerollnutie buttonov
    private void rerollClick() {
        for (int i = 1; i < poleBoolean.length; i++) {
            poleBoolean[i] = (Math.random() < 0.5);
            if (poleBoolean[i]) {
                poleButton[i].setBackgroundColor(Color.BLACK);
            } else {
                poleButton[i].setBackgroundColor(Color.WHITE);
            }
        }
    }

    //Metoda na klikanie buttonov
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                //Rerollne vsetky buttony
                case R.id.reroll:
                    rerollClick();
                //Po kliknuti na urcity button zmeni farby okolitych buttonov
                case R.id.one:
                    ColorDrawable buttonColor = (ColorDrawable) poleButton[1].getBackground();
                    int colorId = buttonColor.getColor();

                    if(colorId == Color.BLACK){poleButton[1].setBackgroundColor(Color.WHITE);
                    }else{
                        poleButton[1].setBackgroundColor(Color.BLACK);
                         }
            }

        }
    };


}