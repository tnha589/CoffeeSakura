/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.untils;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
/**
 *
 * @author duyplus
 */
public class XExcel1 {

     public static void writeToExcel(List<Object[]> dataList, String title) {
        XSSFWorkbook wb = null;
        FileOutputStream fos = null;
        try {
            wb = new XSSFWorkbook();
            title = title.replaceAll("/", "-");
            XSSFSheet sheet = wb.createSheet(title);

            JFileChooser fc = new JFileChooser("D:\\");
            fc.setDialogTitle("Save as...");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
            fc.setFileFilter(fnef);
            int chooser = fc.showSaveDialog(null);
            if (chooser == JFileChooser.APPROVE_OPTION) {
                // Tiêu đề cột riêng lẻ không phụ thuộc vào dữ liệu
                String[] headerTitles = {"Thứ", "Ca", "Nhân Viên", "Trạng thái", "Ghi chú"};

                // Tạo dòng tiêu đề
                XSSFRow rowtitle = sheet.createRow(0);
                for (int i = 0; i < headerTitles.length; i++) {
                    // Set font header
                    XSSFFont font = wb.createFont();
                    font.setFontHeightInPoints((short) 12);
                    font.setColor(IndexedColors.RED.getIndex());
                    font.setBold(true);
                    // Set style header
                    XSSFCellStyle cs = wb.createCellStyle();
                    cs.setAlignment(HorizontalAlignment.CENTER);
                    cs.setVerticalAlignment(VerticalAlignment.CENTER);
                    cs.setFont(font);
                    // Create header cell
                    XSSFCell cell = rowtitle.createCell((short) i);
                    cell.setCellValue(headerTitles[i]);
                    cell.setCellStyle(cs);
                }

                // Tạo dòng dữ liệu
                for (int i = 1; i <= dataList.size(); i++) {
                    XSSFRow row = sheet.createRow(i);
                    Object[] rowData = dataList.get(i - 1);
                    for (int j = 0; j < rowData.length; j++) {
                        // Create body cell
                        XSSFCell cell = row.createCell((short) j);
                        cell.setCellValue(Objects.toString(rowData[j], ""));
                    }
                }

                fos = new FileOutputStream(fc.getSelectedFile() + ".xlsx");
                wb.write(fos);
                XDialog.alert(null, "Xuất dữ liệu thành công!");
                fos.close();
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
