//potion class, stores data about potion items, subclass of Item



//imports
package items;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Potion extends Item {

	//VARIABLES
    private PotionType potionType;
    private double duration;
    private double regenPercent;
    private double attackPercent;
    private double strengthPercent;
    private double defensePercent;
    private double maxHealthPercent;
    private double speedPercent;
    private double durabilityPercent;
    private double dropChancePercent;
    private double hyperionPercent; // Still need clarification on this
    private double critChancePercent;
    private double critPercent;
    private double qualityPercentage;
    private int value;

    // Enum for Potion Types
    public enum PotionType {
        HEALTH,
        ATTACK,
        DEFENSE,
        STRENGTH,
        SPEED,
        REGENERATION, // Added, as a more specific type than just health
        // ... Add other potion types as needed ...
        NONE //for if we need an empty potion type
    }

    
    
    //METHODS
    @Override
    public Item copy() {
    	
        return new Potion(getName(), getDescription(), getPotionType(), getDuration(),
                getRegenPercent(), getAttackPercent(), getStrengthPercent(),
                getDefensePercent(), getMaxHealthPercent(), getSpeedPercent(),
                getDurabilityPercent(), getDropChancePercent(), getHyperionPercent(),
                getCritChancePercent(), getCritPercent(), getQualityPercentage(),
                getValue());
        
    }
    
    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public Potion(String name, String description, PotionType potionType, double duration,
                  double regenPercent, double attackPercent, double strengthPercent,
                  double defensePercent, double maxHealthPercent, double speedPercent,
                  double durabilityPercent, double dropChancePercent, double hyperionPercent,
                  double critChancePercent, double critPercent, double qualityPercentage,
                  int value) {

        super(name, description);
        this.potionType = potionType;
        this.duration = duration;
        this.regenPercent = regenPercent;
        this.attackPercent = attackPercent;
        this.strengthPercent = strengthPercent;
        this.defensePercent = defensePercent;
        this.maxHealthPercent = maxHealthPercent;
        this.speedPercent = speedPercent;
        this.durabilityPercent = durabilityPercent;
        this.dropChancePercent = dropChancePercent;
        this.hyperionPercent = hyperionPercent;
        this.critChancePercent = critChancePercent;
        this.critPercent = critPercent;
        this.qualityPercentage = qualityPercentage;
        this.value = value;
        
    }

    
    
    //GETTERS
    public PotionType getPotionType() { return potionType; }
    public double getDuration() { return duration; }
    public double getRegenPercent() { return regenPercent; }
    public double getAttackPercent() { return attackPercent; }
    public double getStrengthPercent() { return strengthPercent; }
    public double getDefensePercent() { return defensePercent; }
    public double getMaxHealthPercent() { return maxHealthPercent; }
    public double getSpeedPercent() { return speedPercent; }
    public double getDurabilityPercent() { return durabilityPercent; }
    public double getDropChancePercent() { return dropChancePercent; }
    public double getHyperionPercent() { return hyperionPercent; }
    public double getCritChancePercent() { return critChancePercent; }
    public double getCritPercent() { return critPercent; }
    public double getQualityPercentage() { return qualityPercentage; }
    public int getValue() { return value; }
    
    @Override
    public String getItemType() {
        return "Potion";
    }
    
    
    
    //SETTERS (with basic validation)
    public void setPotionType(PotionType potionType) { this.potionType = potionType; }
    public void setDuration(double duration) { if (duration >= 0) this.duration = duration; }
    public void setRegenPercent(double regenPercent) { if (regenPercent >= 0) this.regenPercent = regenPercent; }
    public void setAttackPercent(double attackPercent) { if (attackPercent >= 0) this.attackPercent = attackPercent; }
    public void setStrengthPercent(double strengthPercent) { if (strengthPercent >= 0) this.strengthPercent = strengthPercent;}
    public void setDefensePercent(double defensePercent) { if (defensePercent >= 0) this.defensePercent = defensePercent; }
    public void setMaxHealthPercent(double maxHealthPercent) { if (maxHealthPercent >= 0) this.maxHealthPercent = maxHealthPercent; }
    public void setSpeedPercent(double speedPercent) { if (speedPercent >= 0) this.speedPercent = speedPercent; }
    public void setDurabilityPercent(double durabilityPercent) { if (durabilityPercent >= 0) this.durabilityPercent = durabilityPercent; }
    public void setDropChancePercent(double dropChancePercent) {if (dropChancePercent >= 0) this.dropChancePercent = dropChancePercent; }
    public void setHyperionPercent(double hyperionPercent) { if (hyperionPercent >= 0) this.hyperionPercent = hyperionPercent; }
    public void setCritChancePercent(double critChancePercent) {
        if (critChancePercent >= 0.0 && critChancePercent <= 1.0) this.critChancePercent = critChancePercent;
    }
    public void setCritPercent(double critPercent) { if (critPercent >= 0) this.critPercent = critPercent; }
    public void setQualityPercentage(double qualityPercentage) {if (qualityPercentage >= 0) this.qualityPercentage = qualityPercentage; }
    public void setValue(int value) { if (value >= 0) this.value = value; }

    

    //TOSTRING for debugging
    @Override
    public String toString() {
        return "Potion name: " + this.getName() + " Type: " + getPotionType();
    }
    
} //end Potion class