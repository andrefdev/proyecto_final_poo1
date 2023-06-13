package logica;

import persistencia.BaseDeDatos;

import javax.swing.table.DefaultTableModel;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Almacen {
    private List<Producto> productos;
    BaseDeDatos db = new BaseDeDatos();
    public Almacen() {
    }
    public DefaultTableModel mostrarProductos(){
        productos = db.obtenerProductos();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Categoria");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");

        for (Producto producto : productos
             ) {
            String precio = String.valueOf(producto.getPrecio());
            String codigo = String.valueOf(producto.getCodigo());
            System.out.println(producto.toString());
            // Añadir filas de datos
            model.addRow(new String[]{codigo, producto.getCategorias().toString(), producto.getMarca(), producto.getModelo(), precio});
        }
        return model;
    }
    public DefaultTableModel mostrarProductosPorCategoria(String categoria){
        productos = db.obtenerProductosPorCategoria(categoria);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Categoria");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");

        for (Producto producto : productos
        ) {
            System.out.println(producto);
            String precio = String.valueOf(producto.getPrecio());
            String codigo = String.valueOf(producto.getCodigo());
            System.out.println(producto.toString());
            // Añadir filas de datos
            model.addRow(new String[]{codigo, producto.getCategorias().toString(), producto.getMarca(), producto.getModelo(), precio});
        }
        return model;
    }
    public void anadirProducto(ArrayList<String> categorias, String marca, String modelo, int precio, int codigo){
        db.agregarProducto(codigo, precio, marca, categorias, modelo);
    }
    public void eliminarProducto(int codigo){
        db.eliminarProducto(codigo);
    }
    public void buscarProducto(int codigo){
        db.buscarProducto(codigo);
    }
    public boolean existeProducto(int codigo){
        return db.existeProducto(codigo);
    }
    public List<Producto> obtenerProductosPorCategoria(String categoria){
        List<Producto> productosPorCategoria = db.obtenerProductosPorCategoria(categoria);
        return productosPorCategoria;
    }
    public List<Producto> obtenerProductos(){
        return db.obtenerProductos();
    }
    public void verSiExisteProducto(int codigo){
        existeProducto(codigo);
    }
    public void verStockDeUnProducto(){}
    public void verUnaCategoria(){}
    public String verProductosString(){
        String x = "";
        for (Producto producto : productos
        ) {
            // Añadir filas de datos
            x = x + producto.toString() + "\n";
        }
        return x;
    }
}
