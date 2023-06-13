/*
 * Created by JFormDesigner on Mon Jun 12 13:00:37 PET 2023
 */

package gui;

import javax.swing.*;
import com.jgoodies.forms.layout.*;

import java.awt.*;

/**
 * @author andre
 */
public class FramePrincipal extends JFrame {
    public FramePrincipal() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - André Forsyth

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "default, $lcgap, default",
            "2*(default, $lgap), default"));
        pack();
        setLocationRelativeTo(getOwner());
        setMinimumSize(new Dimension(400,400));
        setResizable(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - André Forsyth
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
