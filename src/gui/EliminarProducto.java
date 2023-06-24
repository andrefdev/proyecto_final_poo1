/*
 * Created by JFormDesigner on Wed Jun 21 11:42:34 PET 2023
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
public class EliminarProducto extends JPanel {
    private ButtonClickListener buttonClickListenerRegresar;
    private ButtonClickListener buttonClickListenerEliminar;

    public EliminarProducto() {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        this2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        dniLabel = new JLabel();
        codigoTextField = new JTextField();
        vSpacer1 = new JPanel(null);
        botonEliminar = new JButton();
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridLayout());

        //======== this2 ========
        {
            this2.setLayout(new GridBagLayout());
            ((GridBagLayout)this2.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)this2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)this2.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
            ((GridBagLayout)this2.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            this2.add(scrollPane1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- dniLabel ----
            dniLabel.setText("Codigo del producto a eliminar");
            this2.add(dniLabel, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            this2.add(codigoTextField, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            this2.add(vSpacer1, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- botonEliminar ----
            botonEliminar.setText("Eliminar");
            this2.add(botonEliminar, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- botonRegresar ----
            botonRegresar.setText("Regresar");
            this2.add(botonRegresar, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(this2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JPanel this2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel dniLabel;
    private JTextField codigoTextField;
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

    public int getCodigo() {
        int codigo = 0;
        try {
            codigo = Integer.parseInt(codigoTextField.getText());
        }catch (NumberFormatException e) {}
        return codigo;
    }
    public void actualizarModelo(DefaultTableModel modelo){
        table1.setModel(modelo);
    }
}
