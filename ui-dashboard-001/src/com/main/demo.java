/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import com.toedter.calendar.JDateChooser;

public class demo {
    public static void main(String[] args) {
        JDateChooser dateChooser = new JDateChooser();

        // Thêm sự kiện PropertyChangeListener
        dateChooser.addPropertyChangeListener("date", e -> {
            if ("date".equals(e.getPropertyName())) {
                // Xử lý khi ngày được chọn thay đổi
                java.util.Date selectedDate = (java.util.Date) e.getNewValue();
                System.out.println("Ngày đã thay đổi: " + selectedDate);
            }
        });
        
        // ... thêm dateChooser vào JFrame hoặc container khác ...

        // Ví dụ tạm thời: Hiển thị frame
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.add(dateChooser);
        frame.pack();
        frame.setVisible(true);
    }
}
