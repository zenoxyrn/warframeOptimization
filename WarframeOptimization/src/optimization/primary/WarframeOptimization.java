package optimization.primary;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import optimization.combinations.Combination;
import optimization.combinations.CombinationGeneration;
import optimization.combinations.Mod;
import optimization.io.StatIO;

public class WarframeOptimization {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Mod> mods = StatIO.readMods();
//		for (int i = 0; i < mods.size(); i++) System.out.println(mods.get(i).modName);
//		System.out.println(mods.size());
		
		
		ArrayList<Combination> combinations = CombinationGeneration.generateCombinations(mods, 2);
		StatIO.writeMods(combinations);
		
		
	}

}
