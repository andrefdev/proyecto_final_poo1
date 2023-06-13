package logica;

import java.time.LocalDate;
import java.util.Date;

public class Cliente extends Persona {
    private String direccion;

    public Cliente(String nombre, int dni, LocalDate fechaNacimiento, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.direccion = direccion;
    }
    public void realizarPedido(){

    }
}
