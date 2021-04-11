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
    
    public boolean isExists(Player p){
    return team1_players.contains(p.getUniqueId()) || team2_players.contains(p.getUniqueId()); 
    }
    
    public void remove(Player p){
    team1_players.remove(p.getUniqueId());
    team2_players.remove(p.getUniqueId());
    }
    
    public void reset(int id){
    if(id == 1 || id == 2){
    getById(id).clear();
    } else {
    System.out.println("Invalid team id " + id);
    }
    
    public List<UUID> getById(int id){
    if(id == 1) return team1_players;
    if(id == 2) return team2_players;
    return null;
    } 
}
