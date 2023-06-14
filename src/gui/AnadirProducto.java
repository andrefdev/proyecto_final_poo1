/*
 * Created by JFormDesigner on Mon Jun 12 20:14:39 PET 2023
 */

package gui;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import logica.ButtonClickListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author andre
 */
public class AnadirProducto extends JPanel {
    private ButtonClickListener buttonClickListener;
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
        // Generated using JFormDesigner Evaluation license - André Forsyth
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
        button1 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;
        setLayout(new FormLayout(
            "default, $lcgap, [100dlu,default], $lcgap, default, $lcgap, [100dlu,default], $lcgap, default",
            "2*(default, $lgap), [14dlu,default], $lgap, [20dlu,default], $lgap, default, $lgap, [14dlu,default], $lgap, [20dlu,default], $lgap, default, $lgap, [14dlu,default], $lgap, [20dlu,default], $lgap, default, $lgap, [30dlu,default]"));

        //---- labelCategorias ----
        labelCategorias.setText("Categorias");
        add(labelCategorias, CC.xy(3, 5));

        //---- labelPrecio ----
        labelPrecio.setText("Precio");
        add(labelPrecio, CC.xy(7, 5));
        add(txtFieldCategorias, CC.xywh(3, 7, 1, 2));
        add(textFieldPrecio, CC.xywh(7, 7, 1, 2));

        //---- labelMarca ----
        labelMarca.setText("Marca");
        add(labelMarca, CC.xy(3, 11));

        //---- labelCodigo ----
        labelCodigo.setText("Codigo");
        add(labelCodigo, CC.xy(7, 11));
        add(txtFieldMarca, CC.xywh(3, 13, 1, 2));
        add(txtFieldCodigo, CC.xywh(7, 13, 1, 2));

        //---- label3 ----
        label3.setText("Modelo");
        add(label3, CC.xy(3, 17));
        add(txtFieldModelo, CC.xywh(3, 19, 1, 2));

        //---- button1 ----
        button1.setText("Agregar Producto");
        add(button1, CC.xy(3, 23));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - André Forsyth
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
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }

}
