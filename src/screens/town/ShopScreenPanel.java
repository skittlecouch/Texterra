//shop screen, on floors with towns, allows player to use Rhin to purchase items



//imports
package screens.town;

import game.BaseScreenPanel;
import game.Texterra;
import items.Item;
import items.Weapon;
import items.Weapon.WeaponType;
import screens.ui.MainScreenPanel;
import entities.Player;



//utilities
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

    
    
    //METHODS
    public void refreshShopDisplay() {
    	
    centerPanel.removeAll(); // Clear previous items

    for (Item item : shopInventory) {
    	
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //ITEM STATS SHOP DISPLAY
        JLabel itemNameLabel = new JLabel(item.getName());
        JLabel itemDescriptionLabel = new JLabel(item.getDescription());
        JLabel itemPriceLabel;
        
        JLabel itemStrengthRequiredLabel;
        JLabel itemSpeedLabel;
        
        JLabel itemDamageLabel;
        JLabel itemDurabilityLabel;
        JLabel itemQualityPercentageLabel;
        
        JButton buyButton = new JButton("Buy");
        
        

        if (item instanceof Weapon) {  // Check if it's a Weapon
        	
            Weapon weapon = (Weapon) item; // Cast to Weapon
            itemPriceLabel = new JLabel("Value: " + weapon.getValue() + " Rhin");
            
            itemStrengthRequiredLabel = new JLabel("Strength Required: " + weapon.getStrengthReq() );
            itemSpeedLabel = new JLabel("Speed: " + weapon.getSpeed() );
            
            itemDamageLabel = new JLabel("Damage: " + weapon.getDamage() );
            itemDurabilityLabel = new JLabel("Durability: " + weapon.getDurability() );
            itemQualityPercentageLabel = new JLabel("Quality: " + weapon.getQualityPercentage() );
            
            buyButton.addActionListener(new BuyButtonListener(weapon, buyButton)); // Pass the weapon and button
            
        } else {
        	
            itemPriceLabel = new JLabel("Price: N/A");
            
            itemStrengthRequiredLabel = new JLabel("Strength Required: N/A");
            itemSpeedLabel = new JLabel("Speed: N/A");
            
            itemDamageLabel = new JLabel("Damage: N/A");
            itemDurabilityLabel = new JLabel("Durability: N/A");
            itemQualityPercentageLabel = new JLabel("Quality: N/A");
            
            buyButton.setEnabled(false); // Disable if not a Weapon
            
        } //end if else
        
        //ALIGN CENTER
        itemNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        itemStrengthRequiredLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemSpeedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        itemDamageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemDurabilityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemQualityPercentageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        //ADD LABELS AND STUFF
        itemPanel.add(itemNameLabel);
        itemPanel.add(itemDescriptionLabel);
        itemPanel.add(itemPriceLabel);
        
        itemPanel.add(itemStrengthRequiredLabel);
        itemPanel.add(itemSpeedLabel);
        
        itemPanel.add(itemDamageLabel);
        itemPanel.add(itemDurabilityLabel);
        itemPanel.add(itemQualityPercentageLabel);
        
        itemPanel.add(buyButton);
        
        centerPanel.add(itemPanel);
        
    } //end for loop

    centerPanel.revalidate(); // Revalidate and repaint after changes!
    centerPanel.repaint();
    
} //end refreshShopDisplay() method
    
    
    
    // --- Inner Class for Buy Button Listener ---
    private class BuyButtonListener implements ActionListener {
    	
    	//VARIABLES
    	private Weapon weapon; // The weapon to buy
    	private JButton buyButton; // Reference to the buy button

    	//CONSTRUCTORS
    	public BuyButtonListener(Weapon weapon, JButton buyButton) {
    		
    		this.weapon = weapon;
    		this.buyButton = buyButton; // Store the reference to the button
    		
    	} //end constructor

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
    
    
    
    //HELPER METHODS
    
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
        
        
        //MAYBE ADD A SWITCH FOR OTHER FLOORS IDK NOT MY PROBLEM
        //[01]Plains SHOP INVENTORY
        // Add weapons to the shop's inventory
        shopInventory.add(new Weapon("Iron Greatsword", "A heavy two-handed sword.", 10, Weapon.WeaponType.GREATSWORD, 35, 3, 100, 1.0, 100));
        shopInventory.add(new Weapon("Iron Longsword", "A versatile one-handed sword.", 5, Weapon.WeaponType.LONG_SWORD, 25, 5, 100, 1.0, 100));
        shopInventory.add(new Weapon("Iron Dagger", "A quick and deadly dagger.", 2, Weapon.WeaponType.DAGGER, 15, 7, 100, 1.0, 100));
        refreshShopDisplay(); // Initial display
        
    } //end constructor

} //end ShopScreenPanel class