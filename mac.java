
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;

public class mac extends Thread {
	public void run() {
		
		int resets = 0;
		
		try {
			Robot r = new Robot();
			//apre ALT TAB per far selezionare VBA-m
			r.keyPress(KeyEvent.VK_META);
			r.delay(20);
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(5000);
			r.keyRelease(KeyEvent.VK_META);
			r.delay(20);
			r.keyRelease(KeyEvent.VK_TAB);
			
			while (isShiny(resets) == false) {
				//softreset
				r.keyPress(KeyEvent.VK_C);
				r.delay(50);
				r.keyRelease(KeyEvent.VK_C);
				resets++;
				//skip parte iniziale
				for (int i = 0; i < 16; i++) {
					r.delay(200);
					r.keyPress(KeyEvent.VK_X);
					r.delay(50);
					r.keyRelease(KeyEvent.VK_X);
				}
				//premo SU - inizio la scena di suicune
				r.keyPress(KeyEvent.VK_W);
				r.delay(50);
				r.keyRelease(KeyEvent.VK_W);
				r.delay(7300);
			}
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "SHINY FOUND after " + resets + " resets!");
	}
	
	public boolean isShiny (int resets) {
		String suicuneColor = "";
		try {
			Robot r2 = new Robot();
			suicuneColor = r2.getPixelColor(890, 80).toString();
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
		System.out.println("SR: " + resets + " |\tcolore: " + suicuneColor);
		if ("java.awt.Color[r=128,g=152,b=192]".equals(suicuneColor)) return true;
		else return false;
	}
}
