
/**
 *
 * @author leapbtw
 */

import java.awt.*;
import java.util.*;
import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) {
		String OS = System.getProperty("os.name");
		switch (OS) {
			case "Mac OS X":
				JOptionPane.showMessageDialog(null, "macOS machine detected");
				break;
			case "Windows 10":
				JOptionPane.showMessageDialog(null, "Windows 10 machine detected");
				break;
		}
		(new mac()).start();
	}
	
}
