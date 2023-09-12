package com.github.Ringoame196

import net.md_5.bungee.api.ChatMessageType
import org.bukkit.entity.Player
import java.awt.TextComponent

class Message {
    fun sendActionBar(player: Player, message: String) {
        val actionBarComponent = net.md_5.bungee.api.chat.TextComponent(message)

        // アクションバーにメッセージを表示
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, actionBarComponent)
    }
}
