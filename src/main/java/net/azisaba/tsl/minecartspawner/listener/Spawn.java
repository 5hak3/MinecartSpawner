package net.azisaba.tsl.minecartspawner.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import static org.bukkit.Material.*;

public class Spawn implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        // eventが右クリックで対象がRAILSの時だけ反応
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK &&
            Tag.RAILS.isTagged(event.getClickedBlock().getType())
        ) {
            // 空手，ツール類以外は処理しない
            if (event.getItem()!=null) {
                switch (event.getItem().getType()) {
                    case AIR:
                    case WOODEN_AXE:
                    case WOODEN_HOE:
                    case WOODEN_PICKAXE:
                    case WOODEN_SHOVEL:
                    case WOODEN_SWORD:
                    case STONE_AXE:
                    case STONE_HOE:
                    case STONE_PICKAXE:
                    case STONE_SHOVEL:
                    case STONE_SWORD:
                    case IRON_AXE:
                    case IRON_HOE:
                    case IRON_PICKAXE:
                    case IRON_SHOVEL:
                    case IRON_SWORD:
                    case GOLDEN_AXE:
                    case GOLDEN_HOE:
                    case GOLDEN_PICKAXE:
                    case GOLDEN_SHOVEL:
                    case GOLDEN_SWORD:
                    case DIAMOND_AXE:
                    case DIAMOND_HOE:
                    case DIAMOND_PICKAXE:
                    case DIAMOND_SHOVEL:
                    case DIAMOND_SWORD:
                    case NETHERITE_AXE:
                    case NETHERITE_HOE:
                    case NETHERITE_PICKAXE:
                    case NETHERITE_SHOVEL:
                    case NETHERITE_SWORD:
                        break;
                    default:
                        return;
                }
            }
            World world = event.getClickedBlock().getWorld();
            Location loc = event.getClickedBlock().getLocation();
            // ブロックが上の座標にある場合も処理しない
            if (!loc.add(0,1,0).getBlock().isEmpty()) return;
            // トロッコがその座標+-1以内にある場合も処理しない
            for(Entity e: loc.getChunk().getEntities()){
                if (e.getType() == EntityType.MINECART &&
                    (e.getLocation().getX()-loc.getX() < 1 && e.getLocation().getX()-loc.getX()>-1) &&
                    (e.getLocation().getY()-loc.getY() < 1 && e.getLocation().getY()-loc.getY()>-1) &&
                    (e.getLocation().getZ()-loc.getZ() < 1 && e.getLocation().getZ()-loc.getZ()>-1)
                ) return;
            }
            world.spawnEntity(loc, EntityType.MINECART);
        }
    }
}
