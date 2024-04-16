package test.quangddpc05711.SwingTestNG;

import java.awt.Component;

public class InputMockOptionPane extends DefaultOptionPane{
	 private String autoInput;

	    // Constructor để thiết lập giá trị tự động nhập vào
	    public InputMockOptionPane(String autoInput) {
	        this.autoInput = autoInput;
	    }

	    @Override
	    public String showInputDialog(Component parentComponent, Object message) {
	        if (autoInput != null && !autoInput.isEmpty()) {
	            return autoInput; // Trả về giá trị tự động nhập vào nếu có
	        } else {
	            return ""; // Trả về giá trị mặc định là chuỗi rỗng
	        }
	    }
}
