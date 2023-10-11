package com.daw;

public class Cuenta 
{
    private String numero;
    private float saldo;

    public Cuenta(String numCta, float saldoCta) {
        this.numero = numCta;
        this.saldo = saldoCta;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void ingresarDinero(float importe) {
        saldo += importe;
    }

    public void retirarDinero(float importe) {
        saldo -= importe;
    }

}
