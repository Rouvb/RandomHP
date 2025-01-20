package net.arkamc.randomHP.listener;

import net.arkamc.randomHP.task.RandomHPTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerJoinListener implements Listener {

    HashMap<UUID, Integer> map = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (map.containsKey(uuid)) {
            map.put(uuid, map.get(uuid) + 1);
        } else {
            map.put(uuid, 1);
        }

        int count = map.get(uuid);

        if (count < 2) {
            player.setMaxHealth(20.0);
            player.setHealth(20.0);
        }
    }
}
