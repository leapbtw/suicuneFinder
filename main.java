
/**
 *
 * @author leapbtw
 */

import java.awt.*;
import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) throws InterruptedException {
		//(new mouse()).start();
		//sets the screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int y = screenSize.height;
		int x = screenSize.width;
		
		//custom screen resolution is supported, but the pixel checked is calculated with proportions, so even if it SHOULD work, it might not
		//i suggest setting your display resolution to 1080p or to 720p instead of trying this, since i did tested those but i can't test your custom resolution
		if ((y != 1080 && y != 800 && y != 720) || (x != 1920 && x != 1280)) JOptionPane.showMessageDialog(null, "your screen resolution it's not supported.\nyou can still use the program but it might not work\ni suggest you to set your screen to a supported resolution\nwindows:\t [1920x1080, 1280x720]\nmacOS:\t [1920x1080, 1280x800]\n", "Screen Resolution not Supported", JOptionPane.ERROR_MESSAGE);
		
		//pokemon to hunt
		String[] pokeList = {"suicune", "celebi", "starter", "x"};
		String choosedPokemon = null; //this is to block the user from pressing CANCEL
		while (choosedPokemon == null) choosedPokemon = (String) JOptionPane.showInputDialog(null, "please choose the pokemon to hunt", "pokemon list", JOptionPane.QUESTION_MESSAGE, null, pokeList, pokeList[0]);
		
		
		//checks for the OS and then start the correct thread
		String OS = System.getProperty("os.name");
		switch (OS) {
			case "Mac OS X":
				JOptionPane.showMessageDialog(null, "macOS machine detected\ndetected screen size: " + x + "x" + y);
				(new mac(x, y, choosedPokemon)).start();
				break;	
			case "Windows 10":
				JOptionPane.showMessageDialog(null, "windows machine detected\ndetected screen size: " + x + "x" + y);
				(new win(x, y, choosedPokemon)).start();
				break;
				
		}
		
		//this is to stop the program from running before it finds a shiny pokemon
		String[] options = { "Close the Program"};
		JOptionPane.showOptionDialog(null, "Click to quit", "Warning",
		JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
		null, options, options[0]);
		System.exit(1);
	}
}