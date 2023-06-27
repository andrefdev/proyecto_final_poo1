package logica;

import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Empleado extends Persona{
    private int sueldo;
    private int ruc;

    public Empleado(String nombre, int dni, Date fechaNacimiento, int sueldo, int ruc) {
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
    public void realizarPedido(Almacen almacen, int codigo, ArrayList<Producto> productos, int precio, Cliente c){
        try {
            almacen.crearPedido(this, codigo, productos, precio, c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                ", ruc=" + ruc +
                '}';
    }
}
