/*
 * Created by JFormDesigner on Mon Jun 12 09:34:51 PET 2023
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    }

    private void button1MouseClicked(MouseEvent e) {
        this.text = textField1.getText();
        System.out.println(text);
        //textField1.setText("");
    }
    public String getTextField(){
        return textField1.getText();
    }
    public void setModel(DefaultTableModel model) {
        this.productosTableModel = model;
    }
    public String getText() {
        return text;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - André Forsyth
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new FormLayout(
            "2*(default, $lcgap), default",
            "2*(default, $lgap), [20dlu,default], $lgap, [15dlu,default], $lgap, default"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, CC.xy(3, 3));
        add(textField1, CC.xy(3, 5));

        //---- button1 ----
        button1.setText("Buscar");
        button1.setFont(new Font("Inter", Font.BOLD, 18));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        add(button1, CC.xy(3, 7));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - André Forsyth
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
