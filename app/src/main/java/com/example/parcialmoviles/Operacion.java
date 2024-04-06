package com.example.parcialmoviles;
import java.io.Serializable;

public class Operacion implements Serializable {
    private String valor1;
    private String valor2;
    private String valor3;
    private String valor4;
    private String operacion;

    public Operacion(String valor1, String valor2, String operacion, String valor3, String valor4) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
        this.valor4 = valor4;
        this.operacion = operacion;
    }

    public String getValor1() {
        return valor1;
    }

    public String getValor2() {
        return valor2;
    }
    public String getValor3() {
        return valor3;
    }
    public String getValor4() {
        return valor4;
    }

    public String getOperacion() {
        return operacion;
    }
}