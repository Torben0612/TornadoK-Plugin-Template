package com.torben.template.items;

import com.torben.template.Main;
import com.torben.template.utils.ConfigManager;
import com.torben.template.utils.ConfigMessage;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomBanner implements CommandExecutor {

    ConfigManager manager = new ConfigManager(new Main());


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (sender instanceof Player) {
            ItemStack banner = new ItemStack(Material.WHITE_BANNER); //cange the any Minecraft Dye Color color to anything else
            BannerMeta meta = (BannerMeta) banner.getItemMeta();
            List<Pattern> patterns = new ArrayList<>();

            patterns.add(new Pattern(DyeColor.BLACK, PatternType.GLOBE)); //https://minecraft.fandom.com/wiki/Banner/Patterns
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.BORDER)); //https://minecraft.fandom.com/wiki/Banner/Patterns
            meta.setPatterns(patterns);
            banner.setItemMeta(meta);
            ((Player) sender).getInventory().addItem(banner);
            player.sendMessage(manager.getMessage(ConfigMessage.CUSTOM_BANNER_GIVEN));

        }

        return false;
    }
}
