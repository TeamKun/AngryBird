package net.kunmc.lab.angrybird.listener;

import net.kunmc.lab.angrybird.Angrybird;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectileLaunchEventListener implements Listener {
    public ProjectileLaunchEventListener(Angrybird angrybird) {
        this.ab = angrybird;
    }
    Angrybird ab;

    @EventHandler
    public void on(ProjectileLaunchEvent e){
        if(e.getEntity() instanceof Snowball){
            if(e.getEntity().getShooter() instanceof Player){
                if(ab.tm.isLeader((Player) e.getEntity().getShooter())){
                    //todo:
                }
            }
        }
    }
}
