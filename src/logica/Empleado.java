package logica;

import java.time.LocalDate;

public class Empleado extends Persona{
    private int sueldo;
    private int ruc;

    public Empleado(int dni, String nombre, int sueldo, int ruc, LocalDate fechaNacimiento) {
        super(nombre, dni, fechaNacimiento);
        this.sueldo = sueldo;
        this.ruc = ruc;
    }

    public int getSueldo() {
        return sueldo;
    }

    public int getRuc() {
        return ruc;
    }

    public void agregarGerente(){

    }
    public void prepararPedido(){

    }

    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                ", ruc=" + ruc +
                '}';
    }
}
