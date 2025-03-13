//shop screen, on floors with towns, allows player to use Rhin to purchase items



package screens.town;

import game.BaseScreenPanel;
import game.Texterra;
import items.Item;
import items.Weapon;
import items.Weapon.WeaponType;
import screens.ui.MainScreenPanel;
import entities.Player;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class ShopScreenPanel extends BaseScreenPanel {

	//VARIABLES
    private List<Item> shopInventory; // The shop's inventory
    private JPanel centerPanel;       // The panel to display items

    
    
    //CONSTRUCTORS
    public ShopScreenPanel(Texterra mainFrame) {
        super(mainFrame);
        setLayout(new BorderLayout());

        // --- Top Panel (Title) ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Shop");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // --- Center Panel (Shop Items) ---
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 4, 10, 10)); // 4 columns
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(centerPanel, BorderLayout.CENTER); // Add to BorderLayout

        // --- Bottom Panel (Back Button) ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.TOWN_SCREEN));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // --- Initialize Shop Inventory ---
        shopInventory = new ArrayList<>();
        // Add weapons to the shop's inventory
        shopInventory.add(new Weapon("Iron Greatsword", "A heavy two-handed sword.", 20, Weapon.WeaponType.GREATSWORD, 35, -2, 100, 1.0, 100));
        shopInventory.add(new Weapon("Steel Longsword", "A versatile one-handed sword.", 10, Weapon.WeaponType.LONG_SWORD, 25, 0, 100, 1.0, 100));
        shopInventory.add(new Weapon("Steel Dagger", "A quick and deadly dagger.", 5, Weapon.WeaponType.DAGGER, 15, 2, 100, 1.0, 100));
        refreshShopDisplay(); // Initial display
    }
    
    
    
    	//METHODS
        public void refreshShopDisplay() {
        centerPanel.removeAll(); // Clear previous items

        for (Item item : shopInventory) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            JLabel itemNameLabel = new JLabel(item.getName());
            JLabel itemDescriptionLabel = new JLabel(item.getDescription());
            JLabel itemPriceLabel;
            JButton buyButton = new JButton("Buy");

            if (item instanceof Weapon) {  // Check if it's a Weapon
                Weapon weapon = (Weapon) item; // Cast to Weapon
                itemPriceLabel = new JLabel("Value: " + weapon.getValue() + " Rhin");
                buyButton.addActionListener(new BuyButtonListener(weapon, buyButton)); // Pass the weapon and button
            } else {
                itemPriceLabel = new JLabel("Price: N/A");
                buyButton.setEnabled(false); // Disable if not a Weapon
            }
            itemNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            itemPanel.add(itemNameLabel);
            itemPanel.add(itemDescriptionLabel);
            itemPanel.add(itemPriceLabel);
            itemPanel.add(buyButton);
            centerPanel.add(itemPanel);
        }

        centerPanel.revalidate(); // Revalidate and repaint after changes!
        centerPanel.repaint();
    }
        
        
        
    // --- Inner Class for Buy Button Listener ---
        private class BuyButtonListener implements ActionListener {
        	private Weapon weapon; // The weapon to buy
        	private JButton buyButton; // Reference to the buy button

        	public BuyButtonListener(Weapon weapon, JButton buyButton) {
        		this.weapon = weapon;
        		this.buyButton = buyButton; // Store the reference to the button
    	}

        @Override
    	public void actionPerformed(ActionEvent e) {
        	MainScreenPanel mainScreen = mainFrame.getMainScreenPanel();
        	// Check if player has enough Rhin
        	if (mainScreen.getRhin() >= weapon.getValue()) {
            	// Deduct Rhin
            	mainScreen.setRhin(mainScreen.getRhin() - weapon.getValue());
            	// Add a *copy* of the weapon to the player's inventory
            	mainScreen.addItemToInventory(weapon.copy());
            	mainScreen.appendToConsole("Bought " + weapon.getName() + " for " + weapon.getValue() + " Rhin.");

            	// Remove from shop inventory and refresh the display
            	shopInventory.remove(weapon);
            	refreshShopDisplay();
            	mainScreen.refreshInventoryScreen(); // Refresh inventory
            	
        	} else {
        		
            	mainScreen.appendToConsole("Not enough Rhin!");
            	
        	}
        	
    	} //end actionPerformed() method
        
	} //end BuyButtonListener subclass

} //end ShopScreenPanel class