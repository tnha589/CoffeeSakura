/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomRowRendererDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Row Renderer Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Danh sách trạng thái
        List<String> statuses = new ArrayList<>();
        statuses.add("Hóa đơn chờ xác nhận");
        statuses.add("Hóa đơn chờ hủy");

        // Mô hình dữ liệu cho JTable
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                        {"1", "Mua sách"},
                        {"2", "Mua bút"}
                },
                new String[]{"ID", "Description"}
        );

        // Khởi tạo JTable với mô hình dữ liệu
        JTable table = new JTable(model);

        // Áp dụng TableCellRenderer cho toàn bộ dòng
        table.setDefaultRenderer(Object.class, new CustomRowRenderer(statuses));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

class CustomRowRenderer implements TableCellRenderer {

    public final List<String> statuses;
    public final DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();

    public CustomRowRenderer(List<String> statuses) {
        this.statuses = statuses;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Đặt màu cho chữ dựa trên trạng thái
        String status = statuses.get(row);
        if ("Hóa đơn chờ xác nhận".equals(status)) {
            c.setForeground(Color.BLUE);
        } else if ("Hóa đơn chờ hủy".equals(status)) {
            c.setForeground(Color.RED);
        } else {
            c.setForeground(Color.BLACK); // Màu mặc định
        }

        return c;
    }
}

