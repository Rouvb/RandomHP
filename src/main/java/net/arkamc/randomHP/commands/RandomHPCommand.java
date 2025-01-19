package net.arkamc.randomHP.commands;

import me.gleeming.command.Command;
import me.gleeming.command.paramter.Param;
import net.arkamc.randomHP.RandomHP;
import net.arkamc.randomHP.task.RandomHPTask;
import net.arkamc.randomHP.utils.CC;
import org.bukkit.command.CommandSender;

public class RandomHPCommand {
    private RandomHP plugin = RandomHP.getInstance();
    RandomHPTask task = new RandomHPTask();

    @Command(names = {"randomhp start"}, permission = "randomhp.admin")
    public void randomHPStart(CommandSender sender) {
        if (task.randomHPTask != null && !task.getRandomHPTask().isCancelled()) {
            sender.sendMessage("&c이미 랜덤 체력 타이머가 실행 중입니다.");
            return;
        }

        sender.sendMessage(CC.translate("&a랜덤 체력 타이머가 시작되었습니다."));
        task.startRandomHPTask();
    }

    @Command(names = {"randomhp stop"}, permission = "randomhp.admin")
    public void randomHPStop(CommandSender sender) {
        if (task.randomHPTask != null) {
            task.getRandomHPTask().cancel();
            task.randomHPTask = null;
            sender.sendMessage(CC.translate("&a랜덤 체력 타이머가 종료되었습니다."));
        } else {
            sender.sendMessage(CC.translate("&c현재 타이머가 작동 중이지 않습니다."));
        }
    }

    @Command(names = {"randomhp reload"}, permission = "randomhp.admin")
    public void randomHPReload(CommandSender sender) {
        RandomHP.getInstance().reloadConfig();
        sender.sendMessage(CC.translate("&a[RandomHP] 플러그인이 리로드 되었습니다."));
    }

    @Command(names = {"randomhp set"}, permission = "randomhp.admin")
    public void randomHPSet(CommandSender sender, @Param(name="timer") int timer) {
        plugin.getConfig().set("TIMER", timer);
        plugin.saveConfig();
        sender.sendMessage(CC.translate("&a[RandomHP] 타이머를 " + timer + "초로 설정 하였습니다."));
    }
}
