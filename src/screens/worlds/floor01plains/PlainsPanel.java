//Plains floor panel, contains various areas and dungeons to be explored in the wilds menu



//imports
package screens.worlds.floor01plains;

import game.BaseScreenPanel;
import game.Texterra;
import screens.worlds.floor01plains.areas.FieldsAreaScreenPanel;



//utilities
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class PlainsPanel extends BaseScreenPanel {

	//VARIABLES
    private CardLayout areaCardLayout; // CardLayout for areas
    private JPanel areaCardPanel;      // Panel to hold area cards
    private FieldsAreaScreenPanel fieldsAreaPanel; // Instance of the new panel

    
    
    //METHODS
    private void showAreaNotImplemented() {
        // Use getMainFrame() for consistency
        JOptionPane.showMessageDialog(getMainFrame(), "Area not implemented yet.", "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public PlainsPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout()); // Use BorderLayout for overall structure

        
        // --- Top Panel (Title - Optional) ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("[01] Plains"); // Example title
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        
        // --- Center Panel (CardLayout for Areas) ---
        areaCardLayout = new CardLayout();
        areaCardPanel = new JPanel(areaCardLayout);

        // Create instances of your area panels
        fieldsAreaPanel = new FieldsAreaScreenPanel(mainFrame);

        
        // --- Bottom Panel (Area Selection Buttons - Moved here) ---
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        // Area Buttons (with level requirements in labels for now)
        JLabel areasLabel = new JLabel("AREAS:");
        JButton fieldsButton = new JButton("Fields (Lvl 0)");
        JButton riverButton = new JButton("River (Lvl 5)");
        JButton beachButton = new JButton("Beach (Lvl 10)");
        JButton hillsButton = new JButton("Hills (Lvl 15)");
        JButton forestButton = new JButton("Forest (Lvl 20)");
        
        JLabel dungeonsLabel = new JLabel("DUNGEONS:");
        JButton plantDungeonButton = new JButton("Plant Dungeon (Lvl 10)");
        JButton dungeonTowerButton = new JButton("Dungeon Tower (Lvl 20)");

        
        // Add ActionListeners to switch areas (using the CardLayout)
        fieldsButton.addActionListener(e -> mainFrame.showScreen(Texterra.FIELDS_AREA_SCREEN)); 
        riverButton.addActionListener(e -> mainFrame.showScreen(Texterra.RIVER_AREA_SCREEN));
        beachButton.addActionListener(e -> mainFrame.showScreen(Texterra.BEACH_AREA_SCREEN));
        hillsButton.addActionListener(e -> mainFrame.showScreen(Texterra.HILLS_AREA_SCREEN));
        forestButton.addActionListener(e -> mainFrame.showScreen(Texterra.FOREST_AREA_SCREEN));
        plantDungeonButton.addActionListener(e -> showAreaNotImplemented());
        dungeonTowerButton.addActionListener(e -> showAreaNotImplemented());


        //ADD BUTTONS/LABELS TO PANEL
        leftPanel.add(areasLabel);
        leftPanel.add(fieldsButton);
        leftPanel.add(riverButton);
        leftPanel.add(beachButton);
        leftPanel.add(hillsButton);
        leftPanel.add(forestButton);
        
        rightPanel.add(dungeonsLabel);
        rightPanel.add(plantDungeonButton);
        rightPanel.add(dungeonTowerButton);

        add(leftPanel, BorderLayout.WEST); // Add the left panel
        add(rightPanel, BorderLayout.EAST); // Add the right panel
        
    } //end constructor
    
} //end PlainsPanel class