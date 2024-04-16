package test.DOME;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFrameTest {

    @Test
    public void testSimpleMethod() {
        SimpleFrame frame = new SimpleFrame();
        
        // Gọi phương thức simpleMethod() để hiển thị JOptionPane và lấy dữ liệu thông báo
        String result = frame.simpleMethod();
        
        // Kiểm tra xem dữ liệu thông báo có phải là thông báo dài hay không
        Assert.assertEquals(result, "Yes");
    }
}
