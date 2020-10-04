package com.example.oneeight;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class hardcore extends AppCompatActivity {

    //Variables
    private boolean[][] poleBoolean = new boolean[3][3];
    private Button[][] poleButton = new Button[3][3];
    private TextView endText;
    int black;
    int white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardcore);

        //Init of variables
        black = 0;
        white = 0;
        poleButton[0][0] = (Button) findViewById(R.id.one);
        poleButton[0][1] = (Button) findViewById(R.id.two);
        poleButton[0][2] = (Button) findViewById(R.id.three);
        poleButton[1][0] = (Button) findViewById(R.id.four);
        poleButton[1][1] = (Button) findViewById(R.id.five);
        poleButton[1][2] = (Button) findViewById(R.id.six);
        poleButton[2][0] = (Button) findViewById(R.id.seven);
        poleButton[2][1] = (Button) findViewById(R.id.eight);
        poleButton[2][2] = (Button) findViewById(R.id.nine);
        endText = (TextView)findViewById(R.id.endText);
        reroll();

    }

    //Metoda na rerollnutie buttonov
    private void reroll() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                poleBoolean[i][j] = (Math.random() < 0.5);
                if (poleBoolean[i][j]) {
                    poleButton[i][j].setBackgroundColor(Color.BLACK);
                    black++;
                } else {
                    poleButton[i][j].setBackgroundColor(Color.WHITE);
                    white++;
                }
            }
        }
    }

    //Zmeni farbu
    private void changeColor(int i, int j){
        ColorDrawable buttonColor = (ColorDrawable) poleButton[i][j].getBackground();
        int colorId = buttonColor.getColor();
        if(colorId == Color.WHITE){
            poleButton[i][j].setBackgroundColor(Color.BLACK);
            black++;
            white--;
        }else{
            poleButton[i][j].setBackgroundColor(Color.WHITE);
            black--;
            white++;
        }
    }

    private void winCondition(){
        if(black == 9){endText.setText("WIN!");}else{endText.setText(" ");}
        if(white == 9){endText.setText("WIN!");}else{endText.setText(" ");}
    }
    //rerolne
    public void rerollClick(View v){
        reroll();
    }

    //Metoda na menenie farieb buttonov
    public void buttonClick(View v) {
        int x = 0;
        int y = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(poleButton[i][j].getId() == v.getId()){
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
        try{
            changeColor(x, y);
        }catch(IndexOutOfBoundsException e){}
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

        winCondition();
    }
}