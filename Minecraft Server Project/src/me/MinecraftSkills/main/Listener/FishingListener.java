package me.MinecraftSkills.main.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import me.MinecraftSkills.main.PlayerManager;
import me.MinecraftSkills.main.XpManager;

public class FishingListener  implements Listener

{

	
	
	@EventHandler
    public void onPlayerFish(PlayerFishEvent event) 
	{
		//Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Block Event: " + event.getBlock() + event.getBlockAgainst() + event.getBlockPlaced() + event.getBlockReplacedState() + event.getItemInHand() + event.getPlayer() + event.getHand());

		//Fishing

		//Was an der Angel dran!
		if (event.getCaught() != null)
		{
			Item item = (Item) event.getCaught();
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Fishing Event: " + item.getItemStack().getType().toString());
		
		
		if (XpManager.getSkillXP("Fishing", item.getItemStack().getType().name()) != 0) 
		{
			PlayerManager.addSkillXP(event.getPlayer().getUniqueId().toString(), "Fishing", XpManager.getSkillXP("Fishing", item.getItemStack().getType().name()) );
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Fishing Event: Cought, XP: " + XpManager.getSkillXP("Fishing", item.getItemStack().getType().name()  ));
		}

		}
	}

	
	
}