package com.torben.template.utils;

import com.torben.template.ConfigMessage;
import com.torben.template.Main;
import com.torben.template.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RunnableTemplate implements Listener {


    ConfigManager manager = new ConfigManager(new Main());
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Bukkit.getScheduler().runTaskLater(new Main(), () ->{
            //add task code here
            player.sendMessage(manager.getMessage(ConfigMessage.RUNNABLE_MESSAGE));
        }, 200); //will run 200ticks after the player joins the server

    }

}
