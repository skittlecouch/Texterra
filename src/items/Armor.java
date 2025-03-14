//class for the Armor items, stores their stats



//imports
package items;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Armor extends Item {

	//VARIABLES
    private int strengthReq;
    private int defense;
    private int speed; // Could be a penalty (negative) or bonus (positive)
    private int warmth;
    private int durability;
    private double qualityPercentage;
    private int value;

    
    
    //METHODS
    @Override
    public String getItemType() {
        return "Armor";
    }

    @Override
    public Item copy() {
        return new Armor(getName(), getDescription(), getStrengthReq(), getDefense(), getSpeed(),
                getWarmth(), getDurability(), getQualityPercentage(), getValue());
    }
    
    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public Armor(String name, String description, int strengthReq, int defense, int speed,
                 int warmth, int durability, double qualityPercentage, int value) {
        super(name, description);
        this.strengthReq = strengthReq;
        this.defense = defense;
        this.speed = speed;
        this.warmth = warmth;
        this.durability = durability;
        this.qualityPercentage = qualityPercentage;
        this.value = value;
    }
    
    

    //GETTERS
    public int getStrengthReq() {
        return strengthReq;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWarmth() {
        return warmth;
    }

    public int getDurability() {
        return durability;
    }

    public double getQualityPercentage() {
        return qualityPercentage;
    }

    public int getValue() {
        return value;
    }

    
    
    //SETTERS
    public void setStrengthReq(int strengthReq) {
        this.strengthReq = strengthReq;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setWarmth(int warmth) {
        this.warmth = warmth;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setQualityPercentage(double qualityPercentage) {
        this.qualityPercentage = qualityPercentage;
    }

    public void setValue(int value) {
        this.value = value;
    }

    
    
    // toString for debugging
    @Override
    public String toString() {
        return "Armor: " + getName() + ", Defense: " + defense + ", Value: " + value;
    }
    
} //end Armor class