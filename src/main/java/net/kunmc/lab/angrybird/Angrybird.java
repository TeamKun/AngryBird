package net.kunmc.lab.angrybird;

import net.kunmc.lab.angrybird.listener.ToggleSneakEventListener;
import net.kunmc.lab.angrybird.team.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Angrybird extends JavaPlugin {

    public TeamManager tm;

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ToggleSneakEventListener(this), this);
        tm = new TeamManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
