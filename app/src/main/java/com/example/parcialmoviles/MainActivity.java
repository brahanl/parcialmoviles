package com.example.parcialmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1EditText;
    private EditText valor2EditText;
    private EditText valor2EditText1;
    private EditText valor2EditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1EditText = findViewById(R.id.valor1EditText);
        valor2EditText = findViewById(R.id.valor2EditText);
        valor2EditText1 = findViewById(R.id.valor2EditText1);
        valor2EditText2 = findViewById(R.id.valor2EditText2);
    }

    public void sumar(View view) {
        if (validarCampos()) {
            enviarDatos("sumar");
        }
    }

    public void sumar2(View view) {
        if (validarCampos()) {
            enviarDatos("sumar2");
        }
    }

    public void sumar3(View view) {
        if (validarCampos()) {
            enviarDatos("sumar3");
        }
    }

    public void dividir(View view) {
        if (validarCampos()) {
            enviarDatos("dividir");
        }
    }

    public void potencia(View view) {
        if (validarCampos()) {
            enviarDatos("potencia");
        }
    }

    public void fibonacci(View view) {
        if (validarCampoValor1()) {
            enviarDatos("fibonacci");
        }
    }

    public void factorial(View view) {
        if (validarCampoValor1()) {
            enviarDatos("factorial");
        }
    }

    private boolean validarCampos() {
        if (valor1EditText.getText().toString().isEmpty() || valor2EditText.getText().toString().isEmpty() || valor2EditText1.getText().toString().isEmpty() || valor2EditText2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresa  valores.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validarCampoValor1() {
        if (valor1EditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresa el valor 1.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void enviarDatos(String operacion) {
        String valor1 = valor1EditText.getText().toString();
        String valor2 = valor2EditText.getText().toString();
        String valor3 = valor2EditText1.getText().toString();
        String valor4 = valor2EditText2.getText().toString();

        Operacion operacionObj = new Operacion(valor1, valor2, operacion, valor3,valor4);

        Intent intent = new Intent(this, OperacionActivity.class);
        intent.putExtra("operacion", operacionObj);
        startActivity(intent);
    }
}