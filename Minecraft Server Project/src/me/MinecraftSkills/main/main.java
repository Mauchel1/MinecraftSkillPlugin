package me.MinecraftSkills.main;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.MinecraftSkills.main.Commands.*;
import me.MinecraftSkills.main.Listener.*;

public class main extends JavaPlugin implements Listener{

    
	public static main p;
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	p = this;
    	PlayerManager.loadConfig();
    	registerCommands();
    	registerEvents();
    	
    	Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Plugin MinecraftSkills gestartet");
    	System.out.println("Plugin MinecraftSkills gestartet");
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	PlayerManager.saveConfig();
    	System.out.println("Plugin MinecraftSkills gestoppt");
    	Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Plugin MinecraftSkills gestoppt");
    	
    }
    
    private void registerCommands() 
    {
    	this.getCommand("skill_mining").setExecutor(new MiningCommand());
    	this.getCommand("skill_agility").setExecutor(new AgilityCommand());
    	this.getCommand("skill_agility").setExecutor(new AlchemyCommand());
    	this.getCommand("skill_agility").setExecutor(new FarmingCommand());
    	this.getCommand("skill_agility").setExecutor(new FishingCommand());
    	this.getCommand("skill_agility").setExecutor(new WoodcuttingCommand());
    }
    
    private void registerEvents()
    {   
    	Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    	//Bukkit.getPluginManager().registerEvents(this, this);
    	
    }
    
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) 
	{
		Bukkit.broadcastMessage("Moin du Hobelschlonze" );
		boolean found = false;
		for (PlayerManager player : PlayerManager.playerList) {
			if (player.uuid.equals(event.getPlayer().getUniqueId().toString())) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"Beigetretener Spieler bereits geladen");
				found = true;
				break;
			}
		}
		if (!found) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"Beigetretener Spieler Config geschrieben");
			PlayerManager.getPlayerConfig().set("player", event.getPlayer().getUniqueId().toString());
			//Player p = new Player(event.getPlayer().getUniqueId().toString());
			//Player.playerList.add(p);
			
		}
		
		
	}
	
	
}
