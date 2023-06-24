package logica;
import com.formdev.flatlaf.FlatDarculaLaf;
import gui.*;
import persistencia.BaseDeDatos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Main {
    public static void main(String[] args) {
        // Tema oscuro
        FlatDarculaLaf.setup();
        // Almacen (almacena todos los productoss)
        Almacen almacen = new Almacen();
        // Inicialización de la base de datos
        BaseDeDatos db = new BaseDeDatos();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Modelos
                DefaultTableModel modelProductos = almacen.mostrarProductos();
                // Frame principal
                FramePrincipal framePrincipal = new FramePrincipal();
                // Paneles
                Login login = new Login();
                Productos productos = new Productos(modelProductos);
                MenuGerente menuGerente = new MenuGerente();
                MenuEmpleado menuEmpleado = new MenuEmpleado();
                AnadirProducto anadirProducto = new AnadirProducto();
                AgregarEmpleado agregarEmpleado = new AgregarEmpleado();
                Reportes reportes = new Reportes();
                EliminarEmpleado eliminarEmpleado = new EliminarEmpleado();
                EliminarProducto eliminarProducto = new EliminarProducto();
                CrearPedido crearPedido = new CrearPedido(modelProductos);
                AsignadorEventListeners asignadorEventListeners = new AsignadorEventListeners();
                asignadorEventListeners.asignarJpaneles(productos, menuGerente, menuEmpleado, anadirProducto, agregarEmpleado, eliminarEmpleado, crearPedido, framePrincipal, almacen, login,eliminarProducto, reportes, db);
                asignadorEventListeners.run();

               // login.setMinimumSize(framePrincipal.getSize());
                framePrincipal.setContentPane(login);
                framePrincipal.pack();
                framePrincipal.setVisible(true);
            }
        });
    }

}