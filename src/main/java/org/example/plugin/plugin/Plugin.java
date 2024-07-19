package org.example.plugin.plugin;

import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("player").setExecutor(new Commands());
        getServer().getInventory().setItem(EquipmentSlot.HAND, new ItemStack(Material.NETHERITE_SWORD));
        getServer().getInventory().setItem(EquipmentSlot.OFF_HAND, new ItemStack(Material.SHIELD));
        getServer().getInventory().setItem(EquipmentSlot.CHEST, new ItemStack(Material.NETHERITE_CHESTPLATE));
        getServer().getInventory().setItem(EquipmentSlot.LEGS, new ItemStack(Material.NETHERITE_LEGGINGS));
        getServer().getInventory().setItem(EquipmentSlot.FEET, new ItemStack(Material.NETHERITE_BOOTS));
        getServer().getInventory().setItem(EquipmentSlot.HEAD, new ItemStack(Material.NETHERITE_HELMET));
        getServer().getInventory().setInventory(new ItemStack(Material.COOKED_CHICKEN, 64));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
