/*
 * Created by JFormDesigner on Mon Jun 12 13:00:37 PET 2023
 */

package gui;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import java.awt.*;

import static javax.swing.Box.createVerticalGlue;

/**
 * @author andre
 */
public class FramePrincipal extends JFrame {
    public FramePrincipal() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage());
        setMinimumSize(new Dimension(500, 500));
        setPreferredSize(new Dimension(500, 500));
        var contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "2*(default), 13*($lcgap, default)",
            "default, $lgap, default:grow, $lgap, default"));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Ricardo Reaño (André Forsyth)
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
