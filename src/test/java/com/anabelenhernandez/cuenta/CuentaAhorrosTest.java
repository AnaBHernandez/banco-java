package com.anabelenhernandez.cuenta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaAhorrosTest {
    private CuentaAhorros cuentaAhorros;

    @BeforeEach
    void setUp() {
        cuentaAhorros = new CuentaAhorros(10000, 3);
    }

    @Test
    void testConsignar() {
        cuentaAhorros.consignar(2000);
        assertEquals(12000, cuentaAhorros.getSaldo());
    }

    @Test
    void testRetirar() {
        cuentaAhorros.retirar(3000);
        assertEquals(7000, cuentaAhorros.getSaldo());
    }

    @Test
    void testExtractoMensual() {
        cuentaAhorros.setComisionMensual(50);
        cuentaAhorros.retirar(4000);
        cuentaAhorros.retirar(1000);
        cuentaAhorros.extractoMensual();
        assertEquals(3957.2, cuentaAhorros.getSaldo(), 0.1);
    }
}
