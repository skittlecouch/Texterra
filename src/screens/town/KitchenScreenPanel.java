//kitchen screen, on floors with towns, allows player to use ingredients from their inventory to craft food
//not implemented yet



package screens.town;

import game.BaseScreenPanel;
import game.Texterra;



import javax.swing.JButton;
import javax.swing.JLabel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class KitchenScreenPanel extends BaseScreenPanel {
	
    public KitchenScreenPanel(Texterra mainFrame) {
    	
    	//CONSTRUCTORS
        super(mainFrame);
        JLabel kitchenLabel = new JLabel("Kitchen Screen");
        JButton backButton = new JButton("Back");
		
        add(kitchenLabel);
        add(backButton);
		
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.TOWN_SCREEN)); // Go back to main screen
        
    }
    
} //end KitchenScreenPanel class