/*
 * Created by JFormDesigner on Mon Jun 12 12:58:00 PET 2023
 */

package gui;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author andre
 */
public class Registro extends JPanel {
    public Registro() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
        label1 = new JLabel();

        //======== this ========
        setLayout(new FormLayout(
            "default, $lcgap, default",
            "2*(default, $lgap), default"));

        //---- label1 ----
        label1.setText("Registro");
        label1.setFont(new Font("Inter", Font.PLAIN, 20));
        add(label1, CC.xy(3, 3));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
