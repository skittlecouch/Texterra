//base panel that other panels sit ontop of



package game;



import javax.swing.*;
import java.awt.*;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public abstract class BaseScreenPanel extends JPanel {
	
	//VARIABLES
    private static final long serialVersionUID = 1L; //always good practice
    protected Texterra mainFrame; // Keep this protected (for now)

    
    
    //HELPER METHODS vvv
    
    //CONSTRUCTORS
    public BaseScreenPanel(Texterra mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout()); // Default layout
    }

    //GETTERS
    public Texterra getMainFrame() {
        return mainFrame;
    }
    
} //end BaseScreenPanel class