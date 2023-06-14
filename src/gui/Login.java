/*
 * Created by JFormDesigner on Mon Jun 12 11:18:14 PET 2023
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import logica.ButtonClickListener;

/**
 * @author andre
 */
public class Login extends JPanel {
    private boolean logueado;
    private String txtFieldUsuario;
    private String txtFieldContrasena;

    private ButtonClickListener buttonClickListener;

    public Login() {
        this.logueado = false;
        initComponents();
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClick();
                }
            }
        });
    }
    public String getTxtFieldUsuario(){
        this.txtFieldUsuario = textField1.getText();
        return txtFieldUsuario;
    }
    public String getPasswordField(){
        this.txtFieldContrasena = Arrays.toString(passwordField1.getPassword());
        return txtFieldContrasena;
    }
    private void botonLoginMouseClicked(MouseEvent e) {
        setLogueado(true);
    }
    public boolean isButtonClicked() {
        return logueado;
    }
    public void setLogueado(boolean bool){
        this.logueado = bool;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - André Forsyth
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        botonLogin = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(300, 300));
        setFont(new Font("Inter", Font.PLAIN, 18));
        setPreferredSize(null);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
        .border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder
        .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.
        awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
        ; addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}})
        ;
        setLayout(new FormLayout(
            "2*(default, $lcgap), [200dlu,default], 2*($lcgap, default)",
            "2*(default, $lgap), [15dlu,default], $lgap, [30dlu,default], 2*($lgap, default), $lgap, [15dlu,default], $lgap, [30dlu,default], $lgap, default, $lgap, [30dlu,default], 5*($lgap, default)"));

        //---- label1 ----
        label1.setText("Usuario");
        label1.setFont(new Font("Inter", Font.PLAIN, 18));
        add(label1, CC.xy(5, 5));
        add(textField1, CC.xywh(5, 7, 1, 2));

        //---- label2 ----
        label2.setText("Contrase\u00f1a");
        label2.setFont(new Font("Inter", Font.PLAIN, 18));
        add(label2, CC.xy(5, 13));
        add(passwordField1, CC.xywh(5, 15, 1, 2));

        //---- botonLogin ----
        botonLogin.setText("Ingresar");
        botonLogin.setFont(new Font("Inter", Font.PLAIN, 18));
        botonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonLoginMouseClicked(e);
            }
        });
        add(botonLogin, CC.xywh(5, 19, 1, 2));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - André Forsyth
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton botonLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
