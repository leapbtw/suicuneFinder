
/**
 *
 * @author leapbtw
 */

// here i basically hard-code the key presses to soft reset, start the encounter and check the color of every single pokemon
// im can't really find any way to reduce the code here so i think i'll just keep doing this

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class mac extends Thread {
	int x, y;
	int resets = 0;
	String choosedPokemon;
	mac(int x, int y, String choosedPokemon) {
	    this.x = x;
	    this.y = y;
		this.choosedPokemon = choosedPokemon;
	}
	public void run() {
		try {
			Robot r = new Robot();
			//apre ALT TAB per far selezionare VBA-m
			r.keyPress(KeyEvent.VK_META);
			r.delay(50);
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(50);
			r.keyRelease(KeyEvent.VK_TAB);
			r.delay(10000);
			r.keyRelease(KeyEvent.VK_META);
		} catch (AWTException ex) {}
		switch (choosedPokemon) {
			case "suicune":
				suicune();
				break;
			case "celebi":
				celebi();
				break;
			case "starter":
				starter();
				break;
		}
	}
	
	public void suicune() {
		try {
			Robot r = new Robot();
			while (isSuicuneShiny(resets, x, y) == false) {
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
		catch (AWTException e) {}
		JOptionPane.showMessageDialog(null, "SHINY FOUND after " + resets + " resets!");
	}
	
	public boolean isSuicuneShiny (int resets, int x, int y) {
	    int shinyX = 0, shinyY = 0;
	    switch (y) {
		case 1080:
		    if (x == 1920) {
			shinyX = 1280;
			shinyY = 178;
		    }
		    break;
		case 800:
		    if (x == 1280) {
			shinyX = 890;
			shinyY = 80;
		    }
			break;
		default:
		    shinyX = (int) (x * 0.666666);
		    shinyY = (int) (y * 0.1648148);
			break;
	    }
		
		String suicuneColor = "";
		try {
		    Robot r2 = new Robot();
		    suicuneColor = r2.getPixelColor(shinyX, shinyY).toString(); 
		}
		catch (AWTException e) {}
		System.out.println("SR: " + resets + " |\t coord:" + shinyX + "," + shinyY + "\tcolor: " + suicuneColor);
		if ("java.awt.Color[r=128,g=152,b=192]".equals(suicuneColor) || "java.awt.Color[r=200,g=192,b=248]".equals(suicuneColor) || "java.awt.Color[r=133,g=164,b=201]".equals(suicuneColor)) return true;
		else return false;
	}
	
	public void celebi() {
		try {
			Robot r = new Robot();
			while (isCelebiShiny(resets, x, y) == false) {
				//softreset
				r.keyPress(KeyEvent.VK_C);
				r.delay(50);
				r.keyRelease(KeyEvent.VK_C);
				resets++;
				//skip parte iniziale
				for (int i = 0; i < 30; i++) {
					r.delay(200);
					r.keyPress(KeyEvent.VK_X);
					r.delay(50);
					r.keyRelease(KeyEvent.VK_X);
				}
				r.delay(7300);
			}
		}
		catch (AWTException e) {
		}
		JOptionPane.showMessageDialog(null, "SHINY FOUND after " + resets + " resets!");
	}
	
	public boolean isCelebiShiny (int resets, int x, int y) {
	    int shinyX = 0, shinyY = 0;
		String celebiColor = "";
	    switch (y) {
		case 1080:
		    if (x == 1920) {
				shinyX = 1240;
				shinyY = 350;
		    }
		    break;
		case 800:
			if (x == 1280) {
				shinyX = 837;
				shinyY = 250;
			}
			break;
		default:
		    shinyX = (int) (x * 0.64583333);
		    shinyY = (int) (y * 0.32407407);
			break;
	    }
		try {
		    Robot r2 = new Robot();
		    celebiColor = r2.getPixelColor(shinyX, shinyY).toString(); 
		}
		catch (AWTException e) {}
		System.out.println("SR: " + resets + " |\t coord:" + shinyX + "," + shinyY + "\tcolor: " + celebiColor);
		if ("java.awt.Color[r=255,g=122,b=129]".equals(celebiColor) || "java.awt.Color[r=248,g=120,b=120]".equals(celebiColor)) return true;
		else return false;
	}
	
	public void starter() {
		try {
			Robot r = new Robot();
			while (isStarterShiny(resets, x, y) == false) {
				//softreset
				r.keyPress(KeyEvent.VK_C);
				r.delay(50);
				r.keyRelease(KeyEvent.VK_C);
				resets++;
				//skip parte iniziale
				for (int i = 0; i < 41; i++) {
					r.delay(150);
					r.keyPress(KeyEvent.VK_X);
					r.delay(50);
					r.keyRelease(KeyEvent.VK_X);
				}
				for (int i = 0; i < 55; i++) {
					r.delay(150);
					r.keyPress(KeyEvent.VK_Z);
					r.delay(50);
					r.keyRelease(KeyEvent.VK_Z);
				}
				r.keyPress(KeyEvent.VK_B);
				r.delay(150);
				r.keyRelease(KeyEvent.VK_B);
				r.delay(400);
				for (int i = 0; i < 3; i++) {
					r.delay(550);
					r.keyPress(KeyEvent.VK_X);
					r.delay(50);
					r.keyRelease(KeyEvent.VK_X);
				}
				r.delay(5000);
			}
			
		}
		catch (AWTException e) {}
		JOptionPane.showMessageDialog(null, "SHINY FOUND after " + resets + " resets!");
	}
	
	public boolean isStarterShiny (int resets, int x, int y) {
	    int shinyX = 0, shinyY = 0;
		String starterColor = "";
	    switch (y) {
		case 1080:
		    if (x == 1920) {
				shinyX = 1526;
				shinyY = 49;
		    }
		    break;
		case 800:
			if (x == 1280) {
				shinyX = 1045;
				shinyY = 34;
			}
			break;
		default:
		    shinyX = (int) (x * 0.79479166);
		    shinyY = (int) (y * 0.045370);
			break;
	    }
		try {
		    Robot r2 = new Robot();
		    starterColor = r2.getPixelColor(shinyX, shinyY).toString(); 
		}
		catch (AWTException e) {}
		System.out.println("SR: " + resets + " |\t coord:" + shinyX + "," + shinyY + "\tcolor: " + starterColor);
		if ("java.awt.Color[r=0,g=0,b=0]".equals(starterColor) || "java.awt.Color[r=1,g=1,b=1]".equals(starterColor)) return true;
		else return false;
	}
}