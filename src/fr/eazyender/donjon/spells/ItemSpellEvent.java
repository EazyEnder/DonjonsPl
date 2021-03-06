package fr.eazyender.donjon.spells;

import fr.eazyender.donjon.spells.water.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

import fr.eazyender.donjon.spells.blood.SpellBloodyBurst;
import fr.eazyender.donjon.spells.blood.SpellBloodyPond;
import fr.eazyender.donjon.spells.earth.SpellEarthChocWave;
import fr.eazyender.donjon.spells.earth.SpellEarthGraplin;
import fr.eazyender.donjon.spells.earth.SpellShield;
import fr.eazyender.donjon.spells.fire.SpellEmbrasement;
import fr.eazyender.donjon.spells.fire.SpellFireNeedle;
import fr.eazyender.donjon.spells.fire.SpellFireProjectiles;
import fr.eazyender.donjon.spells.fire.SpellFirebolt;
import fr.eazyender.donjon.spells.fire.SpellSpatialFire;
import fr.eazyender.donjon.spells.light.SpellLightBang;
import fr.eazyender.donjon.spells.physic.SpellDash;
import fr.eazyender.donjon.spells.physic.SpellOneTarget;
import fr.eazyender.donjon.spells.physic.SpellSpeedBoost;
import fr.eazyender.donjon.spells.poison.SpellPoisonousRain;
import fr.eazyender.donjon.spells.poison.SpellPoisonousSacrifice;
import fr.eazyender.donjon.spells.shadow.SpellShadowSwitch;
import fr.eazyender.donjon.spells.wind.SpellWindSlash;
import fr.eazyender.donjon.spells.wind.SpellWindSpear;

