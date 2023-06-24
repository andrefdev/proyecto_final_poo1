package logica;

import java.sql.Date;
import java.time.LocalDate;

import persistencia.BaseDeDatos;

public class Gerente extends Empleado {
    BaseDeDatos db = new BaseDeDatos();

    public Gerente(String nombre, int dni, Date fechaNacimiento, int sueldo, int ruc) {
        super(nombre, dni, fechaNacimiento, sueldo, ruc);
    }

    public void anadirProducto() {

        // db.anadir
    }

    public void editarProducto() {}

    public void eliminarProducto() {}

    @Override
    public String toString() {
        return "Gerente{" +
                "sueldo=" + getSueldo() +
                ", ruc=" + getRuc() +
                '}';
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
