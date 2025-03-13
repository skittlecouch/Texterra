// PlainsPanel.java (in src/screens/worlds/floor01plains/)
package screens.worlds.floor01plains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.BaseScreenPanel;
import game.Texterra;
import screens.worlds.floor01plains.areas.fields.FieldsAreaPanel; // Corrected import

public class PlainsPanel extends BaseScreenPanel {

    private CardLayout areaCardLayout; // CardLayout for areas
    private JPanel areaCardPanel;      // Panel to hold area cards
    private FieldsAreaPanel fieldsAreaPanel; // Instance of the new panel

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
        fieldsAreaPanel = new FieldsAreaPanel(mainFrame);

        // Add the area panels to the card layout
        areaCardPanel.add(fieldsAreaPanel, "FieldsArea"); // Add with a unique name
        // Add other area panels here (e.g., RiverAreaPanel, BeachAreaPanel)

        add(areaCardPanel, BorderLayout.CENTER); // Add the card panel to the PlainsPanel


        // --- Bottom Panel (Area Selection Buttons - Moved here) ---
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout()); // Use FlowLayout

        // Area Buttons (with level requirements in labels for now)
        JButton fieldsButton = new JButton("Fields (Lvl 0)");
        JButton riverButton = new JButton("River (Lvl 5)");
        JButton beachButton = new JButton("Beach (Lvl 10)");
        JButton hillsButton = new JButton("Hills (Lvl 15)");
        JButton forestButton = new JButton("Forest (Lvl 20)");
        JButton plantDungeonButton = new JButton("Plant Dungeon (Lvl 10)");
        JButton dungeonTowerButton = new JButton("Dungeon Tower (Lvl 20)");

        // Add ActionListeners to switch areas (using the CardLayout)
        fieldsButton.addActionListener(e -> areaCardLayout.show(areaCardPanel, "FieldsArea"));
        riverButton.addActionListener(e -> showAreaNotImplemented());
        beachButton.addActionListener(e -> showAreaNotImplemented());
        hillsButton.addActionListener(e -> showAreaNotImplemented());
        forestButton.addActionListener(e -> showAreaNotImplemented());
        plantDungeonButton.addActionListener(e -> showAreaNotImplemented());
        dungeonTowerButton.addActionListener(e -> showAreaNotImplemented());


        bottomPanel.add(fieldsButton);
        bottomPanel.add(riverButton);
        bottomPanel.add(beachButton);
        bottomPanel.add(hillsButton);
        bottomPanel.add(forestButton);
        bottomPanel.add(plantDungeonButton);
        bottomPanel.add(dungeonTowerButton);

        add(bottomPanel, BorderLayout.SOUTH); // Add the bottom panel
    }
    private void showAreaNotImplemented() {
    // Use getMainFrame() for consistency
    JOptionPane.showMessageDialog(getMainFrame(), "Area not implemented yet.", "Not Implemented", JOptionPane.INFORMATION_MESSAGE);
}
}