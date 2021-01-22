
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;

public class win extends Thread {
	int x, y;
	win(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
	public void run() {
		
		int resets = 0;
		
		try {
			Robot r = new Robot();
			//apre ALT TAB per far selezionare VBA-m
			r.keyPress(KeyEvent.VK_ALT);
			r.delay(50);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.delay(50);
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(50);
			r.keyRelease(KeyEvent.VK_ALT);
			r.delay(50);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.delay(50);
			r.keyRelease(KeyEvent.VK_TAB);
			r.delay(10000);
			
			while (isShiny(resets, x, y) == false) {
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
	
	
	public boolean isShiny (int resets, int x, int y) {
	    int shinyX = 0, shinyY = 0;
	    switch (y) {
		case 1080:
		    if (x == 1920) {
			shinyX = 1270;
			shinyY = 189;
		    }
		    break;
		case 720:
			if (x == 1280) {
				shinyX = 845;
				shinyY = 113;
			}
		default:
		    shinyX = (int) (x * 0.6953125);
		    shinyY = (int) (y * 0.1);
			break;
	    }
		
		String suicuneColor = "";
		try {
		    Robot r2 = new Robot();
		    suicuneColor = r2.getPixelColor(shinyX, shinyY).toString(); 
		}
		catch (AWTException e) {
		    e.printStackTrace();
		}
		System.out.println("SR: " + resets + " |\tcolor: " + suicuneColor);
		if ("java.awt.Color[r=128,g=152,b=192]".equals(suicuneColor) || "java.awt.Color[r=200,g=192,b=248]".equals(suicuneColor)) return true;
		else return false;
	}
}