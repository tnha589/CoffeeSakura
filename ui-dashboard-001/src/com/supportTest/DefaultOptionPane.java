package com.supportTest;

import java.awt.Component;

import javax.swing.JOptionPane;

import com.supportTest.interfaceOp.OptionPane;

public class DefaultOptionPane implements OptionPane {
    @Override
    public void showMessageDialog(Component parentComponent, Object message, String title, int messageType) {
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
    }
}
