package com.miguel.calculaimc;

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void calculaIMC(View view) {
    	EditText selectorPeso = (EditText) findViewById(R.id.selectorPeso);
    	EditText selectorAltura = (EditText) findViewById(R.id.selectorAltura);
    	int peso = Integer.parseInt(selectorPeso.getText().toString());
    	int altura = Integer.parseInt(selectorAltura.getText().toString());
    	BigDecimal imc;
    	if (altura == 0) {
    		imc = new BigDecimal(0);
    	} else {
    		imc = calculaIMC(peso, altura);
    	}
    	TextView textImc = (TextView) findViewById(R.id.IMC);
    	textImc.setText(String.valueOf(imc));
    }
    
    private BigDecimal calculaIMC(int peso, int altura) {
    	BigDecimal imc = new BigDecimal(peso * 10000); 
    	return imc.divide(new BigDecimal(altura * altura), 2, RoundingMode.UP);
    }
}
