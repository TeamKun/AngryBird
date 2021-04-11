package net.kunmc.lab.angrybird.team;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamManager {

    UUID team1_leader;
    UUID team2_leader;

    List<UUID> team1_players;
    List<UUID> team2_players;

    public TeamManager(){
        team1_players = new ArrayList<>();
        team2_players = new ArrayList<>();
    }

    public boolean isLeader(Player p){
        return p.getUniqueId().equals(team1_leader) || p.getUniqueId().equals(team2_leader);
    }
}
