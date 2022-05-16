package com.torben.template.items;

import com.torben.template.ConfigMessage;
import com.torben.template.Main;
import com.torben.template.utils.ConfigManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class CustomBook implements CommandExecutor {

    ConfigManager manager = new ConfigManager(new Main());

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage( manager.getMessage(ConfigMessage.CUSTOM_BOOK_GIVEN));

            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setTitle("Template Book");
            meta.setAuthor("Template Author");
            meta.addPage(
                    "Line 1" +
                            "\n" + "Line 2"
            );
            meta.addPage("Line 1" +
                    "\n" + "Line 3");
            book.setItemMeta(meta);
            player.getInventory().addItem(book);
        }
        return false;
    }
}
