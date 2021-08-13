package com.example.numberpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    Button less_than, great_than, yes;
    TextView nbr_txt, count_txt;

    int min = 1, max = 1000;
    int random, count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize variables
        less_than = findViewById(R.id.less_than_btn);
        great_than = findViewById(R.id.great_than_btn);
        yes = findViewById(R.id.yes_btn);

        nbr_txt = findViewById(R.id.number_txt);
        count_txt = findViewById(R.id.final_count_txt);

        //generating random number
        Random rand = new Random();

        random = rand.nextInt(((max - min) + 1) + min);

        String st_text = String.valueOf(random);

        nbr_txt.setText(st_text);

        less_than.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    min = random;
                    Log.d(TAG, "..........." + random + " " + min + " " + max);
                    random = get_random(min, max);
                    nbr_txt.setText(String.valueOf(random));
                    count += 1;
                }
                catch(IllegalArgumentException e) {
                    String error_txt = "you are trying to cheating me\n please pick a number between 1-1000";
                    count_txt.setText(error_txt);
                    count_txt.setVisibility(View.VISIBLE);
                }
            }
        });

        great_than.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                max = random;
                try{
                    random = get_random(min, max);
                    Log.d(TAG, "..........." + random + " " + min + " " + max);
                    nbr_txt.setText(String.valueOf(random));
                    count += 1;
                }
                catch(IllegalArgumentException e) {
                    String error_txt = "you are trying to cheating me\n please pick a number between 1-1000";
                    count_txt.setText(error_txt);
                    count_txt.setVisibility(View.VISIBLE);
                }
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "It took " + String.valueOf(count) + " tries to find your number";
                count_txt.setText(result);
                count_txt.setVisibility(View.VISIBLE);
            }
        });

    }
    private int get_random(int min,int max){
        Random rand = new Random();

        int random = rand.nextInt(max - min) + min;

        return random;
    }
}