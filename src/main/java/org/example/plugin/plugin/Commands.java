package org.example.plugin.plugin;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 0) {

            if (args[0].equalsIgnoreCase("health")) {
                Player p = (Player) sender;
                double health = Integer.parseInt(args[1]);
                p.setHealth(health);
                p.sendMessage("あなたのHPを" + health + "に設定しました");
            }

            if (args[0].equalsIgnoreCase("food")) {
                Player p = (Player) sender;
                int food = Integer.parseInt(args[1]);
                p.setFoodLevel(food);
                p.sendMessage("あなたの空腹度を" + food + "に設定しました");
            }

            if (args[0].equalsIgnoreCase("fly")) {
                Player p = (Player) sender;
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage("飛行を無効にしました");
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage("飛行を有効にしました");
                }
            }

            if (args[0].equalsIgnoreCase("clear")) {
                Player p = (Player) sender;
                p.getInventory().clear();
                p.sendMessage("インベントリをクリアしました");
            }

            if (args[0].equalsIgnoreCase("shootingstar")) {
                Player p = (Player) sender;
                Location location = p.getEyeLocation().add(p.getLocation().getDirection().multiply(2));
                p.getWorld().createExplosion(p.getLocation(), 1f, true);
                p.getWorld().spawnParticle(Particle.FIREWORK, p.getLocation(), 100, 0.5, 0.5, 0.5, 0.1);
                p.sendMessage("流れ星を落としました");

            }

            if (args[0].equalsIgnoreCase("fireball")) {
                Player p = (Player) sender;
                p.launchProjectile(org.bukkit.entity.Fireball.class);
                p.sendMessage("ファイアーボールを発射しました");
            }

            if (args[0].equalsIgnoreCase("breath")) {
                Player p = (Player) sender;
                Location location = p.getEyeLocation().add(p.getLocation().getDirection().multiply(2));
                p.getWorld().createExplosion(p.getLocation(), 1f, true);
                p.getWorld().spawnParticle(org.bukkit.Particle.DRAGON_BREATH, location, 100, 0.5, 0.5, 0.5, 0.1);
                p.sendMessage("ドラゴンブレスを吐きました");
            }
        }
        return false;
    }

}
