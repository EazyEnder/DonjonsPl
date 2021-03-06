package fr.eazyender.donjon.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fr.eazyender.donjon.donjon.DonjonEvents;
import fr.eazyender.donjon.donjon.DonjonGenerator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.eazyender.donjon.files.PlayerGroupSave;

public class PlayerGroup {
	
	Player host;
	List<UUID> group = new ArrayList<UUID>();
	
	public PlayerGroup(Player host) {
		this.host = host;
	}
	
	public PlayerGroup(Player host,List<UUID> group) {
		this.host = host;
		this.group = group;
	}

	public Player getHost() {
		return host;
	}

	public void setHost(Player host) {
		this.host = host;
	}

	public List<UUID> getGroup() {
		return group;
	}

	public void setGroup(List<UUID> group) {
		this.group = group;
	}
	
	public static boolean aGroupContainPlayer(UUID id) {
		for (int i = 0; i < PlayerGroupSave.getPlayerGroup().getAllGroup().size(); i++) {
			if(PlayerGroupSave.getPlayerGroup().getAllGroup().get(i).getGroup().contains(id)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static PlayerGroup getGroupOfAPlayer(Player player) {
		for (int i = 0; i < PlayerGroupSave.getPlayerGroup().getAllGroup().size(); i++) {
			if(PlayerGroupSave.getPlayerGroup().getAllGroup().get(i).getGroup().contains(player.getUniqueId())) {
				return PlayerGroupSave.getPlayerGroup().getAllGroup().get(i);
			}
		}
		return null;
	}

	public List<Player> getPlayersInARoom(int positionRoom){

		List<Player> players = new ArrayList<Player>();
		List<Player> members = getPlayers();

		for (int i = 0; i < members.size(); i++) {
			if(DonjonEvents.positionPlayer.get(members.get(i)) == positionRoom){
				players.add(members.get(i));
			}
		}

		return players;

	}

	public List<Player> getPlayers(){
		List<Player> players = new ArrayList<Player>();
		players.add(host);
		for (int i = 0; i < group.size(); i++) {
			if(Bukkit.getPlayer(group.get(i)) != null)
				players.add(Bukkit.getPlayer(group.get(i)));
			else
				try {
					players.add((Player)Bukkit.getOfflinePlayer(group.get(i)));	
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		return players;

	}
	
	public boolean containPlayer(UUID id) {
		return group.contains(id);
	}
	
	

}