public class ItemSpellEvent implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler()
	public void onPlayerUse(PlayerInteractEvent event){
	    Player p = event.getPlayer();
	 
	    for (int i = 1; i <= SpellUtils.spellNumber; i++) {
	    	if(p.getItemInHand().equals(SpellUtils.getItemSpellById(i))){
		        switch(i) {
		        case 1: SpellFirebolt spell = new SpellFirebolt(1000*5); spell.launch(p);
		        	break;
		        case 2: SpellShield spell1 = new SpellShield(1000*3); spell1.launch(p);
		        	break;
		        case 3: SpellDash spell2 = new SpellDash(1000*2); spell2.launch(p);
	        		break;
		        case 4: SpellEarthChocWave spell3 = new SpellEarthChocWave(1000*2); spell3.launch(p);
        			break;
		        case 5: SpellWindSlash spell4 = new SpellWindSlash(1000*2); spell4.launch(p);
    				break;
		        case 6: SpellSpatialFire spell6 = new SpellSpatialFire(1000*2); spell6.launch(p);
					break;
		        case 7: SpellIceJail spell7 = new SpellIceJail(1000*2); spell7.launch(p);
					break;
		        case 8: SpellHealProjectile spell8 = new SpellHealProjectile(1000*2); spell8.launch(p);
					break;
		        case 9: SpellFireProjectiles spell9 = new SpellFireProjectiles(1000*2); spell9.launch(p);
					break;
		        case 10: SpellEmbrasement spell10 = new SpellEmbrasement(1000*2); spell10.launch(p);
					break;
		        case 11: SpellWaterWave spell11 = new SpellWaterWave(1000*2); spell11.launch(p);
					break;
		        case 12: SpellPoisonousSacrifice spell12 = new SpellPoisonousSacrifice(1000*2); spell12.launch(p);
		        	break;
		        case 13: SpellWindSpear spell13 = new SpellWindSpear(1000*2); spell13.launch(p);
	        		break;
		        case 14: SpellIceSlowDown spell14 = new SpellIceSlowDown(1000*2); spell14.launch(p);
		        	break;
		        case 15: SpellOneTarget spell15 = new SpellOneTarget(1000*2); spell15.launch(p);
	        		break;
		        case 16: SpellSpeedBoost spell16 = new SpellSpeedBoost(1000*2); spell16.launch(p);
        			break;
		        case 17: SpellIceSlowDownAOE spell17 = new SpellIceSlowDownAOE(1000*2); spell17.launch(p);
        			break;
		        case 18: SpellShadowSwitch spell18 = new SpellShadowSwitch(1000*2); spell18.launch(p);
    				break;
		        case 19: SpellEarthGraplin spell19 = new SpellEarthGraplin(1000*2); spell19.launch(p);
					break;
		        case 20: SpellBloodyBurst spell20 = new SpellBloodyBurst(1000*2); spell20.launch(p);
					break;
		        case 21: SpellBloodyPond spell21 = new SpellBloodyPond(1000*2); spell21.launch(p);
					break;
		        case 22: SpellPoisonousRain spell22 = new SpellPoisonousRain(1000*2); spell22.launch(p);
					break;
		        case 23: SpellLightBang spell23 = new SpellLightBang(1000*2); spell23.launch(p);
					break;
		        case 24: SpellFireNeedle spell24 = new SpellFireNeedle(1000*2); spell24.launch(p);
					break;
		        case 25: SpellIceCollapse spell25 = new SpellIceCollapse(1000*2); spell25.launch(p);
					break;
				case 26: SpellHealSelf spell26 = new SpellHealSelf(1000*2); spell26.launch(p);
					break;
				case 27: SpellHealAOE spell27 = new SpellHealAOE(1000*2); spell27.launch(p);
					break;
		        }
		    }
		}
	}
	
	@EventHandler()
	public void onPlayerHold(PlayerItemHeldEvent event){
	    Player p = event.getPlayer();
	 
	    for (int i = 1; i <= SpellUtils.spellNumber; i++) {
	    	if(p.getInventory().getItem(event.getNewSlot()) != null){
	    	if(p.getInventory().getItem(event.getNewSlot()).equals(SpellUtils.getItemSpellById(i))){
		        switch(i) {
		        case 1: SpellFirebolt spell = new SpellFirebolt(1000*2); spell.launch(p);
		        	break;
		        case 2: SpellShield spell2 = new SpellShield(1000*2); spell2.launch(p);
		        	break;
		        case 3: SpellDash spell3 = new SpellDash(1000*2); spell3.launch(p);
		        	break;
		        case 4: SpellEarthChocWave spell4 = new SpellEarthChocWave(1000*2); spell4.launch(p);
		        	break;
		        case 5: SpellWindSlash spell5 = new SpellWindSlash(1000*2); spell5.launch(p);
		        	break;
		        case 6: SpellSpatialFire spell6 = new SpellSpatialFire(1000*2); spell6.launch(p);
		        	break;
		        case 7: SpellIceJail spell7 = new SpellIceJail(1000*2); spell7.launch(p);
		        	break;
		        case 8: SpellHealProjectile spell8 = new SpellHealProjectile(1000*2); spell8.launch(p);
		        	break;
		        case 9: SpellFireProjectiles spell9 = new SpellFireProjectiles(1000*2); spell9.launch(p);
		        	break;
		        case 10: SpellEmbrasement spell10 = new SpellEmbrasement(1000*2); spell10.launch(p);
					break;
		        case 11: SpellWaterWave spell11 = new SpellWaterWave(1000*2); spell11.launch(p);
					break;
		        case 12: SpellPoisonousSacrifice spell12 = new SpellPoisonousSacrifice(1000*2); spell12.launch(p);
					break;
		        case 13: SpellWindSpear spell13 = new SpellWindSpear(1000*2); spell13.launch(p);
					break;
		        case 14: SpellIceSlowDown spell14 = new SpellIceSlowDown(1000*2); spell14.launch(p);
	        		break;
		        case 15: SpellOneTarget spell15 = new SpellOneTarget(1000*2); spell15.launch(p);
        			break;
		        case 16: SpellSpeedBoost spell16 = new SpellSpeedBoost(1000*2); spell16.launch(p);
    				break;
		        case 17: SpellIceSlowDownAOE spell17 = new SpellIceSlowDownAOE(1000*2); spell17.launch(p);
    				break;
		        case 18: SpellShadowSwitch spell18 = new SpellShadowSwitch(1000*2); spell18.launch(p);
					break;
		        case 19: SpellEarthGraplin spell19 = new SpellEarthGraplin(1000*2); spell19.launch(p);
					break;
		        case 20: SpellBloodyBurst spell20 = new SpellBloodyBurst(1000*2); spell20.launch(p);
					break;
		        case 21: SpellBloodyPond spell21 = new SpellBloodyPond(1000*2); spell21.launch(p);
					break;
		        case 22: SpellPoisonousRain spell22 = new SpellPoisonousRain(1000*2); spell22.launch(p);
					break;
		        case 23: SpellLightBang spell23 = new SpellLightBang(1000*2); spell23.launch(p);
					break;
		        case 24: SpellFireNeedle spell24 = new SpellFireNeedle(1000*2); spell24.launch(p);
					break;
		        case 25: SpellIceCollapse spell25 = new SpellIceCollapse(1000*2); spell25.launch(p);
					break;
				case 26: SpellHealSelf spell26 = new SpellHealSelf(1000*2); spell26.launch(p);
					break;
				case 27: SpellHealAOE spell27 = new SpellHealAOE(1000*2); spell27.launch(p);
					break;
		        }
		        p.getInventory().setHeldItemSlot(0);
		    }
	    }
		}
	}

}
