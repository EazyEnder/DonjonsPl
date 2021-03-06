package fr.eazyender.donjon.donjon;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.eazyender.donjon.arena.ArenaUtils;
import fr.eazyender.donjon.files.PlayerArena;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.files.PlayerShop;
import fr.eazyender.donjon.gui.InventoryGui;
import fr.eazyender.donjon.potion.PotionUtils;
import fr.eazyender.donjon.spells.SpellUtils;

public class LevelUtils {
	
	public static int[] pallierSkill = {1,5,10,20};
	private static final int[] xpneed = {25/2,35/2,50/2,70/2,100/2,125/2,150/2,175/2,200/2,225/2
			,260/2,290/2,325/2,360/2,400/2,440/2,490/2,540/2,590/2,650/2
			,700/2,2770/2,840/2,910/2,980/2,1050/2,1130/2,1210/2,1290/2,1400/2};
	
	public static void updateXp(Player player) {
		
		int level = PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player);
		long xp = PlayerLevelStats.getPlayerLevelStats().getXpDonjon(player);
		if(xp > getXpNecessary(level+1)) {
			PlayerLevelStats.getPlayerLevelStats().setLevelDonjon(player, level+1);
			PlayerLevelStats.getPlayerLevelStats().setXpDonjon(player, 0);
			
			player.sendMessage("�8[�4Donjon�8] : �f" + "Vous �tes mont� d'un niveau ! (niveau:" + (level+1) +")");
			PlayerLevelStats.getPlayerLevelStats().setSkillPoints(player, PlayerLevelStats.getPlayerLevelStats().getSkillPoints(player)+1);
			
			updateName(player);
		}
		InventoryGui.updateInventory(player);
		
	}
	
	public static void updateName(Player player) {
		
		String name = player.getName();
		
		int level = PlayerLevelStats.getPlayerLevelStats().getLevelDonjon(player);
		name = "�r�f[�r" +ArenaUtils.getCircleOfRank(PlayerLevelStats.getPlayerLevelStats().getLevelRank(player)) + "�r�f/" + LevelUtils.getRankName(level) + "�r�f]�r" + name;
		if(PlayerShop.getPlayerShopProfil().getGrade(player) > 0) {
			switch(PlayerShop.getPlayerShopProfil().getGrade(player)) {
			case 1: name = "�r�f[�3�lI�r�f]�f" + name;
				break;
			case 2: name = "�r�f[�1�lII�r�f]�f" + name;
				break;
			case 3: name = "�r�f[�9�lIII�r�f]�f" + name;
				break;
			}
		}
		if(player.isOp()) name = "�r�c[�4!�r�c]�r" + name;
		
		player.setDisplayName(name);
	}
	
	public static void updateSkill(Player player, int id) {
		
		for (int i = 0; i < pallierSkill.length; i++) {
			if(PlayerLevelStats.getPlayerLevelStats().getAStatsPoints(player, id) == pallierSkill[i]) {
				switch(id) {
				case 1: 
					switch(i) {
					case 0:
						PotionUtils.givePotion(player,3,3);
						break;
					case 1:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(3))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(3);
						break;
					case 2:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(5))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(5);
						break;
					case 3:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(13))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(13);
						break;
					}
					break;
				case 2:
					switch(i) {
					case 0:
						PotionUtils.givePotion(player,1,3);
						break;
					case 1:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(2))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(2);
						break;
					case 2:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(15))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(15);
						break;
					}
					break;
				case 3:
					switch(i) {
					case 0:
						PotionUtils.givePotion(player,2,3);
						break;
					case 1:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(1))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(1);
						break;
					case 2:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(8))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(8);
						break;
					case 3:
						if(!PlayerEquipment.getPlayerEquipment().getSpells(player).contains(9))
							PlayerEquipment.getPlayerEquipment().getSpells(player).add(9);
						break;
					}
					break;
				}
				player.sendMessage("Vous avez gagn� : " + getAwardSkill(id, i).getItemMeta().getDisplayName() + " !");
			}
		}
		
	}
	
	public static ItemStack getAwardSkill(int id, int stape) {
		ItemStack item = getCustomItemWithLore(Material.GRAY_CONCRETE, "�fPas de r�compense", false, 1, null);
		switch(id) {
		//ATQ
		case 1:
			switch(stape) {
			case 0: item = PotionUtils.getItemPotionById("3"); item.setAmount(3);
				break;
			case 1: item = SpellUtils.getItemSpellById(3);
				break;
			case 2: item = SpellUtils.getItemSpellById(5);
				break;
			case 3: item = SpellUtils.getItemSpellById(13);
				break;
			}
			break;
		//DEF
		case 2:
			switch(stape) {
			case 0: item = PotionUtils.getItemPotionById("1"); item.setAmount(3);
				break;
			case 1: item = SpellUtils.getItemSpellById(2);
				break;
			case 2: item = SpellUtils.getItemSpellById(15);
				break;
			}
			break;
		//MAG
		case 3:
			switch(stape) {
			case 0: item = PotionUtils.getItemPotionById("2"); item.setAmount(3);
				break;
			case 1: item = SpellUtils.getItemSpellById(1);
				break;
			case 2: item = SpellUtils.getItemSpellById(8);
				break;
			case 3: item = SpellUtils.getItemSpellById(9);
				break;
			}
			break;
		}
		return item;
	}
	
	public static String getRankName(int level) {
		String rank = "�7Voyageur";
		if(level < 1) {rank = "�7Voyageur";}
		else if(level == 1) {rank = "�7Novice";}
		else if(level < 5) {rank = "�7Adepte";}
		else if(level < 10) {rank = "�7Aventurier-" + "PR";}
		else if(level < 20) {rank = "�6Aventurier-" + "CU";}
		else if(level < 30) {rank = "�8Aventurier-" + "FE";}
		else if(level < 40) {rank = "�6�lAventurier-" + "BR";}
		else if(level < 50) {rank = "�7�lAventurier-" + "AR";}
		else if(level < 60) {rank = "�eAventurier-" + "OR";}
		return rank;
	}
	
	public static long getXpNecessary(int level) {
		
		long xp = 0;
		if(level > 0 && level <= xpneed.length) {
			xp = xpneed[level-1];
		}
		
		return xp;
		
	}
	
	public static ItemStack getCustomItemWithLore(Material material, String customName, boolean EnchantEffect, int nbr, List<String> lore) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		if(lore != null) {
		itemMeta.setLore(lore);
		}
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}

}
