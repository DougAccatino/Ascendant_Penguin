package com.example.twins.tipcalculator;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.TextView;

import static com.example.twins.tipcalculator.MainActivity.currencyFormat;
import static com.example.twins.tipcalculator.MainActivity.tipTextView;
import static com.example.twins.tipcalculator.MainActivity.totalTextView;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        RadioButton rbNo, rbTip, rbTotal;

        rbNo = (RadioButton) findViewById(R.id.noRadio);
        rbTip = (RadioButton) findViewById(R.id.radioTip);
        rbTotal = (RadioButton) findViewById(R.id.radioTotal);
        TextView persontotal = (TextView) findViewById(R.id.perPersonText);

        //rbNo.isChecked();
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        if(id == 2){
            String getTipValue = tipTextView.getText().toString();
            double divideTip = Integer.parseInt(getTipValue);
            divideTip = divideTip / 2;

            String getTotalValue = totalTextView.getText().toString();
            double divideTotal = Integer.parseInt(getTotalValue);
            divideTotal = divideTotal / 2;

            if(rbNo.isChecked()){
                tipTextView.setText(currencyFormat.format(divideTip));
                persontotal.setText(currencyFormat.format(divideTotal));
            }
            if(rbTip.isChecked()){
                divideTip = Math.ceil(divideTip);
                tipTextView.setText(currencyFormat.format(divideTip));
                persontotal.setText(currencyFormat.format(divideTotal));
            }

        }
        if(id == 3){
            String getTipValue = tipTextView.getText().toString();
            double divideTip = Integer.parseInt(getTipValue);
            String getTipValue = tipTextView.getText().toString();
            int divideTip = Integer.parseInt(getTipValue);
            divideTip = divideTip / 3;


            String getTotalValue = totalTextView.getText().toString();
            int divideTotal = Integer.parseInt(getTotalValue);
            divideTotal = divideTotal / 3;


            if(rbNo.isChecked()){
                tipTextView.setText(currencyFormat.format(divideTip));
                persontotal.setText(currencyFormat.format(divideTotal));
            }
            if(rbTip.isChecked()){
                divideTip = Math.ceil(divideTip);
                tipTextView.setText(currencyFormat.format(divideTip));
                persontotal.setText(currencyFormat.format(divideTotal));
            }
        }
        if(id == 4){
            String getTipValue = tipTextView.getText().toString();
            int divideTip = Integer.parseInt(getTipValue);
            divideTip = divideTip / 4;
            tipTextView.setText(currencyFormat.format(divideTip));

            String getTotalValue = totalTextView.getText().toString();
            int divideTotal = Integer.parseInt(getTotalValue);
            divideTotal = divideTotal / 4;
            totalTextView.setText(currencyFormat.format(divideTotal));
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
