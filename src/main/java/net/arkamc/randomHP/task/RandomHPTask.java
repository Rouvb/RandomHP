package net.arkamc.randomHP.task;

import lombok.Getter;
import net.arkamc.randomHP.RandomHP;
import net.arkamc.randomHP.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
public class RandomHPTask {
    private RandomHP plugin = RandomHP.getInstance();
    public BukkitRunnable randomHPTask;

    public void startRandomHPTask() {
        randomHPTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    float randomHP = getRandomValue();
                    player.setMaxHealth(randomHP);
                    player.setHealth(randomHP);
                    player.sendTitle(CC.translate("&a&l체력이 변경되었습니다!"), "");
                    player.sendMessage(CC.translate("&a체력이 변경되었습니다. &7(&c" + randomHP/2 + "&4❤&7)"));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
                }
            }
        };
        randomHPTask.runTaskTimer(RandomHP.getInstance(), 0, 20L * plugin.getConfig().getInt("TIMER"));
    }

    private float getRandomValue() {
        float randomHeart = (int) (Math.random() * 20) + 1;
        return randomHeart;
    }
}
