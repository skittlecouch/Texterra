//world selection screen, to choose between various worlds, you must beat the boss of the previous floor's dungeon tower before you can move on to the next



package screens.ui;

import game.BaseScreenPanel;
import game.Texterra;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class WorldSelectScreenPanel extends BaseScreenPanel {
	
	//CONSTRUCTORS
    public WorldSelectScreenPanel(Texterra mainFrame) {
    	
        super(mainFrame);
        setLayout(new BorderLayout());

        
        // --- Top Panel ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("World Select");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        
        // --- Center Panel ---
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] worldNames = {
                "[01]Plains", "[02]Snow", "[03]Desert", "[04]Swamp", "[05]Mountain",
                "[06]Fire", "[07]Jungle", "[08]City", "[09]Archipelago", "[10]Cliffs"
        };

        for (String worldName : worldNames) {
            JButton worldButton = new JButton(worldName);
            worldButton.addActionListener(new WorldButtonListener(worldName, mainFrame));
            centerPanel.add(worldButton);
        }

        add(centerPanel, BorderLayout.CENTER);

        
        // --- Bottom Panel ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        
        backButton.addActionListener(e -> mainFrame.showScreen(Texterra.MAIN_SCREEN));
        
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
    }

    
    
    // --- Inner Class for World Button Listener ---
    private class WorldButtonListener implements ActionListener {
    	
    	//VARIABLES
        private String worldName;
        private Texterra mainFrame;

        //CONSTRUCTORS
        public WorldButtonListener(String worldName, Texterra mainFrame) {
            this.worldName = worldName;
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.getMainScreenPanel().setCurrentWorld(worldName);
            mainFrame.showScreen(Texterra.MAIN_SCREEN);
        }
        
    } //end WorldButtonListener subclass
    
} //end WorldSelectScreenPanel class
