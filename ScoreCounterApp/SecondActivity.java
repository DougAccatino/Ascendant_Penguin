package com.example.doug.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private TextView tvdisplay;
    //private int myCounter2 = 0;
    private static final String TAG = "SecondActivity";
    protected static final String KEY_SCORE = "scoreCount";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "inside onCreate");

        tvdisplay = (TextView)findViewById(R.id.tv_display2);

        //Get intent from he originating activity be sure to use the correct key to get the value
        Intent intent = getIntent();
        String strScoreCount = intent.getExtras().get(MainActivity.KEY_SCORE).toString();
        tvdisplay.setText(strScoreCount);


        Log.d(TAG, "end of onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "inside onSaveInstanceState");
        outState.putInt("myCount", shared.myCounter2);

        Log.d(TAG, "end of onSaveInstanceState myCounter="+ shared.myCounter2);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        shared.myCounter2 = savedInstanceState.getInt("myCount", shared.myCounter2);
        Log.d(TAG, "end of onRestoreInstanceState");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "inside of onStart");

        Log.d(TAG, "end of onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "inside of onResume");
        tvdisplay.setText(""+shared.myCounter2);
        Log.d(TAG, "end of onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "inside of onRestart");

        Log.d(TAG, "end of onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "inside of onPause");

        Log.d(TAG, "end of onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "inside of onStop");

        Log.d(TAG, "end of onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside of onDestroy");

        Log.d(TAG, "end of onDestroy");
    }

    public void countUp(View view) {
        shared.myCounter2++;
        tvdisplay.setText(""+shared.myCounter2);
        Intent intent2 = new Intent(this, shared.class);
        if(shared.myCounter2 >= 5) {

            startActivity(intent2);
        }
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(KEY_SCORE, shared.myCounter2); //intent.putExtra("scoreCount", myCounter);
        startActivity(intent);
    }


}