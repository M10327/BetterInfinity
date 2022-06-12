package betterinfinity.betterinfinity.Handlers;

import betterinfinity.betterinfinity.BetterInfinity;
import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class CrossbowReloadHandler implements Listener {
    public CrossbowReloadHandler(BetterInfinity plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onCrossbowReload(EntityLoadCrossbowEvent event){
        if (event.getCrossbow() == null){
            return;
        }
        if (!(event.getEntity() instanceof Player player)){
            return;
        }
        if (event.getCrossbow().getItemMeta().hasEnchants()){
            if (event.getCrossbow().getItemMeta().getEnchantLevel(Enchantment.ARROW_INFINITE) >= 1){
                event.setConsumeItem(false);
                player.updateInventory();
            }
        }

    }
}

