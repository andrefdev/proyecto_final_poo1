/*
 * Created by JFormDesigner on Wed Jun 14 21:10:23 PET 2023
 */

package gui;

import logica.ButtonClickListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author andre
 */
public class MenuEmpleado extends JPanel {
    private ButtonClickListener buttonClickListenerVerProductos;
    private ButtonClickListener buttonClickListenerRegresar;
    public MenuEmpleado() {
        initComponents();
        botonVerProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListenerVerProductos != null) {
                    buttonClickListenerVerProductos.onButtonClick();
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
        botonVerProductos = new JButton();
        vSpacer1 = new JPanel(null);
        button2 = new JButton();
        vSpacer2 = new JPanel(null);
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};

        //---- botonVerProductos ----
        botonVerProductos.setText("Ver productos");
        botonVerProductos.setPreferredSize(new Dimension(70, 80));
        add(botonVerProductos, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer1, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- button2 ----
        button2.setText("Crear pedido");
        button2.setPreferredSize(new Dimension(70, 80));
        add(button2, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer2, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonRegresar ----
        botonRegresar.setText("Regresar");
        add(botonRegresar, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JButton botonVerProductos;
    private JPanel vSpacer1;
    private JButton button2;
    private JPanel vSpacer2;
    private JButton botonRegresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void setButtonClickListenerVerProductos(ButtonClickListener listener) {
        this.buttonClickListenerVerProductos = listener;
    }
    public void setButtonClickListenerRegresar(ButtonClickListener listener) {
        this.buttonClickListenerRegresar = listener;
    }
}
