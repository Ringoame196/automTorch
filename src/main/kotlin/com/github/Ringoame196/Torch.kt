package com.github.Ringoame196

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player

class Torch {
    fun check(player: Player) {
        val lightLevel = player.location.block.lightLevel
        if (player.gameMode == GameMode.SPECTATOR) { return }
        if (player.gameMode == GameMode.ADVENTURE) { return }
        if (player.location.clone().add(0.0, -1.0, 0.0).block.type == Material.AIR) { return }
        if (player.location.clone().block.type != Material.AIR) { return }
        if (Scoreboard().getValue("autoTorch", player.name) == 1) { return }
        if (lightLevel > 7) { return }
        Installation(player)
    }
    fun Installation(player: Player) {
        player.playSound(player.location, Sound.BLOCK_NOTE_BLOCK_BELL, 5f, 1f)
        player.location.block.type = Material.TORCH
        Message().sendActionBar(player, "${ChatColor.YELLOW}松明を設置しました(オフにする場合は松明を左クリックしてください)")
        Inventory().removeOffhandItem(player)
    }

    fun switching(player: Player) {
        player.playSound(player.location, Sound.UI_BUTTON_CLICK, 1f, 1f)
        when (Scoreboard().getValue("autoTorch", player.name)) {
            0 -> {
                Scoreboard().set("autoTorch", player.name, 1)
                player.sendTitle("", "${ChatColor.RED}松明設置OFF")
            }
            1 -> {
                Scoreboard().set("autoTorch", player.name, 0)
                player.sendTitle("", "${ChatColor.AQUA}松明設置ON")
            }
        }
    }
}
