package org.filizes.filizlinks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.filizes.filizlinks.util.UtilColor;
import org.jetbrains.annotations.NotNull;

public class LinksCommand implements CommandExecutor {

    private final Plugin plugin;

    public LinksCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sendLinks(sender);
            return true;
        } else if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("FILIZLinks.reload")) {
            plugin.reloadConfig();
            sender.sendMessage(UtilColor.color(plugin.getConfig().getString("other.reload")));
            return true;
        } else {
            return false;
        }
    }

    private void sendLinks(CommandSender sender) {
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("server.title")));
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("other.symbol") + " &fНаш сайт " + plugin.getConfig().getString("other.symbol-strelka") + " " + plugin.getConfig().getString("links.site")));
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("other.symbol") + " &fФорум " + plugin.getConfig().getString("other.symbol-strelka") + " " + plugin.getConfig().getString("links.forum")));
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("other.symbol") + " &fГруппа ВК " + plugin.getConfig().getString("other.symbol-strelka") + " " + plugin.getConfig().getString("links.vk")));
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("other.symbol") + " &fДискорд " + plugin.getConfig().getString("other.symbol-strelka") + " " + plugin.getConfig().getString("links.discord")));
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("other.symbol") + " &fПоддержка " + plugin.getConfig().getString("other.symbol-strelka") + " " + plugin.getConfig().getString("links.support")));
        sender.sendMessage(UtilColor.color(plugin.getConfig().getString("server.ender")));
    }
}