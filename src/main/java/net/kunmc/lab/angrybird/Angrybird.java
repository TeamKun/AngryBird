package net.kunmc.lab.angrybird;

import net.kunmc.lab.angrybird.cmd.AngryBirdMainCommandExecutor;
import net.kunmc.lab.angrybird.listener.ProjectileLaunchEventListener;
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
        pm.registerEvents(new ProjectileLaunchEventListener(this), this);
        tm = new TeamManager();
        getServer().getPluginCommand("ab").setExecutor(new AngryBirdMainCommandExecutor(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
