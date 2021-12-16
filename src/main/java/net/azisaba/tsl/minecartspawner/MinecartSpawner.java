package net.azisaba.tsl.minecartspawner;

import net.azisaba.tsl.minecartspawner.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecartSpawner extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Spawn(),this);
        getServer().getPluginManager().registerEvents(new Despawn(),this);
    }
}
