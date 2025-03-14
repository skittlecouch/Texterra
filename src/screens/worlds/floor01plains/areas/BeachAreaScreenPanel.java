// Beach area, home to red green and blue crabs, aswell as the first miniboss, King Crab



//imports
package screens.worlds.floor01plains.areas;

import game.BaseScreenPanel;
import game.Texterra;
//import src.screens.battle.BattleScreenPanel; // Import BattleScreenPanel -- No longer needed
import screens.worlds.floor01plains.PlainsPanel;



//utilities
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class BeachAreaScreenPanel extends BaseScreenPanel {
	
    public BeachAreaScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout()); // Example: 3 columns for monsters
        setBorder(BorderFactory.createEmptyBorder(450, 0, 0, 50));

        
        JPanel battlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        
        JButton redCrabButton = new JButton("Fight Red Crabs");
        JButton greenCrabButton = new JButton("Fight Green Crabs");
        JButton blueCrabButton = new JButton("Fight Blue Crabs");
        
        JButton kingCrabButton = new JButton("Fight The King Crab Miniboss");

        
        redCrabButton.addActionListener(createFightActionListener("RedCrab"));
        greenCrabButton.addActionListener(createFightActionListener("GreenCrab"));
        blueCrabButton.addActionListener(createFightActionListener("BlueCrab"));
        
        kingCrabButton.addActionListener(createFightActionListener("KingCrabMB"));
        
        
        battlePanel.add(redCrabButton);
        battlePanel.add(greenCrabButton);
        battlePanel.add(blueCrabButton);
        
        battlePanel.add(kingCrabButton);
        
        
        add(battlePanel, BorderLayout.CENTER);
        
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.WILDS01_SCREEN));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
    } //end constructor

    private ActionListener createFightActionListener(String monsterName) {
    	
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement actual fight logic here.  For now, just a message.
                JOptionPane.showMessageDialog(getMainFrame(), "Fighting " + monsterName + " (Not implemented yet)");
            }
        };
        
    }
    
} //end BeachAreaScreenPanel class