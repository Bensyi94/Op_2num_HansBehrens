package com.example.op_2num_hansbehrens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText num1;
    private EditText num2;
    private Button suma;
    private Button resta;
    private Button multiplicacion;
    private Button division;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.etNum1);
        num2 = (EditText)findViewById(R.id.etNum2);
        resultado= (TextView)findViewById(R.id.txtRespuesta);
        suma = (Button)findViewById(R.id.btnSuma);
        resta = (Button)findViewById(R.id.btnResta);
        multiplicacion = (Button)findViewById(R.id.btnMultiplicacion);
        division = (Button)findViewById(R.id.btnDivision);
        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        division.setOnClickListener(this);
    }

    public void onClick(View v) {
        resultado(v);
    }

    private Integer[] numeros(EditText num1, EditText num2){
            Integer[] nums = {Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString())};
            return nums;
    }

    private void resultado(View v){
        try {
            Integer[] num = numeros(num1, num2);
            txtResultado(operacion(v, num));
        }catch(Exception ex){
            txtResultado("Error");
        }
    }

    private void txtResultado(Object resultado) {
        this.resultado.setText(String.valueOf(resultado));
    }

    private Integer operacion(View v, Integer[] num){
        switch (v.getId()){
            case R.id.btnSuma:
                return num[0] + num[1];
            case R.id.btnResta:
                return num[0] - num[1];
            case R.id.btnMultiplicacion:
                return num[0] * num[1];
            case R.id.btnDivision:
                return num[0] / num[1];
            default:
                return null;
        }
    }
}