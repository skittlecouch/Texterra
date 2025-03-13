//MAIN GAME FILE, CONTAINS: public static void main(String[] args) {
//runs UI and all the nonsense



package game;

import screens.ui.*;
import screens.town.*;



import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



// --- Texterra.java (Main Class) ---
public class Texterra extends JFrame {

	//VARIABLES
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MainScreenPanel mainScreen;

    public static final String START_SCREEN = "StartScreen";
    public static final String MAIN_SCREEN = "MainScreen";
    public static final String INVENTORY_SCREEN = "InventoryScreen";
    public static final String TOWN_SCREEN = "TownScreen";
    public static final String SHOP_SCREEN = "ShopScreen";
	public static final String BLACKSMITH_SCREEN = "BlacksmithScreen";
	public static final String FARM_SCREEN = "FarmScreen";
	public static final String KITCHEN_SCREEN = "KitchenScreen";
	public static final String BREWERY_SCREEN = "BreweryScreen";
    public static final String SETTINGS_SCREEN = "SettingsScreen";
    public static final String WORLD_SELECT_SCREEN = "WorldSelectScreen";
    public static final String WILDS_SCREEN = "WildsScreen";



    //CONSTRUCTORS
    public Texterra() {
    	
        setTitle("Texterra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        // Create and add screen panels *directly*
        StartScreenPanel startScreen = new StartScreenPanel(this);
        mainScreen = new MainScreenPanel(this);
        InventoryScreenPanel inventoryScreen = new InventoryScreenPanel(this);
        TownScreenPanel townScreen = new TownScreenPanel(this);
        ShopScreenPanel shopScreen = new ShopScreenPanel(this);
		BlacksmithScreenPanel blacksmithScreen = new BlacksmithScreenPanel(this);
		FarmScreenPanel farmScreen = new FarmScreenPanel(this);
		KitchenScreenPanel kitchenScreen = new KitchenScreenPanel(this);
		BreweryScreenPanel breweryScreen = new BreweryScreenPanel(this);
        SettingsScreenPanel settingsScreen = new SettingsScreenPanel(this);
        WorldSelectScreenPanel worldSelectScreen = new WorldSelectScreenPanel(this);
        WildsScreenPanel wildsScreen = new WildsScreenPanel(this);


        cardPanel.add(startScreen, START_SCREEN);
        cardPanel.add(mainScreen, MAIN_SCREEN);
        cardPanel.add(inventoryScreen, INVENTORY_SCREEN);
        cardPanel.add(townScreen, TOWN_SCREEN);
        cardPanel.add(shopScreen, SHOP_SCREEN);
		cardPanel.add(blacksmithScreen, BLACKSMITH_SCREEN);
		cardPanel.add(farmScreen, FARM_SCREEN);
		cardPanel.add(kitchenScreen, KITCHEN_SCREEN);
		cardPanel.add(breweryScreen, BREWERY_SCREEN);
        cardPanel.add(settingsScreen, SETTINGS_SCREEN);
        cardPanel.add(worldSelectScreen, WORLD_SELECT_SCREEN);
        cardPanel.add(wildsScreen, WILDS_SCREEN);

        cardLayout.show(cardPanel, START_SCREEN);
        setVisible(true);
        
    } //end Texterra() constructor

    
    
    //METHODS
    public void showScreen(String screenName) {
        cardLayout.show(cardPanel, screenName);
    }

    public MainScreenPanel getMainScreenPanel() {
        return mainScreen;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Texterra());
    }
    

    public JPanel getCardPanel() {
        return cardPanel;
    }
    
} //end Texterra class
