package com.anabelenhernandez.cuenta;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0.0f;
    }

    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numConsignaciones++;
        }
    }

    public void retirar(float cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            numRetiros++;
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = tasaAnual / 12;
        saldo += saldo * interesMensual / 100;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Número de Consignaciones: " + numConsignaciones);
        System.out.println("Número de Retiros: " + numRetiros);
        System.out.println("Tasa Anual: " + tasaAnual);
        System.out.println("Comisión Mensual: " + comisionMensual);
    }


    public float getSaldo() {
        return saldo;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
}
