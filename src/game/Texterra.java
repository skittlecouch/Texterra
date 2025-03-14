//MAIN CLASS, CONTAINS public static void main(String[] args) {}



//imports
package game;

import screens.ui.*;
import screens.town.*;
import screens.worlds.*;
import game.BaseScreenPanel;
import screens.worlds.floor01plains.Wilds01ScreenPanel;
import screens.worlds.floor01plains.areas.*;



//utilities
import javax.swing.*;
import java.awt.*;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Texterra extends JFrame {
	
	//VARIABLES
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MainScreenPanel mainScreen; // Direct reference

    
    // Constants for screen names.
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

    
    //[01]Plains areas
    public static final String WILDS01_SCREEN = "Wilds01Screen";
    public static final String FIELDS_AREA_SCREEN = "FieldsAreaScreen";
    public static final String RIVER_AREA_SCREEN = "RiverAreaScreen";
    public static final String BEACH_AREA_SCREEN = "BeachAreaScreen";
    public static final String HILLS_AREA_SCREEN = "HillsAreaScreen";
    public static final String FOREST_AREA_SCREEN = "ForestAreaScreen";
    public static final String PLANT_DUNGEON_SCREEN = "PlantDungeonScreen";
    public static final String PLAINS_DUNGEON_TOWER_SCREEN = "PlainsDungeonTowerScreen";
    
    
    //[02]Snow areas
    public static final String WILDS02_SCREEN = "Wilds02Screen";
    //...
    public static final String SNOW_DUNGEON_TOWER_SCREEN = "SnowDungeonTowerScreen";
    
    
    //[03]Desert areas
    public static final String WILDS03_SCREEN = "Wilds03Screen";
    //...
    public static final String DESERT_DUNGEON_TOWER_SCREEN = "DesertDungeonTowerScreen";
    
    
    //[04]Swamp areas
    public static final String WILDS04_SCREEN = "Wilds04Screen";
    //...
    public static final String SWAMP_DUNGEON_TOWER_SCREEN = "SwampDungeonTowerScreen";
    
    
    //[05]Mountain areas
    public static final String WILDS05_SCREEN = "Wilds05Screen";
    //...
    public static final String MOUNTAIN_DUNGEON_TOWER_SCREEN = "MountainDungeonTowerScreen";
    
    
    //[06]Fire areas
    public static final String WILDS06_SCREEN = "Wilds06Screen";
    //...
    public static final String FIRE_DUNGEON_TOWER_SCREEN = "FireDungeonTowerScreen";
    
    
    //[07]Jungle areas
    public static final String WILDS07_SCREEN = "Wilds07Screen";
    //...
    public static final String JUNGLE_DUNGEON_TOWER_SCREEN = "JungleDungeonTowerScreen";
    
    
    //[08]City areas
    public static final String WILDS08_SCREEN = "Wilds08Screen";
    //...
    public static final String CITY_DUNGEON_TOWER_SCREEN = "CityDungeonTowerScreen";
    
    
    //[09]Archipelago areas
    public static final String WILDS09_SCREEN = "Wilds09Screen";
    //...
    public static final String ARCHIPELAGO_DUNGEON_TOWER_SCREEN = "ArchipelagoDungeonTowerScreen";
    
    
    //[10]Cliffs areas
    public static final String WILDS10_SCREEN = "Wilds10Screen";
    //...
    public static final String CLIFFS_DUNGEON_TOWER_SCREEN = "CliffsDungeonTowerScreen";
    
    
    
    //METHODS
    // --- Method to Switch Screens ---
    public void showScreen(String screenName) {
        cardLayout.show(cardPanel, screenName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Texterra());
    }
    
    
    
    //HELPER METHODS
  
    //CONSTRUCTORS
    public Texterra() {
    	
        setTitle("Texterra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        
        
        // --- Create Screens (Panels) ---. Corrected instantiation:
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
        WorldSelectScreenPanel floorSelectScreen = new WorldSelectScreenPanel(this); // Renamed
        
        
        //[01]Plains
        Wilds01ScreenPanel wilds01Screen = new Wilds01ScreenPanel(this); //Wilds01 Screen Panel
        FieldsAreaScreenPanel fieldsAreaScreen = new FieldsAreaScreenPanel(this);
        RiverAreaScreenPanel riverAreaScreen = new RiverAreaScreenPanel(this);
        BeachAreaScreenPanel beachAreaScreen = new BeachAreaScreenPanel(this);
        HillsAreaScreenPanel hillsAreaScreen = new HillsAreaScreenPanel(this);
        ForestAreaScreenPanel forestAreaScreen = new ForestAreaScreenPanel(this);
        
        
        //[02]Snow
        //Wilds02ScreenPanel wilds02Screen = new Wilds02ScreenPanel(this); //Wilds02 Screen Panel
        //...areas...
        
        
        //[03]Desert
        //Wilds03ScreenPanel wilds03Screen = new Wilds03ScreenPanel(this); //Wilds03 Screen Panel
        //...areas...
        
        
        //[04]Swamp
        //Wilds04ScreenPanel wilds04Screen = new Wilds04ScreenPanel(this); //Wilds04 Screen Panel
        //...areas...
        
        
        //[05]Mountain
        //Wilds05ScreenPanel wilds05Screen = new Wilds05ScreenPanel(this); //Wilds05 Screen Panel
        //...areas...
        
        
        //[06]Fire
        //Wilds06ScreenPanel wilds06Screen = new Wilds06ScreenPanel(this); //Wilds06 Screen Panel
        //...areas...
        
        
        //[07]Jungle
        //Wilds07ScreenPanel wilds07Screen = new Wilds07ScreenPanel(this); //Wilds07 Screen Panel
        //...areas...
        
        
        //[08]City
        //Wilds08ScreenPanel wilds08Screen = new Wilds08ScreenPanel(this); //Wilds08 Screen Panel
        //...areas...
        
        
        //[09]Archipelago
        //Wilds09ScreenPanel wilds09Screen = new Wilds09ScreenPanel(this); //Wilds09 Screen Panel
        //...areas...
        
        
        //[10]Cliffs
        //Wilds10ScreenPanel wilds10Screen = new Wilds10ScreenPanel(this); //Wilds10 Screen Panel
        //...areas...
        
        
        
        // --- Add Screens to CardLayout ---
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
        cardPanel.add(floorSelectScreen, WORLD_SELECT_SCREEN); // Renamed and added
        
        
        //[01]Plains
        cardPanel.add(wilds01Screen, WILDS01_SCREEN); // Add wilds01 screen
        cardPanel.add(fieldsAreaScreen, FIELDS_AREA_SCREEN);
        cardPanel.add(riverAreaScreen, RIVER_AREA_SCREEN);
        cardPanel.add(beachAreaScreen, BEACH_AREA_SCREEN);
        cardPanel.add(hillsAreaScreen, HILLS_AREA_SCREEN);
        cardPanel.add(forestAreaScreen, FOREST_AREA_SCREEN);
        //cardPanel.add(plantDungeonScreen, PLANT_DUNGEON_SCREEN);
        //cardPanel.add(plainsDungeonTowerScreen, PLAINS_DUNGEON_TOWER_SCREEN);
        

        //[02]Snow
        //cardPanel.add(wilds02Screen, WILDS02_SCREEN);
        //...
        //cardPanel.add(snowDungeonTowerScreen, SNOW_DUNGEON_TOWER_SCREEN);
        
        
        //[03]Desert
        //cardPanel.add(wilds03Screen, WILDS03_SCREEN);
        //...
        //cardPanel.add(desertDungeonTowerScreen, DESERT_DUNGEON_TOWER_SCREEN);

        
        //[04]Swamp
        //cardPanel.add(wilds04Screen, WILDS04_SCREEN);
        //...
        //cardPanel.add(swampDungeonTowerScreen, SWAMP_DUNGEON_TOWER_SCREEN);

        
        
        //[05]Mountain
        //cardPanel.add(wilds05Screen, WILDS05_SCREEN);
        //...
        //cardPanel.add(mountainDungeonTowerScreen, MOUNTAIN_DUNGEON_TOWER_SCREEN);
        
        
        //[06]Fire
        //cardPanel.add(wilds06Screen, WILDS06_SCREEN);
        //...
        //cardPanel.add(fireDungeonTowerScreen, FIRE_DUNGEON_TOWER_SCREEN);
        
        
        //[07]Jungle
        //cardPanel.add(wilds07Screen, WILDS07_SCREEN);
        //...
        //cardPanel.add(jungleDungeonTowerScreen, JUNGLE_DUNGEON_TOWER_SCREEN);
        
        
        //[08]City
        //cardPanel.add(wilds08Screen, WILDS08_SCREEN);
        //...
        //cardPanel.add(cityDungeonTowerScreen, CITY_DUNGEON_TOWER_SCREEN);
        
        
        //[09]Archipelago
        //cardPanel.add(wilds09Screen, WILDS09_SCREEN);
        //...
        //cardPanel.add(archipelagoDungeonTowerScreen, ARCHIPELAGO_DUNGEON_TOWER_SCREEN);
        
        
        //[10]Cliffs
        //cardPanel.add(wilds10Screen, WILDS10_SCREEN);
        //...
        //cardPanel.add(cliffsDungeonTowerScreen, CLIFFS_DUNGEON_TOWER_SCREEN);
        
        
        
        // --- Initial Screen ---
        cardLayout.show(cardPanel, START_SCREEN); // Start with the start screen

        setVisible(true);
        
    } //end constructor
    
    
    
    //GETTERS
    // --- Getter for MainScreenPanel ---
    public MainScreenPanel getMainScreenPanel() {
        return mainScreen;
    }
    
    public JPanel getCardPanel(){
        return cardPanel;
    }
    
} //end Texterra class