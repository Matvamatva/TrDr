package main.events;

import main.Alias;
import main.menus.Menu_JoinMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static main.database.AliasDB.*;

import static main.menus.Menu_JoinMenu.*;

public class Event_InventoryInteract implements Listener {

    @EventHandler
    public void inventoryInteract(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(MENU_TITLE_JOINMENU)) return;
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        ItemStack clicked = event.getCurrentItem();
        ItemMeta meta = clicked.getItemMeta();

        if (!(getUser(player.getName(), "town").equals("none"))) {
            player.sendMessage("Вы уже в стране");
        } else {
            if (event.getCurrentItem() == null) return;
            if (meta == null || !meta.hasDisplayName()) return;

            String country = ChatColor.stripColor(meta.getDisplayName());

            if (clicked.getType() == Material.AIR) return;

            setUser(player.getName(), "town", country);
            setCountry(Alias.languageSwitch(country, "EN"), "owner", player.getName());
            player.sendMessage(Alias.languageSwitch(country, "EN"));
            player.sendMessage(ChatColor.GREEN + "[DEBUG] Вы выбрали страну: " + ChatColor.YELLOW + country);

            Menu_JoinMenu menuJoinMenu = new Menu_JoinMenu();
            menuJoinMenu.initCountries();
            menuJoinMenu.createMenu();
        }
        player.closeInventory();
    }
}
