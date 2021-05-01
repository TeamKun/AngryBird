package net.kunmc.lab.angrybird.cmd;

import net.kunmc.lab.angrybird.Angrybird;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class AngryBirdMainCommandExecutor implements CommandExecutor {
    Angrybird ab;
    public AngryBirdMainCommandExecutor(Angrybird angrybird) {
        this.ab = angrybird;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(ChatColor.GREEN + "チーム1: " + ab.tm.playerCount(1) + "人");
            sender.sendMessage(ChatColor.GREEN + "チーム2: " + ab.tm.playerCount(2) + "人");
            return true;
        }

        if(args.length < 1){
            sender.sendMessage(ChatColor.GREEN + "チーム1: " + ab.tm.playerCount(1) + "人");
            sender.sendMessage(ChatColor.GREEN + "チーム2: " + ab.tm.playerCount(2) + "人");
            sender.sendMessage("-----");
            sender.sendMessage("/ab team add <1/2> <player> チームにプレイヤーを追加します。");
            sender.sendMessage("/ab team random <player> チームにプレイヤーをランダムに追加します。");
            return true;
        }

        if("team".equalsIgnoreCase(args[0])){
            if(args.length < 2){
                sender.sendMessage("/ab team add <1/2> <player> チームにプレイヤーを追加します。");
                sender.sendMessage("/ab team random <player> チームにプレイヤーをランダムに追加します。");
                return true;
            }
        }
        return true;
    }
}
