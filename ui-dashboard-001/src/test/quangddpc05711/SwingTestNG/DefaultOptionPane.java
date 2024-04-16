package test.quangddpc05711.SwingTestNG;

import java.awt.Component;

import javax.swing.JOptionPane;

public class DefaultOptionPane implements OptionPane {
    @Override
    public String showInputDialog(Component parentComponent, Object message) {
        return JOptionPane.showInputDialog(parentComponent, message);
    }
}
