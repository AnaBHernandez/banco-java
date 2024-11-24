package com.anabelenhernandez.cuenta;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.sobregiro = 0.0f;
    }

    @Override
    public void retirar(float cantidad) {
        if (saldo >= cantidad) {
            super.retirar(cantidad);
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
        }
        numRetiros++;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad > sobregiro) {
                saldo += cantidad - sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión Mensual: " + comisionMensual);
        System.out.println("Número de Transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }

    public float getSobregiro() {
        return sobregiro;
    }
}
