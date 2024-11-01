package org.filizes.filizlinks;

import org.bukkit.plugin.java.JavaPlugin;
import org.filizes.filizlinks.commands.LinksCommand;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("links").setExecutor(new LinksCommand(this));
    }

    @Override
    public void onDisable() {
    }
}
