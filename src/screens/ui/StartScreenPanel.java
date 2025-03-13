//startup screen, new game, load save, etc.



package screens.ui;

import game.BaseScreenPanel;
import game.Texterra;



import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class StartScreenPanel extends BaseScreenPanel {
	
	//CONSTRUCTORS
    public StartScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("TEXTERRA");
        JLabel versionLabel = new JLabel("Version 0.1 (Alpha)");

        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Save File");
        JButton settingsButton = new JButton("Settings");
        JButton exitButton = new JButton("Exit");

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        versionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(50));
        add(titleLabel);
        add(Box.createVerticalStrut(10));
        add(versionLabel);
        add(Box.createVerticalStrut(160));
        add(newGameButton);
        add(Box.createVerticalStrut(10));
        add(loadGameButton);
        add(Box.createVerticalStrut(10));
        add(settingsButton);
        add(Box.createVerticalStrut(10));
        add(exitButton);

        newGameButton.addActionListener(e -> mainFrame.showScreen(Texterra.MAIN_SCREEN));
        loadGameButton.addActionListener(e -> {
            String saveCode = JOptionPane.showInputDialog(mainFrame, "Enter Save Code:");
            if (saveCode != null && !saveCode.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Loading save code: " + saveCode + " (Not implemented yet)");
            }
        });
        
        settingsButton.addActionListener(e -> mainFrame.showScreen(Texterra.SETTINGS_SCREEN));
        exitButton.addActionListener(e -> System.exit(0));
        
    } //end constructor
    
} //end StartScreenPanel class
