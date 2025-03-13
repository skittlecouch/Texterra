// WildsScreenPanel.java (in src/screens/wilds/)
 package screens.ui;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

 import game.BaseScreenPanel;
 import game.Texterra;
 import screens.worlds.floor01plains.PlainsPanel; // Import PlainsPanel


 public class WildsScreenPanel extends BaseScreenPanel {

     private CardLayout wildsCardLayout;
     private JPanel wildsCardPanel;
     private PlainsPanel plainsPanel; // Add a reference

     public WildsScreenPanel(Texterra mainFrame) {
         super(mainFrame);
         setLayout(new BorderLayout());

         // --- Top Panel (Title) ---
         JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         JLabel titleLabel = new JLabel("Wilds");
         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
         topPanel.add(titleLabel);
         add(topPanel, BorderLayout.NORTH);

         // --- Center Panel (CardLayout for different worlds) ---
         wildsCardLayout = new CardLayout();
         wildsCardPanel = new JPanel(wildsCardLayout);

         plainsPanel = new PlainsPanel(mainFrame); // Create the Plains panel
         wildsCardPanel.add(plainsPanel, "[01]Plains"); // Add it with its world ID.  Keep this ID!
         // Add other world panels here as you create them

         add(wildsCardPanel, BorderLayout.CENTER);


         // --- Bottom Panel (Back Button) ---
         JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JButton backButton = new JButton("Back");
         backButton.addActionListener(e -> mainFrame.showScreen(Texterra.MAIN_SCREEN));
         bottomPanel.add(backButton);
         add(bottomPanel, BorderLayout.SOUTH);
     }

      // IMPORTANT: Method to show a specific world (by its ID)
     public void showWorld(String floorName) {
         wildsCardLayout.show(wildsCardPanel, floorName);
     }
 }