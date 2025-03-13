// FieldsAreaPanel.java (in src/screens/worlds/floor01plains/areas/fields)
package screens.worlds.floor01plains.areas.fields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.BaseScreenPanel;
import game.Texterra;

public class FieldsAreaPanel extends BaseScreenPanel {

    public FieldsAreaPanel(Texterra mainFrame) {
        super(mainFrame);
        setLayout(new GridLayout(0, 3, 10, 10)); // Example: 3 columns for monsters
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton boarButton = new JButton("Fight Boar");
        JButton slimeButton = new JButton("Fight Slime");
        JButton snakeButton = new JButton("Fight Snake");

        boarButton.addActionListener(createFightActionListener("Boar"));
        slimeButton.addActionListener(createFightActionListener("Slime"));
        snakeButton.addActionListener(createFightActionListener("Snake"));

        add(boarButton);
        add(slimeButton);
        add(snakeButton);
    }

    private ActionListener createFightActionListener(String monsterName) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement actual fight logic here
                JOptionPane.showMessageDialog(mainFrame, "Fighting " + monsterName + " (Not implemented yet)");
            }
        };
    }
}