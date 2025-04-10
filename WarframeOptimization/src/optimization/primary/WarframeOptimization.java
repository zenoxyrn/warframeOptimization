package optimization.primary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import optimization.combinations.Combination;
import optimization.combinations.CombinationGeneration;
import optimization.combinations.Mod;
import optimization.io.StatIO;

public class WarframeOptimization {
	
	public static final boolean USE_ROAR = true;
	
	public static final int OCCUPIED_SLOTS = 2;

	public static final double MINIMUM_EFFICIENCY = 0;
	public static final double MINIMUM_DURATION = 0;

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Mod> mods = StatIO.readMods();
		ArrayList<Combination> combinations = CombinationGeneration.generateCombinations(mods, OCCUPIED_SLOTS);
		evaluateXaku(USE_ROAR, combinations);
		sortDescending(combinations);
		
		StatIO.writeMods(combinations);
		
	}
	
	/**
	 * populates all of the combinations with their Xaku evaluation
	 */
	private static void evaluateXaku(boolean roar, ArrayList<Combination> combinations) {
		for (int i = 0; i < combinations.size(); i++) {
			combinations.get(i).evaluateXaku(roar);
		}
	}
	
	/**
	 * sorts the combinations using Combination.compareTo
	 * One of the most inefficient algorithms, but it's only a few hundred thousand data points
	 */
	private static void sortDescending(ArrayList<Combination> combinations) {
		for (int i = 0; i < combinations.size(); i++) {
			Combination highestCombination = combinations.get(i);
			int highestCombinationIndex = i;
			
			for (int j = i; j < combinations.size(); j++) {
				if (combinations.get(j).compareTo(highestCombination) > 0) {
					highestCombination = combinations.get(j);
					highestCombinationIndex = j;
				}
			}
			
			combinations.add(i, combinations.remove(highestCombinationIndex));
		}
	}

}
