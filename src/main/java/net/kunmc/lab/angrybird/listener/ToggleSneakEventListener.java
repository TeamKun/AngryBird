package net.kunmc.lab.angrybird.listener;

import net.kunmc.lab.angrybird.Angrybird;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ToggleSneakEventListener implements Listener {
    Angrybird ab;
    public ToggleSneakEventListener(Angrybird angrybird) {
        ab = angrybird;
    }

    int max = 25; // maximum power value

    @EventHandler
    public void on(PlayerToggleSneakEvent e){
        if(ab.tm.isLeader(e.getPlayer())){
            if(e.isSneaking()){
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        int lv = e.getPlayer().getLevel();
                        if(lv <= max) lv = 0;
                        e.getPlayer().setLevel(lv+1);
                        if(!e.isSneaking()){
                            cancel();
                        }
                    }
                }.runTaskTimer(ab, 1,1);
            }
        }
    }
}
