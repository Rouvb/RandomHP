package net.arkamc.randomHP;

import lombok.Getter;
import me.gleeming.command.CommandHandler;
import net.arkamc.randomHP.commands.RandomHPCommand;
import net.arkamc.randomHP.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class RandomHP extends JavaPlugin {

    @Getter
    private static RandomHP instance;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        this.getConfig().set("TIMER_STARTED", false);
        this.saveConfig();
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        CommandHandler.registerCommands(RandomHPCommand.class, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
