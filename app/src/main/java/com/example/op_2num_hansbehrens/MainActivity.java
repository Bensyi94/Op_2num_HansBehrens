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

    /**
     * Maneja eventos de Click en botones (btnSuma, btnResta, btnMultiplicacion, btnDivision)
     * @param v : View
     */
    public void onClick(View v) {
        resultado(v);
    }

    /**
     * Realiza la operacion y escribe el resultado,
     * en caso de obtener un error (error de usuario, division por 0, etc)
     * escribira "Error"
     * @param v : View
     */
    private void resultado(View v){
        try{
            txtResultado(operacion(v, numeros(num1, num2)));
        }
        catch(Exception ex) {
            txtResultado("Error");
        }
    }

    /**
     * Escribe en el TextView "resultado" el resultado o error obtenido
     * por la operacion
     * @param resultado : Object
     */
    private void txtResultado(Object resultado) {
        this.resultado.setText(String.valueOf(resultado));
    }

    /**
     * Segun el boton que se presiona se realiza la operacion
     * correspondiente
     * @param v : View
     * @param num : Integer[]
     * @return resultado de la operacion : Integer
     */
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

    /**
     * Convierte los numeros de EditText num1 y num2
     * a un Array de 2 posiciones con los valores como
     * Integer
     * @param num1 : EditText
     * @param num2 : EditText
     * @return : Integer[]
     */
    private Integer[] numeros(EditText num1, EditText num2){
        return new Integer[]{Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString())};
    }

}