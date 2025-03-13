// Player.java (in src/entities/)
package entities;

import java.util.ArrayList;
import java.util.List;

import items.Item;
import items.Weapon;
import items.Armor;

public class Player {
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    private int xp;
    private int xpRequirement;
    private int rhin;
    private int strength; // Base strength
    private int defense; // Base defense
    private int speed;    // Base Speed
    private double critChance;
    private double critPercent;
    private int cookingSkill;
    private int blacksmithingSkill;
    private int brewingSkill;
    private int farmingSkill;
    private String currentWorld; // Store the current world ID
    private Weapon equippedWeapon; // The currently equipped weapon
    private Armor equippedArmor; // The currently equipped armor
    private List<Item> inventory;

     public Player(String name) {
        this.name = name;
        this.level = 1;           // Starting level
        this.health = 100;       // Starting health
        this.maxHealth = 100;     // Starting max health
        this.xp = 0;             // Starting XP
        this.xpRequirement = 100; // XP needed for level 2
        this.rhin = 0;           // Starting Rhin
        this.strength = 5;       // Base strength
        this.defense = 5;        // Base defense
        this.speed = 5;        //Base speed
        this.critChance = 0.05;  // Base crit chance (5%)
        this.critPercent = 1.50;
        this.cookingSkill = 0;
        this.blacksmithingSkill = 0;
        this.brewingSkill = 0;
        this.farmingSkill = 0;
        this.currentWorld = "[01]Plains"; // Start in the Plains
        this.equippedWeapon = null; // No weapon equipped initially
        this.equippedArmor = null; // No armor equipped initially
        this.inventory = new ArrayList<>();
    }
    public String getCurrentWorld() {
        return currentWorld;
    }

    public void setCurrentWorld(String worldName) {
        this.currentWorld = worldName;
    }
	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getXP() {
		return xp;
	}

    public int getXpRequirement(){
        return xpRequirement;
    }

	public int getRhin() {
		return rhin;
	}

	public int getStrength() {
        return strength;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed(){
        return speed;
    }
    public double getCritChance(){
        return critChance;
    }
    public double getCritPercent(){
        return critPercent;
    }
	public int getCookingSkill() {
		return cookingSkill;
	}
	public int getBlacksmithingSkill() {
		return blacksmithingSkill;
	}
	public int getBrewingSkill() {
		return brewingSkill;
	}
	public int getFarmingSkill() {
		return farmingSkill;
	}

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
	public Armor getEquippedArmor(){
		return equippedArmor;
	}

    public List<Item> getInventory() {
        return inventory;
    }

    // Setter methods to change values:
    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, maxHealth));  // Keep within 0-maxHealth
    }

     public void setMaxHealth(int maxHealth) {
        this.maxHealth = Math.max(0, maxHealth); // Ensure maxHealth is not negative
        this.health = Math.min(this.health, this.maxHealth); // Ensure health doesn't exceed new max
    }

    public void setXP(int xp) {
        this.xp = Math.max(0, xp); // Prevent negative XP
    }

    public void setXpRequirement(int xpNeeded)
    {
        xpRequirement = xpNeeded;
    }

    public void setRhin(int rhin) {
        this.rhin = Math.max(0, rhin); // Prevent negative Rhin
    }

    public void setCookingSkill(int cookingSkill) {
        this.cookingSkill = Math.max(0, cookingSkill); // Prevent negative skill
    }
    public void setBlacksmithingSkill(int blacksmithingSkill) {
        this.blacksmithingSkill = Math.max(0, blacksmithingSkill); // Prevent negative skill
    }    public void setBrewingSkill(int brewingSkill) {
        this.brewingSkill = Math.max(0, brewingSkill); // Prevent negative skill
    }    public void setFarmingSkill(int farmingSkill) {
        this.farmingSkill = Math.max(0, farmingSkill); // Prevent negative skill
    }

    // Equip and unequip methods
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public void unequipWeapon() {
        this.equippedWeapon = null;
    }
	
	public void setEquippedArmor(Armor armor)
	{
		this.equippedArmor = armor;
	}
	
	public void unequipArmor()
	{
		this.equippedArmor = null;
	}

    // Inventory management
	public void addItemToInventory(Item item) {
	    inventory.add(item);
	}

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
}