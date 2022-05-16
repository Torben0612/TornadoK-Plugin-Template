package com.torben.template.utils;

import com.torben.template.ConfigMessage;
import com.torben.template.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager{

    private YamlConfiguration yamlConfiguration;
    ConfigManager manager;
    public ConfigManager(Main main) {

        File file = new File(main.getDataFolder(), main.getConfig().getString("language") + ".yml");

        if (file.exists()) {
            yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        } else {
            System.out.println(ChatColor.RED + "LANG FILE LOAD ERROR!");
        }
    }

    public String getMessage(ConfigMessage message) {
        return yamlConfiguration.getString(message.name().toLowerCase());
    }

    //public static String getWelcomeMessage() { return yamlConfiguration.getString("welcome-message") }
}