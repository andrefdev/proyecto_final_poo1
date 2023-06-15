/*
 * Created by JFormDesigner on Mon Jun 12 20:14:39 PET 2023
 */

package gui;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import logica.ButtonClickListener;
import com.toedter.calendar.JCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author andre
 */
public class AnadirProducto extends JPanel {
    private ButtonClickListener buttonClickListener;
    private ButtonClickListener buttonClickListenerRegresar;
    private String txtCategorias;
    private String txtPrecio;
    private String txtMarca;
    private String txtCodigo;
    private String txtModelo;

    public AnadirProducto() {
        initComponents();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClick();
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
    public String getTxtCategorias() {
        this.txtCategorias = txtFieldCategorias.getText();
        return txtCategorias;
    }

    public String getTxtPrecio() {
        this.txtPrecio = textFieldPrecio.getText();
        return txtPrecio;
    }

    public String getTxtMarca() {
        this.txtMarca = txtFieldMarca.getText();
        return txtMarca;
    }

    public String getTxtCodigo() {
        this.txtCodigo = txtFieldCodigo.getText();
        return txtCodigo;
    }

    public String getTxtModelo() {
        this.txtModelo = txtFieldModelo.getText();
        return txtModelo;
    }
    public void resetTextFields(){
        textFieldPrecio.setText("");
        txtFieldCategorias.setText("");
        txtFieldCodigo.setText("");
        txtFieldMarca.setText("");
        txtFieldModelo.setText("");
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        labelCategorias = new JLabel();
        labelPrecio = new JLabel();
        txtFieldCategorias = new JTextField();
        textFieldPrecio = new JTextField();
        labelMarca = new JLabel();
        labelCodigo = new JLabel();
        txtFieldMarca = new JTextField();
        txtFieldCodigo = new JTextField();
        label3 = new JLabel();
        txtFieldModelo = new JTextField();
        vSpacer1 = new JPanel(null);
        vSpacer2 = new JPanel(null);
        button1 = new JButton();
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {6, 211, 6, 0, 6, 211, 6, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {5, 25, 35, 25, 35, 25, 35, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

        //---- labelCategorias ----
        labelCategorias.setText("Categorias");
        add(labelCategorias, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- labelPrecio ----
        labelPrecio.setText("Precio");
        add(labelPrecio, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- txtFieldCategorias ----
        txtFieldCategorias.setMinimumSize(new Dimension(49, 50));
        txtFieldCategorias.setPreferredSize(new Dimension(49, 50));
        add(txtFieldCategorias, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- textFieldPrecio ----
        textFieldPrecio.setPreferredSize(new Dimension(49, 50));
        add(textFieldPrecio, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- labelMarca ----
        labelMarca.setText("Marca");
        add(labelMarca, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- labelCodigo ----
        labelCodigo.setText("Codigo");
        add(labelCodigo, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- txtFieldMarca ----
        txtFieldMarca.setPreferredSize(new Dimension(36, 50));
        txtFieldMarca.setMinimumSize(new Dimension(49, 50));
        add(txtFieldMarca, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- txtFieldCodigo ----
        txtFieldCodigo.setPreferredSize(new Dimension(49, 50));
        add(txtFieldCodigo, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- label3 ----
        label3.setText("Modelo");
        add(label3, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- txtFieldModelo ----
        txtFieldModelo.setPreferredSize(new Dimension(49, 50));
        add(txtFieldModelo, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer1, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer2, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- button1 ----
        button1.setText("Agregar Producto");
        button1.setPreferredSize(new Dimension(144, 70));
        add(button1, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonRegresar ----
        botonRegresar.setText("Regresar");
        botonRegresar.setPreferredSize(new Dimension(96, 70));
        add(botonRegresar, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JLabel labelCategorias;
    private JLabel labelPrecio;
    private JTextField txtFieldCategorias;
    private JTextField textFieldPrecio;
    private JLabel labelMarca;
    private JLabel labelCodigo;
    private JTextField txtFieldMarca;
    private JTextField txtFieldCodigo;
    private JLabel label3;
    private JTextField txtFieldModelo;
    private JPanel vSpacer1;
    private JPanel vSpacer2;
    private JButton button1;
    private JButton botonRegresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
    public void setButtonClickListenerRegresar(ButtonClickListener listener) {
        this.buttonClickListenerRegresar = listener;
    }

}
