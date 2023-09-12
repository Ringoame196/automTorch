package com.github.Ringoame196

import org.bukkit.GameMode
import org.bukkit.entity.Player

class Inventory {
    fun removeOffhandItem(player: Player) {
        if (player.gameMode == GameMode.CREATIVE) { return }
        val itemInOffHand = player.inventory.itemInOffHand
        val oneItem = itemInOffHand.clone()
        oneItem.amount -= 1
        player.inventory.setItemInOffHand(oneItem)
    }
}
