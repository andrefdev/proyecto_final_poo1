package logica;

import persistencia.BaseDeDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class Almacen {
    private List<Producto> productos;
    private  List<Producto> productosSorteados = new ArrayList<>();
    BaseDeDatos db = new BaseDeDatos();
    public Almacen() {
    }
    public DefaultTableModel mostrarProductos(){
        productos = db.obtenerProductos();
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }

        };
        model.addColumn("Código");
        model.addColumn("Categorias");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");
        model.addColumn("Stock");

        for (Producto producto : productos
             ) {
            String precio = String.valueOf(producto.getPrecio());
            String codigo = String.valueOf(producto.getCodigo());
            String stock = String.valueOf(producto.getStock());
            System.out.println(producto.toString());
            // Añadir filas de datos
            model.addRow(new String[]{codigo, producto.getCategorias().toString(), producto.getMarca(), producto.getModelo(), precio, stock});
        }
        return model;
    }
    public DefaultTableModel mostrarProductosPorCategoria(String categoria) {
        DefaultTableModel model = new DefaultTableModel();
        productosSorteados = db.obtenerProductosPorCategoria(categoria);
        model.addColumn("Código");
        model.addColumn("Categorias");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");
        model.addColumn("Stock");

        for (Producto producto : productosSorteados) {
            String precio = String.valueOf(producto.getPrecio());
            String codigo = String.valueOf(producto.getCodigo());
            String stock = String.valueOf(producto.getStock());
            // Añadir filas de datos
            String[] rowData = new String[]{
                    codigo,
                    producto.getCategorias().toString(),
                    producto.getMarca(),
                    producto.getModelo(),
                    precio,
                    stock
            };
            model.addRow(rowData);
        }
        return model;
    }

    public DefaultTableModel mostrarProductosParaHacerPedido(String categoria) {
        productosSorteados = db.obtenerProductosPorCategoria(categoria);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cantidad");
        model.addColumn("Código");
        model.addColumn("Categorias");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");
        model.addColumn("Stock");

        for (Producto producto : productosSorteados) {
            int precio = producto.getPrecio();
            int codigo = producto.getCodigo();
            int stock = producto.getStock();
            // Añadir filas de datos
            model.addRow(new Object[]{0, codigo, producto.getCategorias().toString(), producto.getMarca(), producto.getModelo(), precio, stock});
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
    public void crearPedido(Empleado empleado, int codigo, ArrayList productosArray, int precio, Cliente cliente) throws SQLException {
        db.agregarPedido(codigo, productosArray, precio, cliente);
    }


    public static double calculateTotalPrice(List<CartItem> items) {
        double totalPrice = 0.0;
        for (CartItem item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }


    public static class CartItem {
        private Producto producto;
        private int quantity;
        private double totalPrice;

        public CartItem(Producto producto, int quantity, double totalPrice) {
            this.producto = producto;
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }

        public Producto getProducto() {
            return producto;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

    public static class SpinnerRenderer extends DefaultTableCellRenderer {
        private JSpinner spinner;

        public SpinnerRenderer() {
            spinner = new JSpinner();
            spinner.setPreferredSize(new Dimension(50, 20));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }

    public static class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
        private JSpinner spinner;

        public SpinnerEditor() {
            spinner = new JSpinner();
            spinner.setPreferredSize(new Dimension(50, 20));
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }
}
