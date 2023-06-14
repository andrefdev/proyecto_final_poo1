package logica;

import java.time.LocalDate;

public class Gerente extends Empleado{
    public Gerente(int dni, String nombre, int sueldo, int ruc, LocalDate fechaNacimiento) {
        super(dni, nombre, sueldo, ruc, fechaNacimiento);
    }

    public void anadirProducto(){}
    public void editarProducto(){}
    public void eliminarProducto(){}
}
