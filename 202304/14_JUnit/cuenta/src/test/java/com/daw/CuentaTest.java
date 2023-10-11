package com.daw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CuentaTest 
{

    @Test
    public void testGetSaldo()
    {
        Cuenta cuenta1 = new Cuenta("ES112233445566778899", 100);
        float saldo = cuenta1.getSaldo();
        assertEquals(90, saldo, 0);
    }

    @Test
    public void testIngresarDinero()
    {

    }

    @Test
    public void testRetirarDinero()
    {

    }
}
