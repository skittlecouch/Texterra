//Brewing screen, on floors with towns, allows player to use materials from their inventory to brew potions
//not implemented yet



//imports
package screens.town;

import game.BaseScreenPanel;
import game.Texterra;



//utilities
import javax.swing.JButton;
import javax.swing.JLabel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class BreweryScreenPanel extends BaseScreenPanel {
	
	//CONSTRUCTORS
    public BreweryScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        JLabel breweryLabel = new JLabel("Brewery Screen");
        JButton backButton = new JButton("Back");
		
        add(breweryLabel);
        add(backButton);
		
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.TOWN_SCREEN)); // Go back to main screen
        
    }
    
} //end BreweryScreenPanel class