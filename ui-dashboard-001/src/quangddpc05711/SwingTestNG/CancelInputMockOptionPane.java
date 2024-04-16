package quangddpc05711.SwingTestNG;

import java.awt.Component;

public class CancelInputMockOptionPane extends DefaultOptionPane {

	@Override
    public String showInputDialog(Component parentComponent, Object message) {
        return null; // Trả về giá trị là null để mô phỏng việc nhấn Cancel
    }
}
