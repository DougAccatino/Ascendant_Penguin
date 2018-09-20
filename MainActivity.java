package com.example.doug.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvShowCount;
    //private int myCounter = 0;
    private static final String TAG = "MainActivity";
    protected static final String KEY_SCORE = "scoreCount";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "inside onCreate");
        setContentView(R.layout.activity_main);
        tvShowCount = (TextView) findViewById(R.id.show_count);

        tvShowCount.setText(""+shared.myCounter);
        Log.d(TAG, "end of onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "inside onSaveInstanceState");
        outState.putInt("myCount", shared.myCounter);

        Log.d(TAG, "end of onSaveInstanceState myCounter="+ shared.myCounter);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        shared.myCounter = savedInstanceState.getInt("myCount", shared.myCounter);
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
        tvShowCount.setText(""+shared.myCounter);
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
        shared.myCounter++;
        tvShowCount.setText(""+shared.myCounter);
        Intent intent2 = new Intent(this, shared.class);
        if(shared.myCounter >= 5) {

            startActivity(intent2);
        }

    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY_SCORE, shared.myCounter); //intent.putExtra("scoreCount", myCounter);
        startActivity(intent);
    }

}