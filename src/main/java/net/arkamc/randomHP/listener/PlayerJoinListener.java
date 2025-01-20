package net.arkamc.randomHP.listener;

import net.arkamc.randomHP.RandomHP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private RandomHP plugin = RandomHP.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!plugin.getConfig().getBoolean("TIMER_STARTED")) {
            player.setMaxHealth(20.0);
            player.setHealth(20.0);
        }
    }
}
