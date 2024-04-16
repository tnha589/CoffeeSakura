package com.untils;

import java.awt.Component;

public class getJOptionePane {
	public static JOptionPane optionPane;

	public static void setOptionPane(JOptionPane optionPane) {
		optionPane = optionPane;
	}

	public static void methodThatUsesOptionPane(Component component, String message) {
		optionPane.showMessageDialog(component, message);
	}
}