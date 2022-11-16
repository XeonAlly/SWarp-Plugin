package com.swarp.xeonally.handlers.cmds;

import com.swarp.xeonally.handlers.managers.warps.Warp;
import com.swarp.xeonally.handlers.utils.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {

        if (cmd.getName().equalsIgnoreCase("워프추가")) {
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage(TextUtil.getColor("&8▶ &c이 명령어는 콘솔에서 사용할 수 없습니다!"));
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission("swarp.cmds")) {
                player.sendMessage(TextUtil.getColor("&8▶ &c이 명령어를 사용할 권한이 없습니다!"));
                return true;
            }

            if (args.length == 0) {
                player.sendMessage(TextUtil.getColor("&8▶ &b/워프추가 <이름> &e- 서 있는 곳에 <이름>라는 워프를 추가합니다."));
                return true;
            }

            if (new Warp().isWarp(args[0])) {
                player.sendMessage(TextUtil.getColor("&8▶ &c이미 추가된 워프 이름입니다!"));
                return true;
            }

            new Warp().saveWarp(args[0], player.getLocation());
            player.sendMessage(TextUtil.getColor("&8▶ &b" + args[0] + "&e이(가) 추가되었습니다!"));
        }

        if (cmd.getName().equalsIgnoreCase("워프삭제")) {
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage(TextUtil.getColor("&8▶ &c이 명령어는 콘솔에서 사용할 수 없습니다!"));
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission("swarp.cmds")) {
                player.sendMessage(TextUtil.getColor("&8▶ &c이 명령어를 사용할 권한이 없습니다!"));
                return true;
            }

            if (args.length == 0) {
                player.sendMessage(TextUtil.getColor("&8▶ &b/워프삭제 <이름> &e- <이름>의 워프를 삭제합니다."));
                return true;
            }

            if (!new Warp().isWarp(args[0])) {
                player.sendMessage(TextUtil.getColor("&8▶ &c추가되지 않은 워프 이름입니다!"));
                return true;
            }

            new Warp().deleteWarp(args[0]);
            player.sendMessage(TextUtil.getColor("&8▶ &b" + args[0] + "&e이(가) 삭제되었습니다!"));
        }

        return false;
    }
}
