package com.anabelenhernandez.cuenta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {
    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    void setUp() {
        cuentaCorriente = new CuentaCorriente(5000, 3);
    }

    @Test
    void testConsignarConSobregiro() {
        cuentaCorriente.retirar(6000);
        cuentaCorriente.consignar(2000);
        assertEquals(0, cuentaCorriente.getSaldo());
        assertEquals(3000, cuentaCorriente.getSobregiro());
    }

    @Test
    void testRetirarConSobregiro() {
        cuentaCorriente.retirar(7000);
        assertEquals(0, cuentaCorriente.getSaldo());
        assertEquals(2000, cuentaCorriente.getSobregiro());
    }

    @Test
    void testExtractoMensual() {
        cuentaCorriente.setComisionMensual(50);
        cuentaCorriente.extractoMensual();
        assertEquals(4950, cuentaCorriente.getSaldo());
    }
}
