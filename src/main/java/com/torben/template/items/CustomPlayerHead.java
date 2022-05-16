package com.torben.template.items;

import com.torben.template.Main;
import com.torben.template.utils.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CustomPlayerHead implements CommandExecutor {
    ConfigManager manager = new ConfigManager(new Main());


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
