//Ore class, stores data about ore items, subclass of Item



//imports
package items;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Ore extends Item {
	
	//VARIABLES
    private int value;
    private int skillRequired;
    private Affinity affinity; // Use an enum for clarity
    private String oreType; // Add the oreType field
    
    // Enum to represent crafting affinity
    public enum Affinity {
        WEAPON,
        ARMOR,
        INFUSION,
        FUEL,
        NONE
    }

    
    
    //METHODS
    // Implement the copy() method for Ore from Item class
  @Override
  public Item copy() {
	  
      return new Ore(getName(), getDescription(), getValue(), getSkillRequired(), getAffinity());
      
  }
    
    
  
  	//HELPER METHODS
  
    //CONSTRUCTORS
    public Ore(String name, String description, int value, int skillRequired, Affinity affinity) {
    	
        super(name, description);
        this.value = value;
        this.skillRequired = skillRequired;
        this.affinity = affinity;
        
    }

    
    
    //GETTERS
    public int getValue() {
        return value;
    }

    public int getSkillRequired() {
        return skillRequired;
    }

    public Affinity getAffinity() {
        return affinity;
    }
    
    public String getOreType(){ 
        return oreType;
    }
    
    @Override
    public String getItemType() {
        return "Ore";
    }

    
    
    //SETTERS
    public void setValue(int value) {
        this.value = value;
    }

    public void setSkillRequired(int skillRequired) {
        this.skillRequired = skillRequired;
    }
    
    public void setAffinity(Affinity affinity){
        this.affinity = affinity;
    }

    public void setOreType(String oreType) { 
        this.oreType = oreType;
    }
    
    
    
    //TOSTRING
    //Optional toString for easy printing/debugging
    @Override
    public String toString(){
        return "Ore: " + getName() + ", value: " + getValue() + ", Affinity: " + getAffinity();
    }

} //end Ore class