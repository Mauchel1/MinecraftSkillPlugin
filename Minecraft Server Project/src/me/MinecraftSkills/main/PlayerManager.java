package me.MinecraftSkills.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerManager {

	protected static final main plugin = main.p;
    private static File playerConfigFile;
    private static FileConfiguration playerConfig;

    
    public static List<PlayerManager> playerList = new ArrayList<PlayerManager>();

	public String uuid;
	
	public int lvlWoodcutting;
	int lvlAgility;
	int lvlMining;
	int lvlFarming;
	int lvlAlchemy;
	int lvlFishing;
	
	int xpWoodcutting;
	int xpAgility;
	int xplMining;
	int xpFarming;
	int xpAlchemy;
	int xpFishing;
	
	
	public PlayerManager(String UUID) {
		uuid = UUID;
	}
	
    public static FileConfiguration getPlayerConfig() {
        return playerConfig;
    }
	
    public static void loadConfig() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "loadConfig()");
        playerConfigFile = new File(plugin.getDataFolder(), "playerconfig.yml");
        if (!playerConfigFile.exists()) {
            playerConfigFile.getParentFile().mkdirs();
    		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "SaveConfig()");
            plugin.saveResource("playerconfig.yml", false);
         }

        playerConfig = new YamlConfiguration();
        try {
    		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "try to load configfile");

            playerConfig.load(playerConfigFile);
            FillPlayerListFromConfig();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig() {
    	try {
    		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Try to save Config");
    		playerConfig.set("playerlist", playerList);
			playerConfig.save(playerConfigFile);
    		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Config saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    
	@SuppressWarnings("unchecked")
	static void FillPlayerListFromConfig() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"try to parse playerlist in List");

			playerList = (List<PlayerManager>) PlayerManager.getPlayerConfig().getList("playerlist");
		}


	public static String getPlayer(String UUID) { return playerConfig.getString("Player." + UUID); }
	
	public static double getAgilityXP(String UUID) { return playerConfig.getDouble("Player." + UUID + ".XP.Agility", 1.0); }
	public static double getMiningXP(String UUID) { return playerConfig.getDouble("Player." + UUID + ".XP.Mining", 1.0); }
	public static double getFarmingXP(String UUID) { return playerConfig.getDouble("Player." + UUID + ".XP.Farming", 1.0); }
	public static double getWoodcuttingXP(String UUID) { return playerConfig.getDouble("Player." + UUID + ".XP.Woodcutting", 1.0); }
	public static double getAlchemyXP(String UUID) { return playerConfig.getDouble("Player." + UUID + ".XP.Alchemy", 1.0); }
	public static double getFishingXP(String UUID) { return playerConfig.getDouble("Player." + UUID + ".XP.Fishing", 1.0); }
	
	public static int getAgilityLvl(String UUID) { return playerConfig.getInt("Player." + UUID + ".Lvl.Agility", 1); }
	public static int getMiningLvl(String UUID) { return playerConfig.getInt("Player." + UUID + ".Lvl.Mining", 1); }
	public static int getFarmingLvl(String UUID) { return playerConfig.getInt("Player." + UUID + ".Lvl.Farming", 1); }
	public static int getWoodcuttingLvl(String UUID) { return playerConfig.getInt("Player." + UUID + ".Lvl.Woodcutting", 1); }
	public static int getAlchemyLvl(String UUID) { return playerConfig.getInt("Player." + UUID + ".Lvl.Alchemy", 1); }
	public static int getFishingLvl(String UUID) { return playerConfig.getInt("Player." + UUID + ".Lvl.Fishing", 1); }

	public static void setAgilityXP(String UUID, double xp) {	playerConfig.set("Player." + UUID + ".XP.Agility", xp);	}
	public static void setMiningXP(String UUID, double xp) {	playerConfig.set("Player." + UUID + ".XP.Mining", xp);	}
	public static void setFarmingXP(String UUID, double xp) {	playerConfig.set("Player." + UUID + ".XP.Farming", xp);	}
	public static void setWoodcuttingXP(String UUID, double xp) { playerConfig.set("Player." + UUID + ".XP.Woodcutting", xp);	}
	public static void setAlchemyXP(String UUID, double xp) {	playerConfig.set("Player." + UUID + ".XP.Alchemy", xp);	}
	public static void setFishingXP(String UUID, double xp) {	playerConfig.set("Player." + UUID + ".XP.Fishing", xp);	}
	
	public static void setAgilityLvl(String UUID, int lvl) {	playerConfig.set("Player." + UUID + ".Lvl.Agility", lvl);	}
	public static void setMiningLvl(String UUID, int lvl) {	playerConfig.set("Player." + UUID + ".Lvl.Mining", lvl);	}
	public static void setFarmingLvl(String UUID, int lvl) {	playerConfig.set("Player." + UUID + ".Lvl.Farming", lvl);	}
	public static void setWoodcuttingLvl(String UUID, int lvl) { playerConfig.set("Player." + UUID + ".Lvl.Woodcutting", lvl);	}
	public static void setAlchemyLvl(String UUID, int lvl) {	playerConfig.set("Player." + UUID + ".Lvl.Alchemy", lvl);	}
	public static void setFishingLvl(String UUID, int lvl) {	playerConfig.set("Player." + UUID + ".Lvl.Fishing", lvl);	}

	public static void initNewPlayer(String UUID) 
	{
		setAgilityXP(UUID, 1.0);
		setMiningXP(UUID, 1.0);
		setFarmingXP(UUID, 1.0);
		setWoodcuttingXP(UUID, 1.0);
		setAlchemyXP(UUID, 1.0);
		setFishingXP(UUID, 1.0);
		
		setAgilityLvl(UUID, 1);
		setMiningLvl(UUID, 1);
		setFarmingLvl(UUID, 1);
		setWoodcuttingLvl(UUID, 1);
		setAlchemyLvl(UUID, 1);
		setFishingLvl(UUID, 1);		
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"Playerconfig Entitys Created for Player " + UUID);

	}
	
//	XP-Berechnung
//	x = 10(n^2-m^2) + 1010(n-m)
//	or
//	10(n-m)(n+m+101)
//	where n is the target level and m is the current level.
//
//	To find how much exp is needed to get to level "L" from 0 exp, this equation can be used:
//	exp = 1010L + 10L^2
//	or
//	10L(101+L)


}
