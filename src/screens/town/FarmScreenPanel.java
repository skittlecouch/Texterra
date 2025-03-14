//Farming screen, on floors with towns, allows player to use seeds to grow plants which can be used for cooking
//not implemented yet



//imports
package screens.town;

import game.BaseScreenPanel;
import game.Texterra;



//utilities
import javax.swing.JButton;
import javax.swing.JLabel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class FarmScreenPanel extends BaseScreenPanel {
	
	//CONSTRUCTORS
    public FarmScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        JLabel farmLabel = new JLabel("Farm Screen");
        JButton backButton = new JButton("Back");
		
        add(farmLabel);
        add(backButton);
		
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.TOWN_SCREEN)); // Go back to main screen
        
    }
    
} //end FarmScreenPanel class