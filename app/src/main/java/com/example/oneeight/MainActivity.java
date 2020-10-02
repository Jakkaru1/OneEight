package com.example.oneeight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //Variables
    boolean[] pole = new boolean[10];
    Button[] poleButtons = new Button[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init of variables
        poleButtons[0] = (Button) findViewById(R.id.reroll);
        poleButtons[1] = (Button) findViewById(R.id.one);
        poleButtons[2] = (Button) findViewById(R.id.two);
        poleButtons[3] = (Button) findViewById(R.id.three);
        poleButtons[4] = (Button) findViewById(R.id.four);
        poleButtons[5] = (Button) findViewById(R.id.five);
        poleButtons[6] = (Button) findViewById(R.id.six);
        poleButtons[7] = (Button) findViewById(R.id.seven);
        poleButtons[8] = (Button) findViewById(R.id.eight);
        poleButtons[9] = (Button) findViewById(R.id.nine);

        for(int i = 0; i < pole.length; i++){
            pole[i] = (Math.random() < 0.5);
            poleButtons[i].setOnClickListener(onClickListener);
        }

        rerollClick();
        /* kontrola random boolean
        for(int i = 0; i < pole.length; i++){
            System.out.println(pole[i]);
        };
        */
    }

    //Metoda na rerollnutie buttonov
    private void rerollClick(){
        for(int i = 0; i < pole.length; i++){
            pole[i] = (Math.random() < 0.5);
            if(pole[i]){poleButtons[i].setBackgroundColor(Color.BLACK);}else{poleButtons[i].setBackgroundColor(Color.WHITE);}
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
                /*case R.id.one:
                    ColorDrawable buttonColor = (ColorDrawable) two.getBackground();
                    if(buttonColor == black){two.setBackgroundColor(Color.WHITE);}else{two.setBackgroundColor(Color.BLACK)};*/
            }

        }
    };


}