package com.andres.banco.dominio;

public class CuentaBancaria {
    public Persona propietario;
    public String tipo;
    public int numero;
    public Banco banco;
    public String clave;
    public double saldo;
    public boolean activa;

    public CuentaBancaria(Persona propietario, String tipo, int numero) {
        this.propietario = propietario;
        this.tipo = tipo;
        this.numero = numero;
        this.saldo = 0; //Sobraría proque el valor por defecto de un double es 0.
        this.activa = true;
    }

    public boolean consignar(double montoAConsignar) {
        if (this.activa == true) {
            if (montoAConsignar > 0) {
                this.saldo += montoAConsignar;
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public boolean retirar(double montoARetirar) {
        if (activa == true) {
            if (montoARetirar <= this.saldo && saldo > 0) {
                saldo -= montoARetirar;
                return true;
            } else {
                System.out.println("La cuenta no está activa");
                return false;
            }
        } else {
            return false;
        }

    }

    public String consultarSaldoActual() {
        String mensaje = propietario.nombre + " Tu saldo actual es " + saldo;
        return mensaje;

    }

    public boolean transferir(CuentaBancaria destino, double montoATranferir) {
        boolean retiroBien = this.retirar(montoATranferir);
        if (retiroBien == true) {
            boolean consingoBienADestino = destino.consignar(montoATranferir);

            if (consingoBienADestino) {
                return true;
            } else {
                this.saldo += montoATranferir;
                System.out.println("Se retiró pero no se consigno a la cuenta destino. Operación fallida");
                return false;
            }
        }
        return false;
    }
}
