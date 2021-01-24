
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
		int x = 0, y = 0;
		String[] screenSize = {"1920x1080", "1280x800", "custom [MAY NOT WORK WELL]"};
		String input = (String) JOptionPane.showInputDialog(null, "please set a display size", "display size", JOptionPane.QUESTION_MESSAGE, null, screenSize, screenSize[0]);
		switch (input) {
			case "1920x1080":
				x = 1920;
				y = 1080;
				break;
			case "1280x800":
				x = 1280;
				y = 800;
				break;
			case "1280x720":
				x = 1280;
				y = 720;
				break;
			default:
				//custom screen resolution is supported, but the pixel checked is calculated with proportions, so even if it SHOULD work, it might not
				//i suggest setting your display resolution to 1080p or to 720p instead of trying this, since i did tested those but i can't test your custom resolution
				int customX = 0,customY = 0;
				while (customX < 100) {
				String input2 = JOptionPane.showInputDialog("input screen width");
					try {
						customX = Integer.parseInt(input2);
					}
					catch (NumberFormatException e)	{
						JOptionPane.showMessageDialog(null, "input an integer please");
						customX = 0;
						break;
					}
				}
				while (customY < 100) {
				String input2 = JOptionPane.showInputDialog("input screen height");
					try {
						customY = Integer.parseInt(input2);
					}
					catch (NumberFormatException e)	{
						JOptionPane.showMessageDialog(null, "input an integer please");
						customY = 0;
						break;
					}
				}
				(new mac(customX, customY)).start();
				break; //input screenSize
		}
		
		switch (OS) {
			case "Mac OS X":
				JOptionPane.showMessageDialog(null, "macOS machine detected");
				(new mac(x, y)).start();
				break;	
			case "Windows 10":
				(new win(x, y)).start();
				break;
				
		}
	}
}