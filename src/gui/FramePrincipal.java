/*
 * Created by JFormDesigner on Mon Jun 12 13:00:37 PET 2023
 */

package gui;

import javax.swing.*;
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
        // Generated using JFormDesigner Evaluation license - André Forsyth

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        pack();
        setLocationRelativeTo(getOwner());
        createVerticalGlue();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - André Forsyth
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
