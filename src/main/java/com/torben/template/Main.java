package com.torben.template;

import com.torben.template.items.CustomBanner;
import com.torben.template.items.CustomBook;
import com.torben.template.utils.*;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.SQLException;

public final class Main extends JavaPlugin {

    private Database database;
    private File databaseConfigFile;
    private FileConfiguration databaseConfig;
    Integer bstatid = this.getConfig().getInt("bstats-reseorce-id");
    Metrics metrics = new Metrics(new Main(), bstatid);
    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveResource("lang_en.yml", false);
        saveResource("lang_es.yml", false);

        System.out.println(ChatColor.RED + "");

        String name = getConfig().getString("licencekey");
        if (!new AdvancedLicense(name, "https://codingspigot.000webhostapp.com/verify.php", this).register()) return;

        ConfigManager manager = new ConfigManager(this); //put this in every class that needs to read a lang file

        System.out.println(manager.getMessage(ConfigMessage.WELCOME_MESSAGE));

        this.createDatabaseConfig();

        // Plugin startup logic
        database = new Database();
        try {
            database.connect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.YELLOW + manager.getMessage(ConfigMessage.WELCOME_MESSAGE) + database.isConnected());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        this.createDatabaseConfig();

        getCommand("book").setExecutor(new CustomBook());
        getCommand("banner").setExecutor(new CustomBanner());

        //bstats

        Metrics metrics = new Metrics(this, bstatid); //the bstats id you add in the config.yml
        File itemsFolder = new File(this.getDataFolder().getAbsolutePath() + "/items");
        // make sure this folder doesn't exist already
        if (itemsFolder.exists()) {
            itemsFolder.mkdirs();
        }
        saveResource("items/armor.yml", false);
        saveResource("items/tools.yml", false);
    }

    public FileConfiguration getDatabaseConfig() {
        return this.databaseConfig;
    }


    private void createDatabaseConfig() {
        databaseConfigFile = new File(getDataFolder(), "database.yml");
        if (!databaseConfigFile.exists()) {
            databaseConfigFile.getParentFile().mkdirs();
            saveResource("database.yml", false);
        }
        Bukkit.getPluginManager().registerEvents(new RunnableTemplate(), this);


    }

}
