package me.MinecraftSkills.main.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.MinecraftSkills.main.PlayerManager;
import me.MinecraftSkills.main.main;


public class AgilityCommand implements CommandExecutor
{

protected static final main plugin = main.p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage("Du hast " + PlayerManager.getAgilityXP(((Player) sender).getUniqueId().toString()) + " XP in Level " + PlayerManager.getAgilityLvl(((Player) sender).getUniqueId().toString()));

        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}