package net.arkamc.randomHP.listener;

import net.arkamc.randomHP.commands.RandomHPCommand;
import net.arkamc.randomHP.task.RandomHPTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        RandomHPTask task = new RandomHPTask();
        Player player = event.getPlayer();

        if (task.randomHPTask == null) {
            player.setMaxHealth(20);
            player.setHealth(event.getPlayer().getMaxHealth());
        }
    }
}
