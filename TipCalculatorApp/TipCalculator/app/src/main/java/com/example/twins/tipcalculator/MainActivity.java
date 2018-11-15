package com.example.twins.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
  import android.text.TextWatcher; // EditText listener
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
   import android.widget.SeekBar; // for changing the tip percentage
  import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView; // for displaying text
import android.widget.Toast;

import java.text.NumberFormat; // for currency formatting


public  class MainActivity extends AppCompatActivity  implements TextWatcher,
    SeekBar.OnSeekBarChangeListener {
    //declare your variables for the widgets
    private EditText editText_BillAmount;
    private TextView textViewBillAmount;  // shows formatted bill amount
    private SeekBar percentSeekBar;

    private static TextView percentTextView;
    // shows tip percentage

    public static TextView tipTextView; // shows calculated tip amount
    public static TextView totalTextView; // shows calculated total bill amount


    //declare the variables for the calculations
    private static double billAmount = 0.0;  // bill amount entered by the user
    private static double percent = .15;  // initial tip percentage

    //set the number formats to be used for the $ amounts , and % amounts
    public static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();
    // currency and percent formatter objects


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // get references to programmatically manipulated TextViews
        // set amountEditText's TextWatcher
        percentTextView = (TextView) findViewById( R.id.percentTextView );

        tipTextView = (TextView) findViewById( R.id.tip_Amount );


        textViewBillAmount = (TextView) findViewById( R.id.textView_BillAmount );




        totalTextView = (TextView) findViewById( R.id.total_Amount);

        tipTextView.setText( currencyFormat.format( 0 ) ); // set text to 0
        totalTextView.setText( currencyFormat.format( 0 ) ); // set text to 0

        // set amountEditText's TextWatcher
        // add listeners to widgets
        editText_BillAmount = (EditText) findViewById( R.id.editText_BillAmount );
        editText_BillAmount.addTextChangedListener( (TextWatcher) this );

        textViewBillAmount = (TextView) findViewById( R.id.textView_BillAmount );
        editText_BillAmount.addTextChangedListener( (TextWatcher) this );


        percentSeekBar = (SeekBar) findViewById( R.id.percentSeeBar );
        percentTextView = (TextView) findViewById( R.id.percentTextView );
        percentSeekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentTextView.setText( String.valueOf( progress ) );
                percent = progress / 100.00; //calculate percent based on seeker value
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        } );
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.number_arrays, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }





    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    /*
    Note:   int i, int i1, and int i2
            represent start, before, count respectively
            The charSequence is converted to a String and parsed to a double for you
     */

    @Override
    public void onTextChanged(CharSequence charSequence, int  Start, int  before, int count) {
        Log.d( "MainActivity", "inside onTextChanged method: charSequence= " + charSequence );

        //surround risky calculations with try catch (what if billAmount is 0 ?
        //charSequence is converted to a String and parsed to a double for you
        try {
            billAmount = Double.parseDouble( charSequence.toString() ) / 100.00;
            Log.d( "MainActivity", "Bill Amount = " + billAmount );

            //setText on the textView
            textViewBillAmount.setText( currencyFormat.format( billAmount ) );
            //perform tip and total calculation and update UI by calling calculate
            calculate();//uncomment this line
        } catch (NumberFormatException e) {
            editText_BillAmount.setText( "NOT GOOD" );
            billAmount = 0.0;
        }
        calculate();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    // calculate and display tip and total amounts
    public void calculate() {
        Log.d( "MainActivity", "inside calculate method" );


        percentTextView.setText( percentFormat.format(percent));

        // calculate the tip and total
        double  tip = billAmount * percent;
        double total = billAmount + tip;


        // display tip and total formatted as currency
        //user currencyFormat instead of percentFormat to set the textViewTip
        tipTextView.setText(currencyFormat.format(tip));
        totalTextView.setText(currencyFormat.format(total));
        //use the tip example to do the same for the Total


    }
}

