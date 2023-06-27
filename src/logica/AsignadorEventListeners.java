package logica;

import gui.*;
import persistencia.BaseDeDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static logica.Almacen.calculateTotalPrice;

public class AsignadorEventListeners {
    private static Productos productos;
    private static MenuGerente menuGerente;
    private static MenuEmpleado menuEmpleado;
    private static AnadirProducto anadirProducto;
    private static AgregarEmpleado agregarEmpleado;
    private static EliminarEmpleado eliminarEmpleado;
    private static EliminarProducto eliminarProducto;
    private static CrearPedido crearPedido;
    private static FramePrincipal framePrincipal;
    private static Almacen almacen;
    private static Login login;
    private static BaseDeDatos db;
    private static Empleado empleado;
    private static Gerente gerente;
    private static Reportes reportes;
    private String usuario, contrasena;
    public AsignadorEventListeners() {
    }
    public void asignarJpaneles(Productos productos, MenuGerente menuGerente, MenuEmpleado menuEmpleado, AnadirProducto anadirProducto, AgregarEmpleado agregarEmpleado, EliminarEmpleado eliminarEmpleado, CrearPedido crearPedido, FramePrincipal framePrincipal, Almacen almacen, Login login, EliminarProducto eliminarProducto, Reportes reportes, BaseDeDatos db){
        this.productos = productos;
        this.menuGerente = menuGerente;
        this.menuEmpleado = menuEmpleado;
        this.anadirProducto = anadirProducto;
        this.agregarEmpleado = agregarEmpleado;
        this.eliminarEmpleado = eliminarEmpleado;
        this.eliminarProducto = eliminarProducto;
        this.crearPedido = crearPedido;
        this.framePrincipal = framePrincipal;
        this.almacen = almacen;
        this.reportes = reportes;
        this.login = login;
        this.db = db;
    }
    public void run(){
        asignarEventListenersMenuEmpleado();
        asignarEventListenersMenuGerente();
        asignarEventListenersProductos();
        asignarEventListenerAñadirProducto();
        asignarEventListenerCrearPedido();
        asignarEventeListenerEliminarEmpleado();
        asignarEventListenerLogin();
        asignarEventListenerAgregarEmpleado();
        asignarEventListenerEliminarProducto();
    }
    private static void asignarEventListenersMenuEmpleado(){
        menuEmpleado.setButtonClickListenerVerProductos(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(productos);
            }
        });
        menuEmpleado.setButtonClickListenerRegresar(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(login);
            }
        });
        menuEmpleado.setButtonClickListenerHacerPedido(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                crearPedido.actualizarModelo(almacen.mostrarProductosParaHacerPedido(""));
                crearPedido.getJTable().getColumnModel().getColumn(0).setCellRenderer(new Almacen.SpinnerRenderer());
                crearPedido.getJTable().getColumnModel().getColumn(0).setCellEditor(new Almacen.SpinnerEditor());
                framePrincipal.actualizarFrame(crearPedido);
            }
        });
    }
    private static void asignarEventListenersMenuGerente(){
        menuGerente.setButtonClickListenerAnadirProducto(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                db.actualizarProductos();
                framePrincipal.actualizarFrame(anadirProducto);
            }
        });
        menuGerente.setButtonClickListenerEliminarProducto(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(eliminarProducto);
                eliminarProducto.actualizarModelo(almacen.mostrarProductos());
            }
        });
        menuGerente.setButtonClickListenerAgregarEmpleado(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                db.actualizarEmpleados();
                framePrincipal.actualizarFrame(agregarEmpleado);
            }
        });
        menuGerente.setButtonClickListenerEliminarEmpleado(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                DefaultTableModel modelEmpleado = db.mostrarEmpleados();
                eliminarEmpleado.actualizarModelo(modelEmpleado);
                framePrincipal.actualizarFrame(eliminarEmpleado);
            }
        });
        menuGerente.setButtonClickListenerReportes(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                reportes.setModel(db.mostrarPedidos());
                framePrincipal.actualizarFrame(reportes);
            }
        });
        menuGerente.setButtonClickListenerRegresar(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(login);
            }
        });
    }
    private static void asignarEventListenersProductos(){
        productos.setButtonClickListenerRegresar(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(menuEmpleado);
            }
        });
        productos.setButtonClickListener(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                String categoria = productos.getTextField();
                DefaultTableModel modelo = almacen.mostrarProductosPorCategoria(categoria);
                productos.actualizarModelo(modelo);
            }
        });

    }
    private static void asignarEventListenerAñadirProducto(){
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
                framePrincipal.actualizarFrame(menuGerente);
            }
        });
    }
    private static void asignarEventListenerCrearPedido(){
        crearPedido.setButtonClickListenerConfirmarPedido(new ButtonClickListener() {
            JTable jTabla1 = crearPedido.getJTable();
            @Override
            public void onButtonClick() {
                String direccionCliente = crearPedido.getTxtDireccion();
                String nombreCliente = crearPedido.getTxtNombre();
                int dniCliente = Integer.parseInt(crearPedido.getTxtDni());
                Date fechaNacimientoCliente = crearPedido.getFechaNacimientoCliente();

                ArrayList<Producto> productos = new ArrayList<>();
                Cliente c = new Cliente(nombreCliente, dniCliente, fechaNacimientoCliente, direccionCliente);

                TableModel model = jTabla1.getModel();
                List<Almacen.CartItem> cartItems = new ArrayList<>();
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    int cantidad = (int) model.getValueAt(i, 0);
                    int codigo = (int) model.getValueAt(i, 1);
                    String categoriasString = (String) model.getValueAt(i, 2);
                    ArrayList<String> arrayCategorias = new ArrayList<>(Arrays.asList(categoriasString.split(", ")));
                    String marca = (String) model.getValueAt(i, 3);
                    String modelo = (String) model.getValueAt(i, 4);
                    int precio = (int) model.getValueAt(i, 5);

                    if (cantidad > 0) {
                        Producto producto = new Producto(arrayCategorias, marca, modelo, precio, codigo, 0);
                        Almacen.CartItem cartItem = new Almacen.CartItem(producto, cantidad, cantidad * precio);
                        cartItems.add(cartItem);
                    }
                    System.out.println(cartItems);
                }
                for (Almacen.CartItem cartItem : cartItems) {
                    Producto producto = new Producto(cartItem.getProducto().getCategorias(), cartItem.getProducto().getMarca(), cartItem.getProducto().getModelo(), cartItem.getProducto().getPrecio(), cartItem.getProducto().getCodigo(), cartItem.getProducto().getStock());
                    productos.add(producto);
                }
                int precioTotal = (int) calculateTotalPrice(cartItems);
                StringBuilder purchaseDetails = new StringBuilder();
                purchaseDetails.append("Detalles del pedido:\n\n");
                for (Almacen.CartItem cartItem : cartItems) {
                    purchaseDetails.append("Producto: ").append(cartItem.getProducto().getModelo()).append("\n");
                    purchaseDetails.append("Cantidad: ").append(cartItem.getQuantity()).append("\n");
                    purchaseDetails.append("Precio total del producto: $").append(cartItem.getTotalPrice()).append("\n\n");
                }
                purchaseDetails.append("Precio total del pedido: $").append(precioTotal);
                JOptionPane.showMessageDialog(framePrincipal, purchaseDetails.toString());
                Pedido pedido = new Pedido(productos, precioTotal, c);
                empleado.realizarPedido(almacen, pedido.getCodigo(), productos, precioTotal, c);

                framePrincipal.actualizarFrame(crearPedido);
            }

        });
        crearPedido.setButtonClickListenerRegresar(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(menuEmpleado);
            }
        });
    }
    private static void asignarEventeListenerEliminarEmpleado(){
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
                framePrincipal.actualizarFrame(menuGerente);

            }
        });
    }
    private static void asignarEventListenerEliminarProducto(){
        eliminarProducto.setButtonClickListenerRegresar(new ButtonClickListener(){
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(menuGerente);
            }
        });
        eliminarProducto.setButtonClickListenerEliminar(new ButtonClickListener(){
            @Override
            public void onButtonClick() {
                if (eliminarProducto.getCodigo() != 0){
                    int codigo = eliminarProducto.getCodigo();
                    db.eliminarProducto(codigo);
                    DefaultTableModel modeloActualizado = almacen.mostrarProductos();
                    eliminarProducto.actualizarModelo(modeloActualizado);
                    framePrincipal.revalidate();
                    framePrincipal.repaint();

                }
            }
        });
    }
    private static void asignarEventListenerLogin(){
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
                    empleado = db.obtenerEmpleadoConCredenciales(usuario, contrasena);
                    framePrincipal.setContentPane(menuEmpleado);
                    framePrincipal.revalidate();
                    framePrincipal.repaint();

                }else if(db.existeGerenteConCredenciales(usuario, contrasena)){
                    gerente = db.obtenerGerenteConCredenciales(usuario, contrasena);
                    framePrincipal.setContentPane(menuGerente);
                    framePrincipal.revalidate();
                    framePrincipal.repaint();
                }
            }
        });

    }
    private static void asignarEventListenerAgregarEmpleado(){
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
    }
    private static void asignarEventListenerReportes(){
        reportes.setButtonCLickListenerRegresar(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                framePrincipal.actualizarFrame(menuGerente);
            }
        });
    }
}
