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
                Location startLocation = p.getLocation().add(p.getLocation().getDirection().multiply(50)).add(0, 50, 0);
                Vector direction = new Vector(0, -1, 0);

                for (double d = 0; d < 10; d += 0.5) {
                    Location particleLocation = startLocation.clone().add(direction.clone().multiply(d));
                    p.getWorld().spawnParticle(Particle.FIREWORK, particleLocation, 0, 0, 0, 0, 0.1);
                }
                Location explosionLocation = startLocation.clone().add(direction.clone().multiply(10));
                p.getWorld().createExplosion(explosionLocation, 1f, true);
                p.sendMessage("流れ星を落としました");

            }

            if (args[0].equalsIgnoreCase("fireball")) {
                Player p = (Player) sender;
                p.launchProjectile(org.bukkit.entity.Fireball.class);
                p.sendMessage("ファイアーボールを発射しました");
            }

            if (args[0].equalsIgnoreCase("breath")) {
                Player p = (Player) sender;
                Location startLocation = p.getEyeLocation();
                Vector direction = startLocation.getDirection();

                for (double d = 0; d < 10; d += 0.1) {
                    Location particleLocation = startLocation.clone().add(direction.clone().multiply(d));
                    p.getWorld().spawnParticle(Particle.DRAGON_BREATH, particleLocation, 0, 0, 0, 0, 0.1);
                }

                Location explosionLocation = startLocation.clone().add(direction.clone().multiply(2));
                p.getWorld().createExplosion(explosionLocation, 1f, true);
                p.sendMessage("ドラゴンブレスを吐きました");
            }
        }
        return false;
    }

}
