//Fields area, home to boars slimes and snakes



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



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class FieldsAreaScreenPanel extends BaseScreenPanel {
	
    public FieldsAreaScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout()); // Example: 3 columns for monsters
        setBorder(BorderFactory.createEmptyBorder(450, 0, 0, 50));

        
        JPanel battlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        
        JButton boarButton = new JButton("Fight Boars");
        JButton slimeButton = new JButton("Fight Slimes");
        JButton snakeButton = new JButton("Fight Snakes");


        boarButton.addActionListener(createFightActionListener("Boar"));
        slimeButton.addActionListener(createFightActionListener("Slime"));
        snakeButton.addActionListener(createFightActionListener("Snake"));

        
        battlePanel.add(boarButton);
        battlePanel.add(slimeButton);
        battlePanel.add(snakeButton);
        
        
        add(battlePanel, BorderLayout.CENTER);
        
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.WILDS01_SCREEN));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        
    }

    
    
    private ActionListener createFightActionListener(String monsterName) {
    	
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement actual fight logic here.  For now, just a message.
                JOptionPane.showMessageDialog(getMainFrame(), "Fighting " + monsterName + " (Not implemented yet)");
            }
        };
        
    }
    
} //end FieldsAreaScreenPanel class