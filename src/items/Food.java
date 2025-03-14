//food item class, stores food stats



//imports
package items;



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



public class Food extends Item {

	//VARIABLES
    private double shelfLife; // Consider using int for days/turns, or double for hours
    private double duration;   // Duration of effects
    private ClassRating classRating;
    private double regenPercent;
    private double attackPercent;
    private double strengthPercent;
    private double defensePercent;
    private double maxHealthPercent;
    private double speedPercent;
    private double durabilityPercent; // Item durability, or perhaps crafting durability?
    private double dropChancePercent;
    private double hyperionPercent; //  What is this?  Needs more context.
    private double critChance;
    private double critPercent;
    private double qualityPercentage;
    private int value;

    public enum ClassRating {
        E, D, C, B, A, S, X, O
    }

    
    
    //METHODS
    @Override
    public Item copy() {
    	
        return new Food(getName(), getDescription(), getShelfLife(), getDuration(),
                getClassRating(), getRegenPercent(), getAttackPercent(),
                getStrengthPercent(), getDefensePercent(), getMaxHealthPercent(),
                getSpeedPercent(), getDurabilityPercent(), getDropChancePercent(),
                getHyperionPercent(), getCritChance(), getCritPercent(),
                getQualityPercentage(), getValue());
        
    }
    
    
    
    //HELPER METHODS
    
    //CONSTRUCTORS
    public Food(String name, String description, double shelfLife, double duration,
                ClassRating classRating, double regenPercent, double attackPercent,
                double strengthPercent, double defensePercent, double maxHealthPercent,
                double speedPercent, double durabilityPercent, double dropChancePercent,
                double hyperionPercent, double critChance, double critPercent,
                double qualityPercentage, int value) {

        super(name, description);
        this.shelfLife = shelfLife;
        this.duration = duration;
        this.classRating = classRating;
        this.regenPercent = regenPercent;
        this.attackPercent = attackPercent;
        this.strengthPercent = strengthPercent;
        this.defensePercent = defensePercent;
        this.maxHealthPercent = maxHealthPercent;
        this.speedPercent = speedPercent;
        this.durabilityPercent = durabilityPercent;
        this.dropChancePercent = dropChancePercent;
        this.hyperionPercent = hyperionPercent;
        this.critChance = critChance;
        this.critPercent = critPercent;
        this.qualityPercentage = qualityPercentage;
        this.value = value;
        
    }

    
    
    //GETTERS
    public double getShelfLife() { return shelfLife; }
    public double getDuration() { return duration; }
    public ClassRating getClassRating() { return classRating; }
    public double getRegenPercent() { return regenPercent; }
    public double getAttackPercent() { return attackPercent; }
    public double getStrengthPercent() { return strengthPercent; }
    public double getDefensePercent() { return defensePercent; }
    public double getMaxHealthPercent() { return maxHealthPercent; }
    public double getSpeedPercent() { return speedPercent; }
    public double getDurabilityPercent() { return durabilityPercent; }
    public double getDropChancePercent() { return dropChancePercent; }
    public double getHyperionPercent() { return hyperionPercent; }
    public double getCritChance() { return critChance; }
    public double getCritPercent() { return critPercent; }
    public double getQualityPercentage() { return qualityPercentage; }
    public int getValue() { return value; }

    @Override
    public String getItemType() {
        return "Food";
    }
    
    
    
    //SETTERS (with basic validation)
    public void setShelfLife(double shelfLife) { if (shelfLife >= 0) this.shelfLife = shelfLife; }
    public void setDuration(double duration) { if (duration >= 0) this.duration = duration; }
    public void setClassRating(ClassRating classRating) { this.classRating = classRating; }
    public void setRegenPercent(double regenPercent) { if (regenPercent >= 0) this.regenPercent = regenPercent; }
    public void setAttackPercent(double attackPercent) { if (attackPercent >= 0) this.attackPercent = attackPercent; }
    public void setStrengthPercent(double strengthPercent) {if(strengthPercent >= 0) this.strengthPercent = strengthPercent; }
    public void setDefensePercent(double defensePercent) { if(defensePercent >= 0) this.defensePercent = defensePercent; }
    public void setMaxHealthPercent(double maxHealthPercent) {if(maxHealthPercent >= 0) this.maxHealthPercent = maxHealthPercent; }
    public void setSpeedPercent(double speedPercent) { if(speedPercent >= 0)this.speedPercent = speedPercent; }
    public void setDurabilityPercent(double durabilityPercent) {if(durabilityPercent >= 0) this.durabilityPercent = durabilityPercent; }
    public void setDropChancePercent(double dropChancePercent) {if(dropChancePercent >= 0) this.dropChancePercent = dropChancePercent; }
    public void setHyperionPercent(double hyperionPercent) {if(hyperionPercent >= 0) this.hyperionPercent = hyperionPercent; }
    public void setCritChance(double critChance) { if (critChance >= 0.0 && critChance <= 1.0) this.critChance = critChance; }
    public void setCritPercent(double critPercent) { if (critPercent >= 0) this.critPercent = critPercent; }
    public void setQualityPercentage(double qualityPercentage) {if(qualityPercentage >= 0) this.qualityPercentage = qualityPercentage; }
    public void setValue(int value) { if (value >= 0) this.value = value; }


    
    //TOSTRING
     @Override
    public String toString() {
        return "Food: " + getName() + ", Class: " + classRating + ", Value: " + value;
    }
     
} //end Food class