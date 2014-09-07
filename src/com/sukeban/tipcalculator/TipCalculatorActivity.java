package com.sukeban.tipcalculator;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	
	private EditText 		etAmount;
	private Button  		btTwenty;
	private Button  		btFifteen;
	private Button  		btTen;
	private EditText 		etCustom;
	private TextView 		txResult;
	private NumberFormat 	numberFormat;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        etAmount = (EditText)findViewById(R.id.etAmount);

        btTwenty = (Button)findViewById(R.id.btTwenty);
        btFifteen = (Button)findViewById(R.id.btFifteen);
        btTen = (Button)findViewById(R.id.btTen);

        etCustom = (EditText)findViewById(R.id.etCustom);
        
        txResult = (TextView)findViewById(R.id.txResult);
        
        numberFormat = NumberFormat.getCurrencyInstance();

    }
    
    private void calculatePercent(double percent) {
    	String amountText = etAmount.getText().toString();
   	 	double amountDouble = Double.parseDouble(amountText);
        double tipResult = amountDouble * percent;
        txResult.setText("Tip is: " + numberFormat.format(tipResult));   
    }
        	
     public void calculateTwentyPercent(View v) {
    	 calculatePercent(.20);
     }
     
     public void calculateFifteenPercent(View v) {
    	 calculatePercent(.15);
     }
     
     public void calculateTenPercent(View v) {
    	 calculatePercent(.10);
     }
     
     public void calculateCustomPercent(View v) {
    	 String tipText = etCustom.getText().toString();
    	 double tipDouble = Double.parseDouble(tipText)/100.0;
    	 calculatePercent(tipDouble);
     }     
}
