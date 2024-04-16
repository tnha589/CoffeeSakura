package com.untils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPane extends JDialog {

    public static JDialog dialog = new JDialog((Frame) null, "Message", false);

    public static void showMessageDialog(Component parentComponent, String message) {
        // Lấy biểu tượng question icon từ UIManager
        Icon questionIcon = UIManager.getIcon("OptionPane.informationIcon");

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());

        // Tạo một panel chứa biểu tượng và khoảng cách
        JPanel iconPanel = new JPanel(new BorderLayout());
        iconPanel.add(new JLabel(questionIcon), BorderLayout.CENTER);
        iconPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Khoảng cách giữa biểu tượng và nội dung

        messagePanel.add(iconPanel, BorderLayout.WEST);

        // Tạo một label chứa văn bản thông báo với khoảng cách
        JLabel messageLabel = new JLabel("<html><div style='padding-left: 10px; padding-right: 10px;'>" + message + "</div></html>");
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messagePanel.add(messageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("OK");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Khoảng cách giữa nút "OK" và nội dung

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(messagePanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.getContentPane().add(contentPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(parentComponent);
        dialog.setVisible(true);
    }

    public static void closeDialog() {
        if (dialog != null) {
            dialog.dispose();
        }
    }
}
