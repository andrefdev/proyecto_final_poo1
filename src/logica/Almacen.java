package logica;

import persistencia.BaseDeDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Array;
import java.util.*;

public class Almacen {
    private List<Producto> productos;
    private  List<Producto> productosSorteados = new ArrayList<>();
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
    public DefaultTableModel mostrarProductosPorCategoria(String categoria) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // Establecer la clase de la columna "Seleccionar" como Boolean para que se muestre el checkbox
                }
                return super.getColumnClass(columnIndex);
            }
        };
        productosSorteados = db.obtenerProductosPorCategoria(categoria);

        model.addColumn("Seleccionar");
        model.addColumn("Código");
        model.addColumn("Categoria");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");

        for (Producto producto : productosSorteados) {
            String precio = String.valueOf(producto.getPrecio());
            String codigo = String.valueOf(producto.getCodigo());
            // Añadir filas de datos
            Object[] rowData = new Object[]{
                    false,
                    codigo,
                    producto.getCategorias().toString(),
                    producto.getMarca(),
                    producto.getModelo(),
                    precio
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox())); // Establecer el editor de celdas como un checkbox en la columna "Seleccionar"
        table.getColumnModel().getColumn(0).setCellRenderer(table.getDefaultRenderer(Boolean.class)); // Personalizar el renderizador de la columna "Seleccionar"

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
    public void verStockDeUnProducto(){}
    public void verUnaCategoria(){}
    public String verProductosString(){
        List<Producto> productos = db.obtenerProductos();
        String x = "";
        for (Producto producto : productos
        ) {
            // Añadir filas de datos
            x = x + producto.toString() + "\n";
        }
        return x;
    }
}
