package logica;

import java.util.ArrayList;


public class Pedido {
    private int codigo;
    private ArrayList<Producto> productos;
    private int precio;
    private Cliente cliente;

    public Pedido(ArrayList<Producto> productos, int precio, Cliente cliente) {
        this.codigo += 1;
        this.productos = productos;
        this.precio = precio;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }
}
