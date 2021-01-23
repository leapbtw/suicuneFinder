
/**
 *
 * @author leapbtw
 */

import java.awt.*;
import java.util.*;
import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) throws InterruptedException {
		String OS = System.getProperty("os.name");
		switch (OS) {
			case "Mac OS X":
				JOptionPane.showMessageDialog(null, "macOS machine detected");
				String[] choicesMac = {"1920x1080", "1280x800", "custom [MAY NOT WORK WELL]"};
				String inputMac = (String) JOptionPane.showInputDialog(null, "please set a display size", "display size", JOptionPane.QUESTION_MESSAGE, null, choicesMac, choicesMac[0]);
				switch (inputMac) {
					case "1920x1080":
						(new mac(1920, 1080)).start();
						break;
					case "1280x800":
						(new mac(1280, 800)).start();
						break;
					default:
						//custom screen resolution is supported, but the pixel checked is calculated with proportions, so even if it SHOULD work, it might not
						//i suggest setting your display resolution to 1080p or to 720p instead of trying this, since i did tested those but i can't test your custom resolution
						int customMacX = 0,customMacY = 0;
						while (customMacX < 100) {
						String input2 = JOptionPane.showInputDialog("input screen width");
							try {
								customMacX = Integer.parseInt(input2);
							}
							catch (NumberFormatException e)	{
								JOptionPane.showMessageDialog(null, "input an integer please");
								customMacX = 0;
								break;
							}
						}
						while (customMacY < 100) {
						String input2 = JOptionPane.showInputDialog("input screen height");
							try {
								customMacY = Integer.parseInt(input2);
							}
							catch (NumberFormatException e)	{
								JOptionPane.showMessageDialog(null, "input an integer please");
								customMacY = 0;
								break;
							}
						}
						(new mac(customMacX, customMacY)).start();
						break; //inputMac
				}
				break;
				
				
			case "Windows 10":
				JOptionPane.showMessageDialog(null, "Windows 10 machine detected");
				String[] choices = {"1920x1080", "1280x720", "custom [MAY NOT WORK WELL]"};
				String input = (String) JOptionPane.showInputDialog(null, "please set a display size", "display size", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
				switch (input) {
					case "1920x1080":
						(new win(1920, 1080)).start();
						break;
					case "1280x720":
						(new win(1280, 720)).start();
						break;
					default:
						//custom screen resolution is supported, but the pixel checked is calculated with proportions, so even if it SHOULD work, it might not
						//i suggest setting your display resolution to 1080p or to 720p instead of trying this, since i did tested those but i can't test your custom resolution
						int customWinX = 0,customWinY = 0;
						while (customWinX < 100) {
						String input2 = JOptionPane.showInputDialog("input screen width");
							try {
								customWinX = Integer.parseInt(input2);
							}
							catch (NumberFormatException e)	{
								JOptionPane.showMessageDialog(null, "input an integer please");
								customWinX = 0;
								break;
							}
						}
						while (customWinY < 100) {
						String input2 = JOptionPane.showInputDialog("input screen height");
							try {
								customWinY = Integer.parseInt(input2);
							}
							catch (NumberFormatException e)	{
								JOptionPane.showMessageDialog(null, "input an integer please");
								customWinY = 0;
								break;
							}
						}
				}
				break; //break switch OS
		}
	}
}