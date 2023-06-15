/*
 * Created by JFormDesigner on Wed Jun 14 15:50:24 PET 2023
 */

package gui;

import com.toedter.calendar.JCalendar;
import logica.ButtonClickListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;

/**
 * @author andre
 */
public class AgregarEmpleado extends JPanel {
    private int txtDni;
    private String txtNombre;
    private int txtSueldo;
    private int txtRuc;
    private java.sql.Date fechaNacimiento;
    private ButtonClickListener buttonClickListenerAnadirEmpleado;
    private ButtonClickListener buttonClickListenerRegresar;

    public AgregarEmpleado() {
        initComponents();
        botonAnadirEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListenerAnadirEmpleado != null) {
                    buttonClickListenerAnadirEmpleado.onButtonClick();
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
    public void resetTextFields(){
        dniTextField.setText("");
        nombreTextField.setText("");
        rucTextField.setText("");
        sueldoTextField.setText("");
        jcalendar.setDate(new java.util.Date());
    }

    public int getTxtDni() {
        this.txtDni = Integer.parseInt(dniTextField.getText());
        return txtDni;
    }

    public String getTxtNombre() {
        this.txtNombre = nombreTextField.getText();
        return txtNombre;
    }

    public int getTxtSueldo() {
        this.txtSueldo = Integer.parseInt(sueldoTextField.getText());
        return txtSueldo;
    }

    public int getTxtRuc() {
        this.txtRuc = Integer.parseInt(rucTextField.getText());
        return txtRuc;
    }

    public Date getFechaNacimiento() {
        java.sql.Date sqlDate = new java.sql.Date(jcalendar.getDate().getTime());
        this.fechaNacimiento = sqlDate;
        return sqlDate;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        dniLabel = new JLabel();
        nombreLabel = new JLabel();
        dniTextField = new JTextField();
        nombreTextField = new JTextField();
        sueldoLabel = new JLabel();
        rucLabel = new JLabel();
        sueldoTextField = new JTextField();
        rucTextField = new JTextField();
        fechaNacimientoLabel = new JLabel();
        jcalendar = new JCalendar();
        vSpacer1 = new JPanel(null);
        botonAnadirEmpleado = new JButton();
        botonRegresar = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

        //---- dniLabel ----
        dniLabel.setText("dni");
        add(dniLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- nombreLabel ----
        nombreLabel.setText("nombre");
        add(nombreLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- dniTextField ----
        dniTextField.setMinimumSize(new Dimension(49, 50));
        dniTextField.setPreferredSize(new Dimension(49, 50));
        add(dniTextField, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- nombreTextField ----
        nombreTextField.setMinimumSize(new Dimension(49, 50));
        nombreTextField.setPreferredSize(new Dimension(49, 50));
        add(nombreTextField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- sueldoLabel ----
        sueldoLabel.setText("sueldo");
        add(sueldoLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- rucLabel ----
        rucLabel.setText("ruc");
        add(rucLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- sueldoTextField ----
        sueldoTextField.setPreferredSize(new Dimension(49, 50));
        add(sueldoTextField, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- rucTextField ----
        rucTextField.setPreferredSize(new Dimension(49, 50));
        add(rucTextField, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- fechaNacimientoLabel ----
        fechaNacimientoLabel.setText("fecha de nacimiento");
        add(fechaNacimientoLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(jcalendar, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        add(vSpacer1, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonAnadirEmpleado ----
        botonAnadirEmpleado.setText("A\u00f1adir");
        add(botonAnadirEmpleado, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- botonRegresar ----
        botonRegresar.setText("Regresar");
        add(botonRegresar, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JLabel dniLabel;
    private JLabel nombreLabel;
    private JTextField dniTextField;
    private JTextField nombreTextField;
    private JLabel sueldoLabel;
    private JLabel rucLabel;
    private JTextField sueldoTextField;
    private JTextField rucTextField;
    private JLabel fechaNacimientoLabel;
    private JCalendar jcalendar;
    private JPanel vSpacer1;
    private JButton botonAnadirEmpleado;
    private JButton botonRegresar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void setButtonClickListenerAnadirEmpleado(ButtonClickListener listener) {
        this.buttonClickListenerAnadirEmpleado = listener;
    }
    public void setButtonClickListenerRegresar(ButtonClickListener listener) {
        this.buttonClickListenerRegresar = listener;
    }
}
