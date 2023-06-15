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

import static javax.swing.Box.*;

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
        this.txtFieldContrasena = passwordTextField.getText();
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
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        label1 = new JLabel();
        textField1 = new JTextField();
        vSpacer2 = new JPanel(null);
        label2 = new JLabel();
        passwordTextField = new JPasswordField();
        vSpacer1 = new JPanel(null);
        separator1 = new JSeparator();
        botonLogin = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(300, 300));
        setFont(new Font("Inter", Font.PLAIN, 18));
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(8, 5));

        //---- label1 ----
        label1.setText("Usuario");
        label1.setFont(new Font("Inter", Font.PLAIN, 18));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setPreferredSize(new Dimension(64, 23));
        label1.setHorizontalTextPosition(SwingConstants.LEADING);
        add(label1);
        add(textField1);

        //---- vSpacer2 ----
        vSpacer2.setPreferredSize(new Dimension(10, 100));
        add(vSpacer2);

        //---- label2 ----
        label2.setText("Contrase\u00f1a");
        label2.setFont(new Font("Inter", Font.PLAIN, 18));
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        add(label2);
        add(passwordTextField);

        //---- vSpacer1 ----
        vSpacer1.setMinimumSize(new Dimension(12, 100));
        vSpacer1.setRequestFocusEnabled(false);
        vSpacer1.setPreferredSize(new Dimension(10, 100));
        add(vSpacer1);
        add(separator1);

        //---- botonLogin ----
        botonLogin.setText("Ingresar");
        botonLogin.setFont(new Font("Inter", Font.PLAIN, 18));
        botonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonLoginMouseClicked(e);
            }
        });
        add(botonLogin);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JLabel label1;
    private JTextField textField1;
    private JPanel vSpacer2;
    private JLabel label2;
    private JTextField passwordTextField;
    private JPanel vSpacer1;
    private JSeparator separator1;
    private JButton botonLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
