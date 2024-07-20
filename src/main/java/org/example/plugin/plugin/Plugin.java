package org.example.plugin.plugin;

import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("player").setExecutor(new Commands());
        PlayerInventory inventory = getServer().getPlayer("player").getInventory();
        getServer().getPlayer("player").getInventory();

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

        ItemStack shield = new ItemStack(Material.SHIELD);
        inventory.setItem(EquipmentSlot.OFF_HAND, shield);

        ItemStack beaf = new ItemStack(Material.COOKED_BEEF, 64);
        inventory.addItem(beaf);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
