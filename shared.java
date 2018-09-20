package com.example.doug.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class shared extends AppCompatActivity {

   static int myCounter = 0;
   static int myCounter2 = 0;
   private static final String TAG = "shared";


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      Log.d(TAG, "inside onCreate");
      setContentView(R.layout.winner);

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

      Log.d(TAG, "end of onRestoreInstanceState");
   }

   @Override
   protected void onStart(){
      super.onStart();
      Log.d(TAG, "inside of onStart");
      setContentView( R.layout.winner);
      int team1score = myCounter-myCounter2;
      int team2score = myCounter2-myCounter;
      TextView textViewToChange = (TextView) findViewById(R.id.dWinner);
      if(myCounter >= 5) {
         textViewToChange.setText(

                 "Team 1 wins by " + team1score + "!");
      }
      if(myCounter2 >= 5) {
         textViewToChange.setText(

                 "Team 1 wins by " + team2score + "!");
      }
      Log.d(TAG, "end of onStart");
   }

   @Override
   protected void onResume() {
      super.onResume();
      Log.d(TAG, "inside of onResume");

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

   public void back(View view) {
      Intent intent = new Intent(this, MainActivity.class);
      shared.myCounter = 0;
      shared.myCounter2 = 0;
      startActivity(intent);
   }
}
