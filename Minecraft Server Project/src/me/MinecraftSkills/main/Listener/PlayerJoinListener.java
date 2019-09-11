package me.MinecraftSkills.main.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.MinecraftSkills.main.PlayerManager;


public class PlayerJoinListener implements Listener
{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) 
	{
		//Bukkit.broadcastMessage("Moin du Hobelschlonze" + event.getPlayer().getUniqueId().toString() );
		event.setJoinMessage("Willkommen du Schwuler Hengst!");
		
		if (PlayerManager.getPlayer(event.getPlayer().getUniqueId().toString()) == null) 
		{
			Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Player with ID " + event.getPlayer().getUniqueId().toString() + " not found");
			PlayerManager.initNewPlayer(event.getPlayer().getUniqueId().toString());
		}
	}
}
