//inventory screen, holds all the items the player has, and allows the player to equip items



package screens.ui;

import game.BaseScreenPanel;
import game.Texterra;

import items.Item;
import items.Ore;
import items.Weapon;



import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class InventoryScreenPanel extends BaseScreenPanel {

	//VARIABLES
    private JPanel inventoryGridPanel;

    
    
    //CONSTRUCTORS
    public InventoryScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Inventory");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        inventoryGridPanel = new JPanel();
        inventoryGridPanel.setLayout(new GridLayout(0, 5, 5, 5));
        inventoryGridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(inventoryGridPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.MAIN_SCREEN));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshInventoryDisplay(); // Initial display
        
    } //end constructor

    
    
    //METHODS
    public void refreshInventoryDisplay() {
    	
        inventoryGridPanel.removeAll();
        List<Item> inventory = mainFrame.getMainScreenPanel().getInventory();

        for (Item item : inventory) {
        	
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            JLabel itemNameLabel = new JLabel(item.getName());
            itemNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemPanel.add(itemNameLabel);

            if (item instanceof Ore) {
            	
                Ore ore = (Ore) item;
                JLabel oreTypeLabel = new JLabel("Type: " + ore.getOreType());
                JLabel valueLabel = new JLabel("Value: " + ore.getValue());
                oreTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                itemPanel.add(oreTypeLabel);
                itemPanel.add(valueLabel);
                
            } else if (item instanceof Weapon) {
            	
                Weapon weapon = (Weapon) item;
                JButton equipButton = new JButton("Equip");
                equipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                equipButton.addActionListener(new EquipButtonListener(weapon, mainFrame));
                itemPanel.add(equipButton);
                
            } // Add more item types here (Armor, Food, Potion)

            inventoryGridPanel.add(itemPanel);
            
        }

        inventoryGridPanel.revalidate();
        inventoryGridPanel.repaint();
        
    } //end refreshInventoryDisplay() method

    
    
    // Inner class to handle Equip button clicks
    private class EquipButtonListener implements ActionListener {
    	
    	//VARIABLES
        private Weapon weapon;
        private Texterra mainFrame;

        //CONSTRUCTORS
        public EquipButtonListener(Weapon weapon, Texterra mainFrame) {
        	
            this.weapon = weapon;
            this.mainFrame = mainFrame;
            
        }

        //METHODS
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            mainFrame.getMainScreenPanel().equipWeapon(weapon);
            mainFrame.getMainScreenPanel().refreshInventoryScreen(); //refresh
            mainFrame.showScreen(Texterra.MAIN_SCREEN); // Go back to the main screen
            
        }
        
    } //end EquipButtonListener subclass

} //end InventoryScreenPanel class