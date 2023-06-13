/*
 * Created by JFormDesigner on Mon Jun 12 20:14:39 PET 2023
 */

package gui;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author andre
 */
public class AnadirProducto extends JPanel {
    public AnadirProducto() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - André Forsyth
        label1 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label2 = new JLabel();
        label5 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label3 = new JLabel();
        textField5 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(new FormLayout(
            "default, $lcgap, [100dlu,default], $lcgap, default, $lcgap, [100dlu,default], $lcgap, default",
            "2*(default, $lgap), [14dlu,default], $lgap, [20dlu,default], $lgap, default, $lgap, [14dlu,default], $lgap, [20dlu,default], $lgap, default, $lgap, [14dlu,default], $lgap, [20dlu,default], $lgap, default, $lgap, [30dlu,default]"));

        //---- label1 ----
        label1.setText("Categorias");
        add(label1, CC.xy(3, 5));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label4 ----
        label4.setText("Precio");
        add(label4, CC.xy(7, 5));
        add(textField1, CC.xywh(3, 7, 1, 2));
        add(textField2, CC.xywh(7, 7, 3, 2));
        label4.setHorizontalAlignment(SwingConstants.CENTER );

        //---- label2 ----
        label2.setText("Marca");
        add(label2, CC.xy(3, 11));
        label2.setHorizontalAlignment(SwingConstants.CENTER );

        //---- label5 ----
        label5.setText("Codigo");
        add(label5, CC.xy(7, 11));
        add(textField3, CC.xywh(3, 13, 1, 2));
        add(textField4, CC.xywh(7, 13, 3, 2));
        label5.setHorizontalAlignment(SwingConstants.CENTER );

        //---- label3 ----
        label3.setText("Modelo");
        add(label3, CC.xy(3, 17));
        add(textField5, CC.xywh(3, 19, 1, 2));
        label3.setHorizontalAlignment(SwingConstants.CENTER );

        //---- button1 ----
        button1.setText("Agregar Producto");
        add(button1, CC.xy(3, 23));
        button1.setHorizontalAlignment(SwingConstants.CENTER );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - André Forsyth
    private JLabel label1;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label5;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label3;
    private JTextField textField5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
