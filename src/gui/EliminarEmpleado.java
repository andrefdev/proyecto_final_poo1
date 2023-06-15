/*
 * Created by JFormDesigner on Wed Jun 14 18:30:14 PET 2023
 */

package gui;

import logica.ButtonClickListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author andre
 */
public class EliminarEmpleado extends JPanel {
    private DefaultTableModel empleadosTableModel;
    private ButtonClickListener buttonClickListenerRegresar;
    private ButtonClickListener buttonClickListenerEliminar;
    private int txtFieldEmpleado;
    public EliminarEmpleado() {
        initComponents();
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListenerEliminar != null) {
                    buttonClickListenerEliminar.onButtonClick();
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
    public int getTxtFieldEmpleado(){
        this.txtFieldEmpleado = Integer.parseInt(dniTextField.getText());
        return txtFieldEmpleado;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        dniLabel = new JLabel();
        dniTextField = new JTextField();
        vSpacer1 = new JPanel(null);
        botonEliminar = new JButton();
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- dniLabel ----
        dniLabel.setText("Dni del empleado a elimnar");
        add(dniLabel, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(dniTextField, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer1, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonEliminar ----
        botonEliminar.setText("Eliminar");
        add(botonEliminar, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonRegresar ----
        botonRegresar.setText("Regresar");
        add(botonRegresar, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public void actualizarModelo(DefaultTableModel nuevoModelo) {
        empleadosTableModel = nuevoModelo;
        table1.setModel(empleadosTableModel);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel dniLabel;
    private JTextField dniTextField;
    private JPanel vSpacer1;
    private JButton botonEliminar;
    private JButton botonRegresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void setButtonClickListenerRegresar(ButtonClickListener listener) {
        this.buttonClickListenerRegresar = listener;
    }
    public void setButtonClickListenerEliminar(ButtonClickListener listener) {
        this.buttonClickListenerEliminar = listener;
    }
}
