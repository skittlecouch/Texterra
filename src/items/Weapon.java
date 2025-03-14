//weapon class, stores data about weapon items, subclass of Item



//imports
package items;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Weapon extends Item {

	//VARIABLES
    private int strengthReq;
    private WeaponType weaponType;
    private int damage;
    private int speed;
    private int durability;
    private double qualityPercentage;
    private int value;

    // Enum for Weapon Types
    public enum WeaponType {
        LONG_SWORD,
        DAGGER,
        GREATSWORD,
        RAPIER,
        BATTLE_AXE
    }
    
    
    
    //METHODS
    @Override
    public Item copy() {
    	
        return new Weapon(getName(), getDescription(), getStrengthReq(), getWeaponType(),
                getDamage(), getSpeed(), getDurability(), getQualityPercentage(), getValue());
        
    }

    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public Weapon(String name, String description, int strengthReq, WeaponType weaponType,
                  int damage, int speed, int durability, double qualityPercentage, int value) {
    	
        super(name, description); // Call the Item constructor
        this.strengthReq = strengthReq;
        this.weaponType = weaponType;
        this.damage = damage;
        this.speed = speed;
        this.durability = durability;
        this.qualityPercentage = qualityPercentage;
        this.value = value;
        
    }

    
    
    //GETTERS
    public int getStrengthReq() {
        return strengthReq;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
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
    
    @Override
    public String getItemType() {
        return "Weapon";
    }

    
    
    //SETTERS
    public void setStrengthReq(int strengthReq) {
        this.strengthReq = strengthReq;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    
    
     //TOSTRING for debugging
    @Override
    public String toString() {
        return "Weapon: " + getName() + ", Type: " + weaponType + ", Damage: " + damage + ", Value: " + value;
    }
    
} //end of Weapon class