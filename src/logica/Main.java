package logica;
import com.formdev.flatlaf.FlatDarkLaf;
import gui.*;
import persistencia.BaseDeDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;


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
                MenuGerente menuGerente = new MenuGerente();
                AnadirProducto anadirProducto = new AnadirProducto();
                login.setButtonClickListener(new ButtonClickListener() {
                    @Override
                    public void onButtonClick() {
                        System.out.println(login.getTxtFieldUsuario());
                        System.out.println(login.getPasswordField());
                        int dni = 0;
                        try {
                            dni = Integer.parseInt(login.getTxtFieldUsuario());
                        }catch (NumberFormatException e){
                            e.printStackTrace();
                        }
                        if(db.existeEmpleado(dni)){
                            framePrincipal.setContentPane(productos);
                            framePrincipal.revalidate();
                            framePrincipal.repaint();
                        }else if(db.existeGerente(dni)){
                            framePrincipal.setContentPane(menuGerente);
                            framePrincipal.revalidate();
                            framePrincipal.repaint();
                            anadirProducto.setButtonClickListener(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    int codigo = Integer.parseInt(anadirProducto.getTxtCodigo());
                                    String marca = anadirProducto.getTxtMarca();
                                    String modelo = anadirProducto.getTxtModelo();
                                    int precio = Integer.parseInt(anadirProducto.getTxtPrecio());
                                    String categoriasString = anadirProducto.getTxtCategorias();
                                    ArrayList<String> arrayCategorias = new ArrayList<>(Arrays.asList(categoriasString.split(",")));
                                    almacen.anadirProducto(arrayCategorias, marca, modelo, precio, codigo);
                                    JOptionPane.showMessageDialog(anadirProducto, "producto agregado exitosamente");
                                    anadirProducto.resetTextFields();
                                }
                            });
                        }
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