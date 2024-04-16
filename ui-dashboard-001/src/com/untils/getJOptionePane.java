package com.untils;

import java.awt.Component;

public class getJOptionePane {
	public static JOptionPane optionPane ;

	public static void setOptionPane(JOptionPane opt) {
		optionPane = opt;
	}

	public static void methodThatUsesOptionPane(Component component, String message) {
		if(optionPane == null) {
			
			optionPane = new JOptionPane();
		}
	
		optionPane.showMessageDialog(component, message);
	}

}
