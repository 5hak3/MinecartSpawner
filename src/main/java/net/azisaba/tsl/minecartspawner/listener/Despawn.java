package net.azisaba.tsl.minecartspawner.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.List;

public class Despawn implements Listener {
    @EventHandler
    public void onDismount(EntityDismountEvent event){
        // Dismoutしたら削除するリスト
        List<EntityType> dismountor = List.of(
                EntityType.MINECART,
                EntityType.BOAT
        );

        // リストにDismountされたものが含まれていたら処理
        if (dismountor.contains(event.getDismounted().getType())) {
            // Dismountするときに1つ上の座標にTPする
            event.getEntity().teleport(event.getEntity().getLocation().add(0,1,0));
            event.getDismounted().remove();
        }
    }
}
