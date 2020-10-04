package com.example.oneeight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //Variables
    private boolean[][] poleBoolean = new boolean[4][4];
    private Button[][] poleButton = new Button[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init of variables
        poleButton[0][0] = (Button) findViewById(R.id.reroll);
        poleButton[1][1] = (Button) findViewById(R.id.one);
        poleButton[1][2] = (Button) findViewById(R.id.two);
        poleButton[1][3] = (Button) findViewById(R.id.three);
        poleButton[2][1] = (Button) findViewById(R.id.four);
        poleButton[2][2] = (Button) findViewById(R.id.five);
        poleButton[2][3] = (Button) findViewById(R.id.six);
        poleButton[3][1] = (Button) findViewById(R.id.seven);
        poleButton[3][2] = (Button) findViewById(R.id.eight);
        poleButton[3][3] = (Button) findViewById(R.id.nine);

        //Inicializacia random booleanu a button listenerov pre kazdy button
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++) {
                poleBoolean[i][j] = (Math.random() < 0.5);
            }
        }

        reroll();

    }

    //Metoda na rerollnutie buttonov
    private void reroll() {
        for (int i = 1; i < 4; i++) {
            for(int j = 1; j < 4; j++) {
                poleBoolean[i][j] = (Math.random() < 0.5);
                if (poleBoolean[i][j]) {
                    poleButton[i][j].setBackgroundColor(Color.BLACK);
                } else {
                    poleButton[i][j].setBackgroundColor(Color.WHITE);
                }
            }
        }
    }

    public void rerollClick(View v){
        reroll();
    }

    public void changeColor(int i, int j){
        ColorDrawable buttonColor = (ColorDrawable) poleButton[i][j].getBackground();
        int colorId = buttonColor.getColor();
        if(colorId == Color.WHITE){
            poleButton[i][j].setBackgroundColor(Color.BLACK);
        }else{
            poleButton[i][j].setBackgroundColor(Color.WHITE);
        }
    }

    //Metoda na klikanie buttonov
    public void buttonClick(View v) {
        int x = 0;
        int y = 0;
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if(poleButton[i][j].getId() == v.getId()){
                        x = i;
                        y = j;
                        break;
                    }

                }
            }
        try{
            changeColor(x + 1, y);
        }catch(IndexOutOfBoundsException e){}
        try{
            changeColor(x, y + 1);
        }catch(IndexOutOfBoundsException e){}
        try{
            changeColor(x - 1, y);
        }catch(IndexOutOfBoundsException e){}
        try{
            changeColor(x, y - 1);
        }catch(IndexOutOfBoundsException e){}
    }
}