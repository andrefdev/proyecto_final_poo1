/*
 * Created by JFormDesigner on Thu Jun 15 16:38:37 PET 2023
 */

package gui;

import com.toedter.calendar.*;
import logica.ButtonClickListener;
import logica.SpinnerEditor;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author andre
 */
public class CrearPedido extends JPanel {
    private ButtonClickListener buttonClickListenerRegresar;
    private ButtonClickListener buttonClickListenerConfirmarPedido;
    private DefaultTableModel productosTableModel;

    public CrearPedido(DefaultTableModel modelo) {
        initComponents();
        actualizarModelo(modelo);
        botonConfirmarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListenerConfirmarPedido != null) {
                    buttonClickListenerConfirmarPedido.onButtonClick();
                }
            }
        });
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListenerRegresar != null) {
                    buttonClickListenerRegresar.onButtonClick();
                }
            }
        });
    }

    private void textField1KeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        dniLabel = new JLabel();
        nombreLabel = new JLabel();
        dniTextField = new JTextField();
        nombreTextField = new JTextField();
        sueldoLabel = new JLabel();
        sueldoTextField = new JTextField();
        fechaNacimientoLabel = new JLabel();
        jcalendar = new JCalendar();
        botonConfirmarPedido = new JButton();
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- label1 ----
        label1.setText("Datos del cliente");
        add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- dniLabel ----
        dniLabel.setText("dni");
        add(dniLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- nombreLabel ----
        nombreLabel.setText("nombre");
        add(nombreLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- dniTextField ----
        dniTextField.setMinimumSize(new Dimension(49, 50));
        dniTextField.setPreferredSize(new Dimension(49, 50));
        add(dniTextField, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- nombreTextField ----
        nombreTextField.setMinimumSize(new Dimension(49, 50));
        nombreTextField.setPreferredSize(new Dimension(49, 50));
        add(nombreTextField, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- sueldoLabel ----
        sueldoLabel.setText("direcci\u00f3n");
        add(sueldoLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- sueldoTextField ----
        sueldoTextField.setPreferredSize(new Dimension(49, 50));
        sueldoTextField.setMinimumSize(new Dimension(49, 50));
        add(sueldoTextField, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- fechaNacimientoLabel ----
        fechaNacimientoLabel.setText("fecha de nacimiento");
        add(fechaNacimientoLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(jcalendar, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonConfrimarPedido ----
        botonConfirmarPedido.setText("Confirmar pedido");
        botonConfirmarPedido.setFont(new Font("Inter", Font.BOLD, 12));
        botonConfirmarPedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        add(botonConfirmarPedido, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonRegresar ----
        botonRegresar.setText("Regresar");
        add(botonRegresar, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel dniLabel;
    private JLabel nombreLabel;
    private JTextField dniTextField;
    private JTextField nombreTextField;
    private JLabel sueldoLabel;
    private JTextField sueldoTextField;
    private JLabel fechaNacimientoLabel;
    private JCalendar jcalendar;
    private JButton botonConfirmarPedido;
    private JButton botonRegresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void setButtonClickListenerRegresar(ButtonClickListener listener) {
        this.buttonClickListenerRegresar = listener;
    }
    public void setButtonClickListenerConfirmarPedido(ButtonClickListener listener) {
        this.buttonClickListenerConfirmarPedido = listener;
    }
    public void actualizarModelo(DefaultTableModel nuevoModelo) {
        productosTableModel = nuevoModelo;
        table1.setModel(productosTableModel);
        TableColumnModel tcm = table1.getColumnModel();
        TableColumn tc = tcm.getColumn(1);
        tc.setCellEditor(new SpinnerEditor());
    }
    public String getTxtDni(){
        return dniTextField.getText();
    }
    public String getTxtNombre(){
        return nombreTextField.getText();
    }
    public String getTxtDireccion(){
        return dniTextField.getText();
    }
    public Date getFechaNacimientoCliente() {
        java.sql.Date sqlDate = new java.sql.Date(jcalendar.getDate().getTime());
        return sqlDate;
    }
    public JTable getJTable() {
        return table1;
    }
}
