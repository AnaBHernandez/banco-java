package com.anabelenhernandez.cuenta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {
    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta(5000, 3);  
    }

    @Test
    public void testConsignar() {
        System.out.println("consignar");
        float cantidad = 1000.0F;  
        cuenta.consignar(cantidad);
        assertEquals(6000, cuenta.getSaldo(), "El saldo debería ser 6000 después de consignar 1000");
    }

    @Test
    public void testRetirar() {
        System.out.println("retirar");
        float cantidad = 1000.0F;  
        cuenta.retirar(cantidad);
        assertEquals(4000, cuenta.getSaldo(), "El saldo debería ser 4000 después de retirar 1000");
    }

    @Test
    public void testCalcularInteresMensual() {
        System.out.println("calcularInteresMensual");
        cuenta.calcularInteresMensual();
        assertEquals(5012.5, cuenta.getSaldo(), 0.1, "El saldo debería ser aproximadamente 5012.5 después de calcular el interés mensual");
    }

    @Test
    public void testExtractoMensual() {
        System.out.println("extractoMensual");
        cuenta.setComisionMensual(50);
        cuenta.extractoMensual();
        assertEquals(4994.9, cuenta.getSaldo(), 0.1, "El saldo debería ser aproximadamente 4994.9 después de aplicar la comisión mensual y calcular el interés mensual");
    }

    @Test
    public void testImprimir() {
        System.out.println("imprimir");
        cuenta.imprimir();
       
    }
}
