package persistencia;

import com.sun.jdi.PrimitiveValue;
import logica.*;

import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator.*;

public class BaseDeDatos {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Gerente> gerentes = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Producto> productosTemp = new ArrayList<Producto>();
    private final String url ="jdbc:postgresql://db.byuiftitpxymesjwshot.supabase.co:5432/postgres?user=postgres&password=Loco23230211!";
    //private final Pattern patronDNI = Pattern.compile("^[0-9]{8}$");
    public List<Empleado> getEmpleados(){
        actualizarEmpleados();
        return empleados;
    }
    public boolean validarDni(String dni) {
        String regex = "^[0-9]{8}$";
        Pattern patronDNI = Pattern.compile(regex);
        Matcher matcher = patronDNI.matcher(dni);
        return matcher.matches();
    }
    public boolean validarFecha(String fecha) {
        String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        Pattern patronFecha = Pattern.compile(regex);
        Matcher matcher = patronFecha.matcher(fecha);
        return matcher.matches();
    }
    public boolean validarPrecio(String precio) {
        String regex = "^[0-9]{1,5}$";
        Pattern patronPrecio = Pattern.compile(regex);
        Matcher matcher = patronPrecio.matcher(precio);
        return matcher.matches();
    }
    public boolean validarCodigo(String precio) {
        String regex = "\\d{2,5}";
        Pattern patronPrecio = Pattern.compile(regex);
        Matcher matcher = patronPrecio.matcher(precio);
        return matcher.matches();
    }
    public void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // Manejo de excepciones
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // Manejo de excepciones
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Manejo de excepciones
                e.printStackTrace();
            }
        }
    }
    private void actualizarEmpleados() {
        empleados.clear();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from empleados");

            while (resultSet.next()) { // will traverse through all rows
                Integer dni = resultSet.getInt("dni");
                String nombre = resultSet.getString("nombre");
                Integer sueldo = resultSet.getInt("sueldo");
                Integer ruc = resultSet.getInt("ruc");
                Date fechaTemporal = resultSet.getDate("fecha_nacimiento");
                LocalDate fechaNacimiento = fechaTemporal.toLocalDate();

                Empleado empleado = new Empleado(dni, nombre, sueldo, ruc, fechaNacimiento);
                empleados.add(empleado);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    private void actualizarGerentes() {
        gerentes.clear();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from gerentes");

            while (resultSet.next()) { // will traverse through all rows
                Integer dni = resultSet.getInt("dni");
                String nombre = resultSet.getString("nombre");
                Integer sueldo = resultSet.getInt("sueldo");
                Integer ruc = resultSet.getInt("ruc");
                Date fechaTemporal = resultSet.getDate("fecha_nacimiento");
                LocalDate fechaNacimiento = fechaTemporal.toLocalDate();

                Gerente gerente = new Gerente(dni, nombre, sueldo, ruc, fechaNacimiento);
                gerentes.add(gerente);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    private void actualizarClientes() {
        clientes.clear();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from clientes");

            while (resultSet.next()) { // will traverse through all rows
                Integer dni = resultSet.getInt("dni");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                Date fechaTemporal = resultSet.getDate("fecha_nacimiento");
                LocalDate fechaNacimiento = fechaTemporal.toLocalDate();

                Cliente cliente = new Cliente(nombre,dni, fechaNacimiento, direccion);
                clientes.add(cliente);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    private void actualizarProductos() {
        productos.clear();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from productos");
            List<String> categoriasList = null;
            while (resultSet.next()) { // will traverse through all rows
                int codigo = resultSet.getInt("codigo");
                int precio = resultSet.getInt("precio");
                String marca = resultSet.getString("marca");
                Array categoriasArray = resultSet.getArray("categorias");
                String[] catArray = (String[]) categoriasArray.getArray();
                categoriasList = Arrays.asList(catArray);
                ArrayList<String> categoriasArrayList = new ArrayList<>(categoriasList);

                String modelo = resultSet.getString("modelo");

                Producto producto = new Producto(categoriasArrayList, marca, modelo, precio, codigo);
                productos.add(producto);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    private void actualizarPedidos() {
        pedidos.clear();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from pedidos");
            List<String> categoriasList = null;
            while (resultSet.next()) { // will traverse through all rows
                int codigo = resultSet.getInt("codigo");
                int precio = resultSet.getInt("precio");
                String marca = resultSet.getString("marca");
                Array categoriasArray = resultSet.getArray("categorias");
                String[] catArray = (String[]) categoriasArray.getArray();
                categoriasList = Arrays.asList(catArray);
                ArrayList<String> categoriasArrayList = new ArrayList<>(categoriasList);

                String modelo = resultSet.getString("modelo");

                Producto producto = new Producto(categoriasArrayList, marca, modelo, precio, codigo);
                productos.add(producto);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }


    public Empleado buscarEmpleado(int dni) {
        actualizarEmpleados();
        for (Empleado empleado : empleados
        ) {
            if (empleado.getDni() == dni) {
                return empleado;
            }
        }
        return null;
    }
    public Gerente buscarGerente(int dni) {
        actualizarGerentes();
        for (Gerente gerente : gerentes
        ) {
            if (gerente.getDni() == dni) {
                return gerente;
            }
        }
        return null;
    }
    public Producto buscarProducto(int cod) {
        actualizarProductos();
        for (Producto producto : productos
        ) {
            if (producto.getCodigo() == cod) {
                return producto;
            }
        }
        return null;
    }
    public Cliente buscarCliente(int dni) {
        actualizarClientes();
        for (Cliente cliente : clientes)
        {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;
    }
    public Pedido buscarPedido(int cod) {
        actualizarPedidos();
        for (Pedido pedido : pedidos)
        {
            if (pedido.getCodigo() == cod) {
                return pedido;
            }
        }
        return null;
    }
    public boolean existeEmpleado(int dni) {
        actualizarEmpleados();
        for (Empleado empleado : empleados
        ) {
            if (empleado.getDni() == dni) {
                return true;
            }
        }
        return false;
    }
    public boolean existeGerente(int dni) {
        actualizarGerentes();
        for (Gerente gerente : gerentes
        ) {
            if (gerente.getDni() == dni) {
                return true;
            }
        }
        return false;
    }
    public boolean existeProducto(int cod) {
        actualizarProductos();
        for (Producto producto : productos
        ) {
            if (producto.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }
    public boolean existeCliente(int dni) {
        actualizarClientes();
        for (Cliente cliente : clientes)
        {
            if (cliente.getDni() == dni) {
                return true;
            }
        }
        return false;
    }
    public boolean existePedido(int cod) {
        actualizarPedidos();
        for (Pedido pedido : pedidos)
        {
            if (pedido.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }
    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        productosTemp.clear();
        actualizarProductos();
        if(categoria.equals("")){
            return productos;
        }
        for (Producto producto : productos)
        {
            ArrayList<String> cat = producto.getCategorias();
            for (String s : cat) {
                if (s.equals(categoria)) {
                    productosTemp.add(producto);
                }
            }
        }
        return productosTemp;
    }
    public void eliminarEmpleado(int dni) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            actualizarEmpleados();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);

            String dniTemp = JOptionPane.showInputDialog("Inserte el dni del empleado a eliminar");
            while (!validarDni(String.valueOf(dniTemp))) {
                dniTemp = JOptionPane.showInputDialog("Inserte el dni del empleado a eliminar");
            }
             dni = Integer.parseInt(dniTemp);
            Empleado emp = null;
            if (existeEmpleado(dni)){
                for (Empleado empleado : empleados)
                {
                    if(empleado.getDni() == dni){
                        emp = empleado;
                    }
                }
                JOptionPane.showConfirmDialog(null, "Seguro de eliminar al empleado: " + emp.toString());
            }
            else {
                JOptionPane.showMessageDialog(null, "No existe ningun empleado con ese dni");
            }
            statement = connection.prepareStatement("DELETE FROM empleados WHERE dni = ?");

            statement.setLong(1,dni);
            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void eliminarProducto(int cod) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);

            statement = connection.prepareStatement("DELETE FROM productos WHERE codigo = ?");

            statement.setLong(1, cod);

            try {
                statement.executeUpdate();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No existe el producto con el código: "+ cod);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void eliminarPedido(int cod) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);

            statement = connection.prepareStatement("DELETE FROM pedidos WHERE codigo = ?");

            statement.setLong(1, cod);

            try {
                statement.executeUpdate();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No existe el pedidoi con el código: "+ cod);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void agregarEmpleado(Long dni, String nombre, int sueldo, int ruc, Date fechaNacimiento) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement("INSERT INTO empleados(dni, nombre, sueldo, ruc, fecha_nacimiento) VALUES (?,?,?,?,?)");

            statement.setLong(1,dni);
            statement.setString(2,nombre);
            statement.setInt(3,sueldo);
            statement.setInt(4,ruc);
            statement.setDate(5, fechaNacimiento);

            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void agregarGerente(Long dni, String nombre, int sueldo, int ruc, Date fechaNacimiento) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement("INSERT INTO gerentes(dni, nombre, sueldo, ruc, fecha_nacimiento) VALUES (?,?,?,?,?)");

            statement.setLong(1,dni);
            statement.setString(2,nombre);
            statement.setInt(3,sueldo);
            statement.setInt(4,ruc);
            statement.setDate(5, fechaNacimiento);

            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void agregarProducto(int codigo, int precio, String marca, ArrayList<String> categorias, String modelo ) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String[] catArray = categorias.toArray(new String[categorias.size()]);
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement("INSERT INTO productos(codigo, precio, marca, categorias, modelo) VALUES (?,?,?,?,?)");
            statement.setInt(1,codigo);
            statement.setInt(2,precio);
            statement.setString(3,marca);
            Array categoriasArray = connection.createArrayOf("VARCHAR", catArray);
            statement.setArray(4, categoriasArray);
            statement.setString(5, modelo);

            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void agregarCliente(int dni, String nombre, Date fechaNacimiento, String direccion) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement("INSERT INTO clientes(dni, nombre, fecha_nacimiento, direccion ) VALUES (?,?,?,?)");

            statement.setInt(1,dni);
            statement.setString(2,nombre);
            statement.setDate(3, fechaNacimiento);
            statement.setString(4,direccion);


            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public void agregarPedido(int codigo, Array productosArray, int precio, Cliente cliente ) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> categorias = new ArrayList<String>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);
            statement = connection.prepareStatement("INSERT INTO productos(codigo, productos , precio, cliente) VALUES (?,?,?,?)");

            statement.setInt(1,codigo);
            statement.setArray(2, productosArray);
            statement.setInt(3,precio);
            statement.setString(4, cliente.toString());

            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(connection, statement, resultSet);
        }
    }
    public List<Producto> obtenerProductos(){
        actualizarProductos();
        return productos;
    }

}
