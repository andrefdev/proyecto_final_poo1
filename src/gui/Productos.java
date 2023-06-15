/*
 * Created by JFormDesigner on Mon Jun 12 09:34:51 PET 2023
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import logica.ButtonClickListener;
import logica.Producto;

import java.util.List;

/**
 * @author andre
 */
public class Productos extends JPanel {
    private DefaultTableModel productosTableModel;
    private ButtonClickListener buttonClickListener;
    private ButtonClickListener buttonClickListenerRegresar;
    private String text = "";
    public Productos(DefaultTableModel model) {
        this.productosTableModel = model;
        initComponents();
        table1.setModel(productosTableModel);
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

    private void button1MouseClicked(MouseEvent e) {
        this.text = textField1.getText();
        System.out.println(text);
    }
    public String getTextField(){
        return textField1.getText();
    }

    public void actualizarModelo(DefaultTableModel nuevoModelo) {
        productosTableModel = nuevoModelo;
        table1.setModel(productosTableModel);
    }

    public String getText() {
        return text;
    }

    private void textField1KeyTyped(KeyEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        vSpacer1 = new JPanel(null);
        button1 = new JButton();
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 18, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, new GridBagConstraints(0, 0, 2, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- textField1 ----
        textField1.setMinimumSize(new Dimension(49, 20));
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textField1KeyTyped(e);
            }
        });
        add(textField1, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer1, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- button1 ----
        button1.setText("Buscar");
        button1.setFont(new Font("Inter", Font.BOLD, 12));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        add(button1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonRegresar ----
        botonRegresar.setText("Regresar");
        add(botonRegresar, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
    public void setButtonClickListenerRegresar(ButtonClickListener listener) {
        this.buttonClickListenerRegresar = listener;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField textField1;
    private JPanel vSpacer1;
    private JButton button1;
    private JButton botonRegresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
