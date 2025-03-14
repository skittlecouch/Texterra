//Main screen of the UI



//imports
package screens.ui;

import game.Texterra;
import game.BaseScreenPanel;
import game.DevToolsWindow;
import items.*;
import entities.Player;
import screens.ui.InventoryScreenPanel;
import screens.worlds.floor01plains.Wilds01ScreenPanel;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class MainScreenPanel extends BaseScreenPanel {
	
	//VARIABLES
    private JTextArea consoleTextArea;
    //private String currentFloor = "[01]Plains"; //MOVED TO PLAYER CLASS
    private JLabel currentFloorLabel; // Changed variable name

    // Player Stats Labels
    private JLabel healthLabel;
    private JLabel xpLabel;
    private JLabel rhinLabel;
    private JLabel cookingSkillLabel;
    private JLabel blacksmithingSkillLabel;
    private JLabel brewingSkillLabel;
    private JLabel farmingSkillLabel;
    private JLabel equippedWeaponLabel; // Label to display equipped weapon
    private JLabel equippedArmorLabel; //For armor

    // Player object - Holds all the player's data
    private Player player;
    private DevToolsWindow devToolsWindow; // Keep reference for the dev tools



    //METHODS
    public void appendToConsole(String text) {
    	
        consoleTextArea.append(text + "\n");
        consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
        
    }
    
     public void refreshInventoryScreen() {
    	 
        // Find the InventoryScreenPanel by its TYPE (more robust)
        Component[] components = getMainFrame().getCardPanel().getComponents();
        
        for (Component component : components) {
        	
            if (component instanceof InventoryScreenPanel) {
                ((InventoryScreenPanel) component).refreshInventoryDisplay();
                return;
            }
            
        }
        
    }

    // --- Equip/Unequip ---
    public void equipWeapon(Weapon weapon) {
    	
        if (this.player.getEquippedWeapon() != null) {
            unequipWeapon();
        }
        
        this.player.setEquippedWeapon(weapon);
        player.removeItemFromInventory(weapon);
        equippedWeaponLabel.setText("Equipped Weapon: " + weapon.getName());
        appendToConsole("Equipped " + weapon.getName());
        refreshDevTools();
        
    }

    public void unequipWeapon() {
    	
        if (player.getEquippedWeapon() != null) {
        	
            player.addItemToInventory(player.getEquippedWeapon());
            player.setEquippedWeapon(null);
            equippedWeaponLabel.setText("Equipped Weapon: None");
            appendToConsole("Unequipped weapon.");
            refreshDevTools();
            
        }
        
    }
    
    public void equipArmor(Armor armor) {
    	
		player.setEquippedArmor(armor);
		
		if(armor != null) {
			equippedArmorLabel.setText("Equipped Armor: " + player.getEquippedArmor().getName());
		} else {
			equippedArmorLabel.setText("Equipped Armor: None");
		}
		
		refreshDevTools();
		
	}
	
	    public void unequipArmor() {
	    	
        if (player.getEquippedArmor() != null) {
            player.addItemToInventory(player.getEquippedArmor());
            player.setEquippedArmor(null);
            equippedWeaponLabel.setText("Equipped Armor: None");
            appendToConsole("Unequipped Armor.");
            refreshDevTools();
        }
        
    }
    
    
    //add this to your main screen panel class
    public void refreshDevTools() {
    	
        if (devToolsWindow != null && devToolsWindow.isVisible()) {
            devToolsWindow.updateStats();
        }
        
    }
    
    public void addItemToInventory(Item item) {
    	
        player.addItemToInventory(item);
        refreshDevTools();
        
    }

    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public MainScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout());

        // Initialize the player object.  Use the simplified constructor for a new game.
        player = new Player("Hero"); // Or whatever starting name you want


        // --- Left Panel ---
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        JLabel playerStatsLabel = new JLabel("Player Stats");
        JLabel equippedItemsLabel = new JLabel("Equipped Items");
        equippedWeaponLabel = new JLabel("Equipped Weapon: None"); // Initialize
        equippedArmorLabel = new JLabel("Equipped Armor: None");

        playerStatsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        equippedItemsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        equippedWeaponLabel.setAlignmentX(Component.LEFT_ALIGNMENT); //left align
        equippedArmorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Initialize stat labels.  Now they get initial values from the *player* object.
        healthLabel = new JLabel("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        xpLabel = new JLabel("XP: " + player.getXP() + " / " + player.getXpRequirement());
        rhinLabel = new JLabel("Rhin: " + player.getRhin());
        cookingSkillLabel = new JLabel("Cooking Skill: " + player.getCookingSkill());
        blacksmithingSkillLabel = new JLabel("Blacksmithing Skill: " + player.getBlacksmithingSkill());
        brewingSkillLabel = new JLabel("Brewing Skill: " + player.getBrewingSkill());
        farmingSkillLabel = new JLabel("Farming Skill: " + player.getFarmingSkill());

        //Left Align
        healthLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        xpLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rhinLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cookingSkillLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        blacksmithingSkillLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        brewingSkillLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        farmingSkillLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        statsPanel.add(playerStatsLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(healthLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(xpLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(rhinLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(cookingSkillLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(blacksmithingSkillLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(brewingSkillLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(farmingSkillLabel);
        statsPanel.add(Box.createVerticalStrut(20));
        statsPanel.add(equippedItemsLabel);
        statsPanel.add(Box.createVerticalStrut(5));
        statsPanel.add(equippedWeaponLabel); // Add to the UI
        statsPanel.add(equippedArmorLabel);

        JPanel inventoryButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton inventoryButton = new JButton("Inventory");
        inventoryButtonPanel.add(inventoryButton);

        leftPanel.add(statsPanel, BorderLayout.NORTH);
        leftPanel.add(inventoryButtonPanel, BorderLayout.SOUTH);

        
        // --- Top Panel ---
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        currentFloorLabel = new JLabel("Current World: " + player.getCurrentWorld()); // Changed text
        currentFloorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton floorSelectButton = new JButton("Floor Select"); // Changed text
        floorSelectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(currentFloorLabel);
        topPanel.add(floorSelectButton);

        
        // --- Center Panel ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton townButton = new JButton("Town");
        JButton wildsButton = new JButton("Wilds");
        townButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wildsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalStrut(150));
        centerPanel.add(townButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(wildsButton);

        
        // --- Right Panel ---
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleTextArea);

        rightPanel.add(scrollPane, BorderLayout.CENTER);

        
        // --- Bottom Panel ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton settingsButton = new JButton("Settings");
        JButton quitButton = new JButton("Quit");

        bottomPanel.add(settingsButton);
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH);

        
        // --- Add Panels ---
        add(leftPanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        
        // --- Listeners ---
        inventoryButton.addActionListener(e -> {
            getMainFrame().showScreen(Texterra.INVENTORY_SCREEN);
            refreshInventoryScreen(); // Refresh inventory display
        });
        
        townButton.addActionListener(e -> getMainFrame().showScreen(Texterra.TOWN_SCREEN));
        
        floorSelectButton.addActionListener(e -> getMainFrame().showScreen(Texterra.WORLD_SELECT_SCREEN)); // Changed
        
        wildsButton.addActionListener(e -> {
            getMainFrame().showScreen(Texterra.WILDS01_SCREEN);
            player.setCurrentWorld("[01]Plains"); //Sets the floor.  IMPORTANT
            // Show the correct world panel based on player's current world
            //  BETTER WAY: Find by type
            Component[] components = getMainFrame().getCardPanel().getComponents();
            for (Component component : components) {
                if (component instanceof Wilds01ScreenPanel) {
                    ((Wilds01ScreenPanel) component).showWorld(player.getCurrentWorld()); // Show the correct world, using player's state
                    return;
                }
            }
        });

        settingsButton.addActionListener(e -> getMainFrame().showScreen(Texterra.SETTINGS_SCREEN));
        
        quitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to save before quitting?", "Quit Game", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(getMainFrame(), "Saving not implemented yet");
                System.exit(0);
            } else if (result == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        });
    }

    
    
    //GETTERS
    public int getHealth() { return player.getHealth(); }
    public int getMaxHealth() { return player.getMaxHealth(); }
    public int getXP() { return player.getXP(); }
    public int getXPNeeded() { return player.getXpRequirement(); }
    public int getRhin() { return player.getRhin(); }
    public int getCookingSkill() { return player.getCookingSkill(); }
    public int getBlacksmithingSkill() { return player.getBlacksmithingSkill(); }
    public int getBrewingSkill() { return player.getBrewingSkill(); }
    public int getFarmingSkill() { return player.getFarmingSkill(); }
    public String getPlayerName() { return player.getName(); }
    public int getStrength() { return player.getStrength(); }
    public int getDefense() { return player.getDefense(); }
    public int getSpeed() { return player.getSpeed(); }
    public double getCritChance() { return player.getCritChance(); }
    public double getCritPercent() { return player.getCritPercent(); }
    public int getLevel() {return player.getLevel(); }
    public Weapon getEquippedWeapon() { return player.getEquippedWeapon(); }
    public Armor getEquippedArmor() {return player.getEquippedArmor();} //added
    public List<Item> getInventory() { return player.getInventory(); }
    
    public String getCurrentWorld(){
        return player.getCurrentWorld();
    }
    
    
    
    //SETTERS
    public void setHealth(int health) {
        player.setHealth(health);
        healthLabel.setText("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        refreshDevTools(); //refresh dev tools
    }
    
    public void setMaxHealth(int maxHealth) {
        player.setMaxHealth(maxHealth);
        healthLabel.setText("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        refreshDevTools();
    }

    public void setXP(int xp) {
        player.setXP(xp);
        xpLabel.setText("XP: " + player.getXP() + " / " + player.getXpRequirement());
        refreshDevTools();
    }

    public void setXpNeeded(int xpNeeded) {
        player.setXpRequirement(xpNeeded);
        xpLabel.setText("XP: " + player.getXP() + " / " + player.getXpRequirement());
        refreshDevTools();
    }

    public void setRhin(int rhin) {
        player.setRhin(rhin);
        rhinLabel.setText("Rhin: " + player.getRhin());
        refreshDevTools();
    }

    public void setCookingSkill(int cookingSkill) {
        player.setCookingSkill(cookingSkill);
        cookingSkillLabel.setText("Cooking Skill: " + player.getCookingSkill());
        refreshDevTools();
    }
    
    public void setBlacksmithingSkill(int blacksmithingSkill) {
        player.setBlacksmithingSkill(blacksmithingSkill);
        blacksmithingSkillLabel.setText("Blacksmithing Skill: " + player.getBlacksmithingSkill());
        refreshDevTools();
    }
    
    public void setBrewingSkill(int brewingSkill) {
        player.setBrewingSkill(brewingSkill);
        brewingSkillLabel.setText("Brewing Skill: " + player.getBrewingSkill());
        refreshDevTools();
    }
    
    public void setFarmingSkill(int farmingSkill) {
        player.setFarmingSkill(farmingSkill);
        farmingSkillLabel.setText("Farming Skill: " + player.getFarmingSkill());
        refreshDevTools();
    }

    public void setCurrentWorld (String currentFloor) {
        player.setCurrentWorld(currentFloor);
        currentFloorLabel.setText("Current Floor: " + player.getCurrentWorld());
        refreshDevTools();
    }
   


    

    // Setter for DevToolsWindow
    public void setDevToolsWindow(DevToolsWindow devToolsWindow) {
        this.devToolsWindow = devToolsWindow;
    }
	
}