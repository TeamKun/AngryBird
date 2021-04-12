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

    public TeamManager() {
        team1_players = new ArrayList<>();
        team2_players = new ArrayList<>();
    }

    public boolean isLeader(Player p) {
        return p.getUniqueId().equals(team1_leader) || p.getUniqueId().equals(team2_leader);
    }

    public boolean isExists(Player p) {
        return team1_players.contains(p.getUniqueId()) || team2_players.contains(p.getUniqueId());
    }

    public void setLeader(Player p, int id){
        if(isAvailable(id)){
            if(id == 1) team1_leader = p.getUniqueId();
            if(id == 2) team2_leader = p.getUniqueId();
        } else {
            errorId();
        }
    }

    public boolean isAvailable(int id) {
        return id == 1 || id == 2;
    }

    public void remove(Player p) {
        team1_players.remove(p.getUniqueId());
        team2_players.remove(p.getUniqueId());
    }

    public void add(Player p, int id) {
        if (isAvailable(id)) {
            if (getById(id).contains(p.getUniqueId())) return;
            getById(id).add(p.getUniqueId());
        }
    }

    public void reset(int id) {
        if (isAvailable(id)) {
            getById(id).clear();
        } else {
            errorId();
        }
    }

    public void reset() {
        team1_players.clear();
        team2_players.clear();
    }

    public List<UUID> getById(int id) {
        if (id == 1) return team1_players;
        if (id == 2) return team2_players;
        return null;
    }

    void errorId(){
        System.out.println("Invalid team id");
    }
}