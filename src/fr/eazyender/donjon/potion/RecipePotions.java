package fr.eazyender.donjon.potion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import fr.eazyender.donjon.donjon.LootUtils;

public class RecipePotions {
	
	private static List<IPotionRecipe> recipes = new ArrayList<IPotionRecipe>();
	
	public static void initRecipes() {
		
		initSmallPotions();
		initMediumPotions();
	
	}
	
	private static void initSmallPotions() {
		
		List<ItemStack> small_fiole_ingredients = new ArrayList<ItemStack>();
		ItemStack small_fiole_ing1 = LootUtils.getLootById(2).clone();
		small_fiole_ing1.setAmount(5);
		small_fiole_ingredients.add(small_fiole_ing1);
		IPotionRecipe small_fiole = new IPotionRecipe(small_fiole_ingredients,
				LootUtils.getLootById(8), 0, 2, 1, 1);
		recipes.add(small_fiole);
		
		List<ItemStack> small_heal_ingredients = new ArrayList<ItemStack>();
		small_heal_ingredients.add(LootUtils.getLootById(3));
		small_heal_ingredients.add(LootUtils.getLootById(8));
		IPotionRecipe small_heal_potion = new IPotionRecipe(small_heal_ingredients,
				PotionUtils.getItemPotionById("1"), 0, 5, 2, 1);
		recipes.add(small_heal_potion);
		
		List<ItemStack> small_speed_ingredients = new ArrayList<ItemStack>();
		small_speed_ingredients.add(LootUtils.getLootById(1));
		small_speed_ingredients.add(LootUtils.getLootById(8));
		IPotionRecipe small_speed_potion = new IPotionRecipe(small_speed_ingredients,
				PotionUtils.getItemPotionById("3"), 0, 5, 3, 1);
		recipes.add(small_speed_potion);
		
		List<ItemStack> small_mana_ingredients = new ArrayList<ItemStack>();
		small_mana_ingredients.add(LootUtils.getLootById(5));
		small_mana_ingredients.add(LootUtils.getLootById(8));
		IPotionRecipe small_mana_potion = new IPotionRecipe(small_mana_ingredients,
				PotionUtils.getItemPotionById("2"), 0, 5, 4, 1);
		recipes.add(small_mana_potion);
	}
	
	private static void initMediumPotions() {
		List<ItemStack> medium_fiole_ingredients = new ArrayList<ItemStack>();
		ItemStack medium_fiole_ing1 = LootUtils.getLootById(2).clone();
		medium_fiole_ing1.setAmount(10);
		medium_fiole_ingredients.add(medium_fiole_ing1);
		IPotionRecipe medium_fiole = new IPotionRecipe(medium_fiole_ingredients,
				LootUtils.getLootById(9), 0, 5, 1, 1);
		recipes.add(medium_fiole);
		
		List<ItemStack> medium_heal_ingredients = new ArrayList<ItemStack>();
		ItemStack medium_heal_ing1 = LootUtils.getLootById(3).clone();
		medium_heal_ing1.setAmount(3);
		medium_heal_ingredients.add(medium_heal_ing1);
		medium_heal_ingredients.add(LootUtils.getLootById(9));
		IPotionRecipe medium_heal_potion = new IPotionRecipe(medium_heal_ingredients,
				PotionUtils.getItemPotionById("4"), 0, 10, 6, 2);
		recipes.add(medium_heal_potion);
	}
	
	public static IPotionRecipe getRecipeById(int id) {
		
		if(recipes.size() >= id) {
			return recipes.get(id-1);
		}else return null;
		
	}
	
	public static String getDifficultyOfRecipe(IPotionRecipe recipe) {
		
		int id = recipe.getDifficulty();
		
		switch(id) {
		case 1: return "F";
		case 2: return "E";
		case 3: return "D";
		case 4: return "C";
		case 5: return "B";
		case 6: return "A";
		case 7: return "S";
		default: return "F";
		}
		
	}
	
	public static IPotionRecipe getRecipeByCraft(ItemStack item) {
		for (int i = 0; i < recipes.size(); i++) {
			IPotionRecipe recipe = recipes.get(i);
			if(recipe.getCraft().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName()))
			return recipe;
		}
		return null;
	}
	
	public static List<IPotionRecipe> getRecipesUnlock(int level) {
		List<IPotionRecipe> levelrecipes = new ArrayList<IPotionRecipe>();
		
		for (int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getLevel() <= level) {
				levelrecipes.add(recipes.get(i));
			}
			
		}
		
		return levelrecipes;
		
	}
	

}
