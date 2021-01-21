/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macintoshhd
 */

import java.awt.*;
import java.util.*;
import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) {
		String OS = System.getProperty("os.name");
		switch (OS) {
			case "Mac OS X":
				JOptionPane.showMessageDialog(null, "sei su un mac");
				break;
			case "Windows 10":
				JOptionPane.showMessageDialog(null, "sei su windows");
				break;
		}
		//(new turbo()).start();
		(new mac()).start();
	}
	
}
