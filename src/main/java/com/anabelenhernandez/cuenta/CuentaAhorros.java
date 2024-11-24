package com.anabelenhernandez.cuenta;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        }
        if (saldo >= 10000) {
            activa = true;
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa && saldo >= cantidad) {
            super.retirar(cantidad);
            if (saldo < 10000) {
                activa = false;
            }
        }
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        activa = saldo >= 10000;
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión Mensual: " + comisionMensual);
        System.out.println("Número de Transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Cuenta Activa: " + activa);
    }
}
