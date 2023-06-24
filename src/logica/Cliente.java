package logica;

import java.sql.Date;
import java.time.LocalDate;

public class Cliente extends Persona {
    private String direccion;

    public Cliente(String nombre, int dni, Date fechaNacimiento, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.direccion = direccion;
    }

    public void realizarPedido(){

    }
}
