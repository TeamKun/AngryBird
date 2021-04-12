package net.kunmc.lab.angrybird.listener;

import net.kunmc.lab.angrybird.Angrybird;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
    public void on(PlayerToggleSneakEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                int lv = e.getPlayer().getLevel();
                if (lv >= max) lv = 0;
                e.getPlayer().setLevel(lv + 1);
                e.getPlayer().setExp(0);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2f, lv/10);
                if (!e.getPlayer().isSneaking()) {
                    e.getPlayer().setLevel(0);
                    e.getPlayer().setExp(0);
                    cancel();
                }
            }
        }.runTaskTimer(ab, 1, 1);
    }
}
