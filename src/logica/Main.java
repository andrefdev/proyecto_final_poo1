package logica;
import com.formdev.flatlaf.FlatDarkLaf;
import gui.*;
import persistencia.BaseDeDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Tema oscuro
        FlatDarkLaf.setup();

        // Almacen (almacena todos los productoss)
        Almacen almacen = new Almacen();

        BaseDeDatos db = new BaseDeDatos();

        System.out.println(db.existeProducto(10));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Frame principal
                FramePrincipal framePrincipal = new FramePrincipal();

                // Paneles
                Login login = new Login();
                DefaultTableModel model = almacen.mostrarProductos();
                Productos productos = new Productos(model);
                //almacen.setCategoria(categoria);
                AnadirProducto anadirProducto = new AnadirProducto();

                login.setButtonClickListener(new ButtonClickListener() {
                    @Override
                    public void onButtonClick() {
                        framePrincipal.setContentPane(productos);
                        framePrincipal.revalidate();
                        framePrincipal.repaint();
                    }
                });
                productos.setButtonClickListener(new ButtonClickListener() {
                    @Override
                    public void onButtonClick() {
                        String categoria = productos.getTextField();
                        DefaultTableModel modelo = almacen.mostrarProductosPorCategoria(categoria);
                        productos.actualizarModelo(modelo);
                        framePrincipal.revalidate();
                        framePrincipal.repaint();
                    }
                });
                framePrincipal.setContentPane(login);
                framePrincipal.pack();
                framePrincipal.setVisible(true);
                framePrincipal.setLocationRelativeTo(null);
            }
        });


    }
}