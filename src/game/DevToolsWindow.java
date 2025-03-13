//dev tool window to show player stats to developer, helps with debugging



package game;

import screens.ui.MainScreenPanel;
import entities.Player;

import items.Item;



import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class DevToolsWindow extends JFrame {

	//VARIABLES
    private JTextArea statsArea;
    private Texterra mainFrame; //keep a reference to the main texterra frame

    
    
    //CONSTRUCTORS
    public DevToolsWindow(Texterra mainFrame) {
    	
        this.mainFrame = mainFrame;
        setTitle("Dev Tools");
        setSize(400, 600); // Adjust size as needed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Important: Dispose on close

        statsArea = new JTextArea();
        statsArea.setEditable(false); // Read-only
        JScrollPane scrollPane = new JScrollPane(statsArea);
        add(scrollPane);

        // Add a window listener to handle closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Optionally add some behavior when the window is closed.
                // For example, you might want to null out the devToolsWindow
                // reference in SettingsScreenPanel.  This prevents a memory leak.
            }
        });
        updateStats(); //Update stats upon opening
        
    } //end DevToolsWindow() constructor
    
    
    
    //METHODS
    public void updateStats() {
    	
        // Get data from MainScreenPanel (using getters)
        MainScreenPanel mainScreen = mainFrame.getMainScreenPanel();
        StringBuilder sb = new StringBuilder();

        sb.append("--- Player Stats ---\n");
        sb.append("Name: ").append(mainScreen.getPlayerName()).append("\n"); // Example - add getName()
        sb.append("Level: ").append(mainScreen.getLevel()).append("\n");
        sb.append("Health: ").append(mainScreen.getHealth()).append(" / ").append(mainScreen.getMaxHealth()).append("\n");
        sb.append("XP: ").append(mainScreen.getXP()).append(" / ").append(mainScreen.getXPNeeded()).append("\n");
        sb.append("Rhin: ").append(mainScreen.getRhin()).append("\n");
        sb.append("Strength: ").append(mainScreen.getStrength()).append("\n"); // Assuming you have a getStrength() method
        sb.append("Defense: ").append(mainScreen.getDefense()).append("\n"); // Assuming you have a getDefense() method
        sb.append("Speed: ").append(mainScreen.getSpeed()).append("\n"); // Assuming you have a getSpeed()
        sb.append("Crit Chance: ").append(mainScreen.getCritChance()).append("\n");
        sb.append("Crit Percent: ").append(mainScreen.getCritPercent()).append("\n");
        sb.append("Cooking Skill: ").append(mainScreen.getCookingSkill()).append("\n");
        sb.append("Blacksmithing Skill: ").append(mainScreen.getBlacksmithingSkill()).append("\n");
        sb.append("Brewing Skill: ").append(mainScreen.getBrewingSkill()).append("\n");
        sb.append("Farming Skill: ").append(mainScreen.getFarmingSkill()).append("\n");
        sb.append("Current World: ").append(mainScreen.getCurrentWorld()).append("\n");

        sb.append("\n--- Equipped Items ---\n");
        if (mainScreen.getEquippedWeapon() != null) {
            sb.append("Weapon: ").append(mainScreen.getEquippedWeapon().getName()).append("\n");
        } else {
            sb.append("Weapon: None\n");
        }
         if (mainScreen.getEquippedArmor() != null) {
            sb.append("Armor: ").append(mainScreen.getEquippedArmor().getName()).append("\n"); //need to add getEquippedArmor
        } else {
            sb.append("Armor: None\n");
        }

        sb.append("\n--- Inventory ---\n");
        for (Item item : mainScreen.getInventory()) {
            sb.append(item.toString()).append("\n"); // Use the toString() method of your item classes
        }

        statsArea.setText(sb.toString()); // Update the text area

    } //end updateStats() method
    
} //end DevToolsWindow class