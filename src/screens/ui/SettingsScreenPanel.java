//screen for various settings, will likely include save migration and file location stuff etc.



//imports
package screens.ui;

import game.BaseScreenPanel;
import game.Texterra;

import game.DevToolsWindow;



import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class SettingsScreenPanel extends BaseScreenPanel {
	
	//VARIABLES
    private DevToolsWindow devToolsWindow; // Keep a reference to the dev tools window

    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public SettingsScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout());

        
        // --- Top Panel (Title) ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        
        // --- Center Panel (Settings Options) ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout()); // Or another layout as needed
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton devModeButton = new JButton("Dev Mode");
        
        
        devModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (devToolsWindow == null || !devToolsWindow.isVisible()) {
                    devToolsWindow = new DevToolsWindow(mainFrame);
                    devToolsWindow.setVisible(true);
                    // Crucial: Pass the DevToolsWindow to MainScreenPanel
                    mainFrame.getMainScreenPanel().setDevToolsWindow(devToolsWindow); // ADD THIS
                } else {
                    devToolsWindow.toFront();
                }
            }
        });

        centerPanel.add(devModeButton);
        // Add more settings buttons/options here as needed

        add(centerPanel, BorderLayout.CENTER);

        
        // --- Bottom Panel (Back Button) ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.MAIN_SCREEN));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
    } //end constructor
    
} //end SettingsScreenPanel class