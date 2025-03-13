//The town screen, where you can head to the various facilities to improve your skill stats



package screens.town;

import game.BaseScreenPanel;
import game.Texterra;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class TownScreenPanel extends BaseScreenPanel {

	//VARIABLES
    private JLabel townNameLabel;

    
    
    //CONSTRUCTORS
    public TownScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout());

        // --- Top Panel ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        townNameLabel = new JLabel("Generic Town");
        townNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(townNameLabel);
        add(topPanel, BorderLayout.NORTH);

        // --- Center Panel ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JButton shopButton = new JButton("Shop");
        JButton blacksmithButton = new JButton("Blacksmith");
        JButton kitchenButton = new JButton("Kitchen");
        JButton breweryButton = new JButton("Brewery");
        JButton farmButton = new JButton("Farm");

        shopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        blacksmithButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        kitchenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        breweryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        farmButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(shopButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(blacksmithButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(kitchenButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(breweryButton);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(farmButton);
        add(centerPanel, BorderLayout.CENTER);

        // --- Bottom Panel ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // --- Listeners ---
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.MAIN_SCREEN));
        shopButton.addActionListener(e -> mainFrame.showScreen(Texterra.SHOP_SCREEN));
        blacksmithButton.addActionListener(e -> mainFrame.showScreen(Texterra.BLACKSMITH_SCREEN));
        kitchenButton.addActionListener(e -> mainFrame.showScreen(Texterra.KITCHEN_SCREEN));
        breweryButton.addActionListener(e -> mainFrame.showScreen(Texterra.BREWERY_SCREEN));
        farmButton.addActionListener(e -> mainFrame.showScreen(Texterra.FARM_SCREEN));
        
    }

    
    
    //SETTERS
    public void setTownName(String townName) {
        townNameLabel.setText(townName);
    }
    
} //end TownScreenPanel class

