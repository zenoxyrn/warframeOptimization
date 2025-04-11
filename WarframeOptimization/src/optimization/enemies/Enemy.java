package optimization.enemies;

/**
 * Holds the data for a certain Enemy
 */
public class Enemy {
	public enum FACTION{Grineer, Corpus, Infested}
	
	public FACTION faction;
	public double baseHealth;
	public double baseArmor;
	public double baseShields;
	private int baseLevel;
	
	//I'm ignoring health and armor types as far as damage is concerned
	//It's so much more work for something that generally doesn't matter
	
	/**
	 * import constructor
	 */
	public Enemy(FACTION faction, double health, double armor, double shields, int baseLevel) {
		this.faction = faction;
		this.baseHealth = health;
		this.baseArmor = armor;
		this.baseShields = shields;
		this.baseLevel = baseLevel;
	}
	
	/**
	 * Used for evaluating an enemies base level and creating a corresponding object for it 
	 */
	public Enemy(FACTION faction, double health, double armor, double shields, int level, double damageToKill) {
		//a lot of math I haven't gotten around to
	}
	
	public double getEffectiveHealth(int level, double armorStripPercentage) {
		//a lot of math I haven't gotten around to
		return 0;
	}

	/**
	 * For use when exporting to a file
	 */
	@Override
	public String toString() {
		return "";
	}
	
	
	
}
