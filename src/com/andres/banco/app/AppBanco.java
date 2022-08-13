package com.andres.banco.app;

import com.andres.banco.dominio.CuentaBancaria;
import com.andres.banco.dominio.Persona;

public class AppBanco {
    public static void main(String[] args) {
        Persona Andres = new Persona("Andres");
        Persona Diana = new Persona("Diana", 123);

        CuentaBancaria cuentaDiana = new CuentaBancaria(Diana, "Ahorros", 8162);
        CuentaBancaria cuentaAndres = new CuentaBancaria(Andres, "Ahorros", 4781);

        cuentaAndres.consignar(100000);
        cuentaAndres.retirar(50000);
        cuentaAndres.transferir(cuentaDiana, 45000);

        System.out.println(cuentaAndres.consultarSaldoActual());
        System.out.println(cuentaDiana.consultarSaldoActual());
    }
}
