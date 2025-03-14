//class for monsters, contains their stats, drops, drop rates, etc.
//METHODS: int attack(int playerDefense), List<Item> calculateDrops()



//imports
package entities;

import items.Item;



//utilities
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Monster {
	
	//VARIABLES
    private String name;
    private boolean isBoss;
    private int mobID;
    private int level;
    
    private int health;
    private int attack;
    private int defense;
    private int speed;
    
    private double critChance; // 0.0 to 1.0 (e.g., 0.1 for 10% crit chance)
    private double critPercent; // e.g., 1.5 for 150% crit damage
    
    private int xpDrop;
    private int rhinDrop;
    
    private List<Item> itemDrops;
    private List<Double> dropChances; // Must be same size as itemDrops
    
    private static int nextMobID = 0; //To track the Mob Id

    private static final Random random = new Random(); // For random number generation

    
    
    //METHODS
// Attack method
    public int attack(int playerDefense) {
    	
        int damage = this.attack;

        // Critical hit calculation
        if (random.nextDouble() < this.critChance) {
            damage = (int) (damage * this.critPercent);
            System.out.println("Critical Hit!"); // For console output
        }

        // Damage reduction from defense
        damage -= playerDefense;
        
        if (damage < 1) {
            damage = 1; // Ensure at least 1 damage
        }

        return damage;
    }
    
    
// Method to determine item drops
    public List<Item> calculateDrops() {
    	
        List<Item> droppedItems = new ArrayList<>();
        
        for (int i = 0; i < itemDrops.size(); i++) {
        	
            if (random.nextDouble() < dropChances.get(i)) {
                // Add a *copy* of the item to the droppedItems list
                droppedItems.add(itemDrops.get(i).copy());
            }
            
        }
        
        return droppedItems;
        
    }

    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public Monster(String name, boolean isBoss, int level, int health, int attack,
                   int defense, int speed, double critChance, double critPercent,
                   int xpDrop, int rhinDrop, List<Item> itemDrops, List<Double> dropChances) {

        if (itemDrops.size() != dropChances.size()) {
            throw new IllegalArgumentException("Item drops and drop chances lists must have the same size.");
        }

        this.name = name;
        this.isBoss = isBoss;
        this.mobID = nextMobID++;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.critChance = critChance;
        this.critPercent = critPercent;
        this.xpDrop = xpDrop;
        this.rhinDrop = rhinDrop;
        this.itemDrops = new ArrayList<>(itemDrops); // Create copies to avoid external modification
        this.dropChances = new ArrayList<>(dropChances);
    }
    
    
    
    //GETTERS
    public String getName() { return name; }
    public boolean isBoss() { return isBoss; }
    public int getMobID() { return mobID; }
    public int getLevel() { return level; }
    
    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    
    public double getCritChance() { return critChance; }
    public double getCritPercent() { return critPercent; }
    
    public int getXpDrop() { return xpDrop; }
    public int getRhinDrop() { return rhinDrop; }
    
    public List<Item> getItemDrops() { return new ArrayList<>(itemDrops); } // Return a copy
    public List<Double> getDropChances() { return new ArrayList<>(dropChances); }

    
    
    //SETTERS (include validation where appropriate)
    public void setName(String name) { this.name = name; }
    public void setBoss(boolean boss) { isBoss = boss; }
    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        } //else do nothing, or throw a new exception, or log an error.
    }
    
    public void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        } //else do nothing, or throw a new exception, or log an error.
    }
    
     public void setAttack(int attack) {
        if (attack > 0) {
            this.attack = attack;
        } //else do nothing, or throw a new exception, or log an error.
    }
     
    public void setDefense(int defense) {
         if (defense > 0) {
            this.defense = defense;
        } //else do nothing, or throw a new exception, or log an error.
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void setCritChance(double critChance) {
        if (critChance >= 0.0 && critChance <= 1.0) {
            this.critChance = critChance;
        }
    }
    
    public void setCritPercent(double critPercent) {
        if (critPercent >= 0.0) {
            this.critPercent = critPercent;
        } //else do nothing, or throw a new exception, or log an error.
    }

    public void setXpDrop(int xpDrop) { this.xpDrop = xpDrop; }
    public void setRhinDrop(int rhinDrop) { this.rhinDrop = rhinDrop; }
    
    //Consider not having setters for these, as it may cause problems with size
    public void setItemDrops(List<Item> itemDrops) {
        this.itemDrops = new ArrayList<>(itemDrops); // Defensive copy
    }
    
	public void setDropChances(List<Double> dropChances) {
		this.dropChances = new ArrayList<>(dropChances); // Defensive copy
    }

	
    
    @Override
    public String toString() {
    	
        return "Monster{" +
                "name='" + name + '\'' +
                ", isBoss=" + isBoss +
                ", mobID=" + mobID +
                ", level=" + level +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", critChance=" + critChance +
                ", critPercent=" + critPercent +
                ", xpDrop=" + xpDrop +
                ", rhinDrop=" + rhinDrop +
                '}';
        
    }
    
} //end Monster class