package org.example.plugin.plugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("player").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();


        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
        inventory.setItem(EquipmentSlot.HEAD, helmet);

        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        inventory.setItem(EquipmentSlot.CHEST, chestplate);

        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        inventory.setItem(EquipmentSlot.LEGS, leggings);

        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        inventory.setItem(EquipmentSlot.FEET, boots);

        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        inventory.setItem(EquipmentSlot.HAND, sword);

        ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        inventory.addItem(pickaxe);

        ItemStack shield = new ItemStack(Material.SHIELD);
        inventory.setItem(EquipmentSlot.OFF_HAND, shield);

        ItemStack chicken = new ItemStack(Material.COOKED_CHICKEN, 64);
        inventory.addItem(chicken);
    }
}
