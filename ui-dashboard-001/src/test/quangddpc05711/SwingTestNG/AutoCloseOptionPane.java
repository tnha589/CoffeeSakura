package test.quangddpc05711.SwingTestNG;

import java.awt.Window;

import javax.swing.JDialog;

public class AutoCloseOptionPane {
	public static void autoClose(int delayMillis) {
        Thread thread = new Thread(() -> {
            try {
                // Chờ một khoảng thời gian để JDialog hiện lên
                Thread.sleep(delayMillis);

                // Tìm và đóng JDialog
                Window[] windows = Window.getWindows();
                for (Window window : windows) {
                    if (window instanceof JDialog && window.isShowing()) {
                        JDialog dialog = (JDialog) window;
                        dialog.dispose();
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Bắt đầu tiểu trình
        thread.start();
    }
}
