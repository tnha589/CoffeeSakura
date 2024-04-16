package test.DOME;

import javax.swing.JOptionPane;

public class SimpleFrame {
	 public String simpleMethod() {
	        String message = "This is a long message that spans multiple lines in the JOptionPane.";
	        int showConfirmDialog = JOptionPane.showConfirmDialog(null, message, "Question", JOptionPane.YES_NO_OPTION);
	        return (showConfirmDialog == JOptionPane.YES_OPTION) ? "Yes" : "No";
	    }
}
