//Blacksmithing screen, on floors with towns, allows player to use ores from their inventory to craft weapons
//not implemented yet



package screens.town;

import game.BaseScreenPanel;
import game.Texterra;



import javax.swing.JButton;
import javax.swing.JLabel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class BlacksmithScreenPanel extends BaseScreenPanel {
	
	//CONSTRUCTORS
    public BlacksmithScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        JLabel blacksmithLabel = new JLabel("Blacksmith Screen");
        JButton backButton = new JButton("Back");

        add(blacksmithLabel);
        add(backButton);

        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.TOWN_SCREEN));
        
    }
    
} //end BlacksmithScreenPanel class