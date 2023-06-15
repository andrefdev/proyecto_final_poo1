package logica;
import com.formdev.flatlaf.FlatDarculaLaf;
import gui.*;
import persistencia.BaseDeDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
                // Frame principal
                FramePrincipal framePrincipal = new FramePrincipal();
                // Paneles
                Login login = new Login();
                DefaultTableModel model = almacen.mostrarProductos();
                DefaultTableModel modelEmpleados = db.mostrarEmpleados();

                Productos productos = new Productos(model);
                MenuGerente menuGerente = new MenuGerente();
                AnadirProducto anadirProducto = new AnadirProducto();
                AgregarEmpleado agregarEmpleado = new AgregarEmpleado();
                EliminarEmpleado eliminarEmpleado = new EliminarEmpleado();

                login.setButtonClickListener(new ButtonClickListener() {
                    @Override
                    public void onButtonClick() {
                        System.out.println(login.getTxtFieldUsuario());
                        System.out.println(login.getPasswordField());

                        String usuario = null;
                        String contrasena = null;
                        try {
                            usuario = login.getTxtFieldUsuario();
                            contrasena = login.getPasswordField().toString();
                        }catch (NumberFormatException e){
                            e.printStackTrace();
                        }
                        if(db.existeEmpleadoConCredenciales(usuario, contrasena)){
                            framePrincipal.setContentPane(productos);
                            framePrincipal.revalidate();
                            framePrincipal.repaint();
                            productos.setButtonClickListenerRegresar(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    framePrincipal.setContentPane(login);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
                                }
                            });
                        }else if(db.existeGerenteConCredenciales(usuario, contrasena)){
                            framePrincipal.setContentPane(menuGerente);
                            framePrincipal.revalidate();
                            framePrincipal.repaint();
                            anadirProducto.setButtonClickListener(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    db.actualizarProductos();
                                    int codigo = Integer.parseInt(anadirProducto.getTxtCodigo());
                                    String marca = anadirProducto.getTxtMarca();
                                    String modelo = anadirProducto.getTxtModelo();
                                    int precio = Integer.parseInt(anadirProducto.getTxtPrecio());
                                    String categoriasString = anadirProducto.getTxtCategorias();
                                    ArrayList<String> arrayCategorias = new ArrayList<>(Arrays.asList(categoriasString.split(", ")));
                                    almacen.anadirProducto(arrayCategorias, marca, modelo, precio, codigo);
                                    JOptionPane.showMessageDialog(anadirProducto, "producto agregado exitosamente");
                                    anadirProducto.resetTextFields();
                                }
                            });
                            anadirProducto.setButtonClickListenerRegresar(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    framePrincipal.setContentPane(menuGerente);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
                                }
                            });
                            menuGerente.setButtonClickListenerAnadirProducto(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    db.actualizarProductos();
                                    framePrincipal.setContentPane(anadirProducto);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
                                }
                            });
                            menuGerente.setButtonClickListenerAgregarEmpleado(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    db.actualizarEmpleados();
                                    framePrincipal.setContentPane(agregarEmpleado);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
                                }
                            });
                            menuGerente.setButtonClickListenerEliminarEmpleado(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    eliminarEmpleado.actualizarModelo(modelEmpleados);
                                    framePrincipal.setContentPane(eliminarEmpleado);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
                                }
                            });
                            agregarEmpleado.setButtonClickListenerAnadirEmpleado(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    Long dni = Long.valueOf(agregarEmpleado.getTxtDni());
                                    String nombre = agregarEmpleado.getTxtNombre();
                                    int sueldo = agregarEmpleado.getTxtSueldo();
                                    int ruc = agregarEmpleado.getTxtRuc();
                                    Date fechaNacimiento = agregarEmpleado.getFechaNacimiento();
                                    db.agregarEmpleado(dni, nombre, sueldo, ruc, fechaNacimiento);
                                    agregarEmpleado.resetTextFields();
                                }
                            });
                            agregarEmpleado.setButtonClickListenerRegresar(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    framePrincipal.setContentPane(menuGerente);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
                                }
                            });
                            eliminarEmpleado.setButtonClickListenerEliminar(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    int dni = eliminarEmpleado.getTxtFieldEmpleado();
                                    db.eliminarEmpleado(dni);
                                    DefaultTableModel modeloActualizado = db.mostrarEmpleados();
                                    eliminarEmpleado.actualizarModelo(modeloActualizado);
                                    eliminarEmpleado.revalidate();
                                    eliminarEmpleado.repaint();
                                    framePrincipal.repaint();
                                }
                            });
                            eliminarEmpleado.setButtonClickListenerRegresar(new ButtonClickListener() {
                                @Override
                                public void onButtonClick() {
                                    framePrincipal.setContentPane(menuGerente);
                                    framePrincipal.revalidate();
                                    framePrincipal.repaint();
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
                login.setMinimumSize(framePrincipal.getSize());
                framePrincipal.setContentPane(login);
                framePrincipal.pack();
                framePrincipal.setVisible(true);
                framePrincipal.setLocationRelativeTo(null);
            }
        });
    }

}