package com.example.parcialmoviles;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OperacionActivity extends AppCompatActivity {

    private TextView valor1TextView;
    private TextView valor2TextView;
    private TextView valor2TextView1;
    private TextView valor2TextView2;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);

        valor1TextView = findViewById(R.id.valor1TextView);
        valor2TextView = findViewById(R.id.valor2TextView);
        valor2TextView1 = findViewById(R.id.valor2TextView1);
        valor2TextView2 = findViewById(R.id.valor2TextView2);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        Intent intent = getIntent();
        if (intent != null) {
            Operacion operacionObj = (Operacion) intent.getSerializableExtra("operacion");

            if (operacionObj != null) {
                String valor1 = operacionObj.getValor1();
                String valor2 = operacionObj.getValor2();
                String valor3 = operacionObj.getValor3();
                String valor4 = operacionObj.getValor4();
                String operacion = operacionObj.getOperacion();

                valor1TextView.setText("id: " + valor1);
                valor2TextView.setText("celular: " + (valor2.isEmpty() ? "N/A" : valor2));
                valor2TextView1.setText("cedula: " + (valor3.isEmpty() ? "N/A" : valor3));
                valor2TextView2.setText("fecha de nacimiento: " + (valor3.isEmpty() ? "N/A" : valor4));

                double resultado = 0;

                if (operacion.equals("fibonacci")) {
                    if (valor1.isEmpty()) {
                        Toast.makeText(this, "Por favor ingresa el primer valor.", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    resultado = fibonacci(Integer.parseInt(valor1));
                } else {
                    if (valor1.isEmpty() || valor2.isEmpty()) {
                        Toast.makeText(this, "Por favor ingresa ambos valores.", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    resultado = calcularResultado(operacion, Double.parseDouble(valor1), Double.parseDouble(valor2),Double.parseDouble(valor3),Double.parseDouble(valor4));
                }

                resultadoTextView.setText("Resultado: " + resultado);
            }
        }
    }

    private double calcularResultado(String operacion, double valor1, double valor2,double valor3, double valor4) {
        switch (operacion) {
            case "sumar":
                return Double.parseDouble("2500000");
            case "sumar1":
                return Double.parseDouble("4000000");
            case "sumar2":
                return Double.parseDouble("5000000");
            case "dividir":
                return valor1 / valor2;
            case "potencia":
                return Math.pow(valor1, valor2);
            case "factorial":
                return factorial((int) valor1);
            default:
                return 0;
        }
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            int fib = 1;
            int prevFib = 1;

            for (int i = 2; i < n; i++) {
                int temp = fib;
                fib += prevFib;
                prevFib = temp;
            }

            return fib;
        }
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}