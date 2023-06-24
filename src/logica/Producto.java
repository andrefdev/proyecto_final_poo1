package logica;

import java.util.ArrayList;

public class Producto {
    private int codigo;
    private int precio;
    private String marca;
    private ArrayList<String> categorias;
    private String modelo;
    private int stock;

    public Producto(ArrayList<String> categorias, String marca, String modelo, int precio, int codigo, int stock) {
        this.categorias = categorias;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.codigo = codigo;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean tieneCategoria(String categoria) {
        return categorias.contains(categoria);
    }
    public void anadirCategoria(String categoria) {
        categorias.add(categoria);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", categorias=" + categorias +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}