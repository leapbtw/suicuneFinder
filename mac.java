
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
		case 800:
		    if (x == 1280) {
			shinyX = 890;
			shinyY = 80;
		    }
			break;
		case 1080:
		    if (x == 1920) {
			shinyX = 1280;
			shinyY = 178;
		    }
		    break;
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
				shinyX = 1220;
				shinyY = 366;
		    }
		    break;
		case 800:
			if (x == 1280) {
				shinyX = 837;
				shinyY = 250;
			}
			break;
		default:
		    shinyX = (int) (x * 0.6953125);
		    shinyY = (int) (y * 0.1);
			break;
	    }
		try {
		    Robot r2 = new Robot();
		    celebiColor = r2.getPixelColor(shinyX, shinyY).toString(); 
		}
		catch (AWTException e) {}
		System.out.println("SR: " + resets + " |\t coord:" + shinyX + "," + shinyY + "\tcolor: " + celebiColor);
		if ("java.awt.Color[r=248,g=120,b=120]".equals(celebiColor)) return true;
		else return false;
	}
}