package betterinfinity.betterinfinity.Handlers;

import betterinfinity.betterinfinity.BetterInfinity;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.Objects;

public class BowFireHandler implements Listener {
    public BowFireHandler(BetterInfinity plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBowFire(EntityShootBowEvent event){
        if (event.getBow() == null){
            return;
        }
        if (!(event.getEntity() instanceof Player player)){
            return;
        }

        // bow infinity
        if (event.getBow().getType().equals(Material.BOW)){
            if (event.getBow().getItemMeta().hasEnchants()) {
                if (event.getBow().getItemMeta().getEnchantLevel(Enchantment.ARROW_INFINITE) >= 1) {
                    event.setConsumeItem(false);
                    player.updateInventory();
                }
            }
        }

        // crossbow
        if (event.getBow().getType().equals(Material.CROSSBOW)){
            NamespacedKey key = new NamespacedKey(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("BetterInfinity")), "our-custom-key");
            if (event.getBow().getItemMeta().hasEnchants()){
                if (event.getBow().getItemMeta().getEnchantLevel(Enchantment.ARROW_INFINITE) >= 1){
                    NBTEditor.set(event.getProjectile(), 0, "pickup");
                }
            }
        }
    }
}
