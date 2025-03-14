//general item class, things like food potions and weapons are subclasses of Item
//NOTE: COPY METHOD????



//imports
package items;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public abstract class Item {
	
	//VARIABLES
    private String name;
    private String description;
    private int itemID;
    private static int nextItemID = 0;

    
    
    //METHODS
 // Crucial: Add a copy() method to create copies of items
    public abstract Item copy();
    
    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.itemID = nextItemID++;
    }

    
    
    //GETTERS
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getItemID() { return itemID; }

    public abstract String getItemType();
    
    
    
    //SETTERS
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    
} //end Item class