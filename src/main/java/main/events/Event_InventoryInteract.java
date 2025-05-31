package main.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static main.menus.Menu_JoinMenu.MENU_TITLE;
import static main.menus.Menu_JoinMenu.countryMenu;

public class Event_InventoryInteract implements Listener {

    @EventHandler
    public void inventoryInteract(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(MENU_TITLE)) return;
        event.setCancelled(true);

        if (event.getCurrentItem() == null) return;
        ItemStack clicked = event.getCurrentItem();
        ItemMeta meta = clicked.getItemMeta();
        if (meta == null || !meta.hasDisplayName()) return;

        String country = ChatColor.stripColor(meta.getDisplayName());

        Player player = (Player) event.getWhoClicked();

        if (clicked.getType() == Material.AIR) return;

        player.sendMessage(ChatColor.GREEN + "Вы выбрали страну: " + ChatColor.YELLOW + country);

        countryMenu.setItem(event.getSlot(), null);
    }
}
