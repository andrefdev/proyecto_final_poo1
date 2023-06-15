package logica;

import java.time.LocalDate;

import persistencia.BaseDeDatos;

public class Gerente extends Empleado {
    BaseDeDatos db = new BaseDeDatos();

    public Gerente(int dni, String nombre, int sueldo, int ruc, LocalDate fechaNacimiento) {
        super(dni, nombre, sueldo, ruc, fechaNacimiento);
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
