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

import static main.Alias.languageSwitch;
import static main.database.AliasDB.*;

import static main.menus.Menu_JoinMenu.*;

public class Event_InventoryInteract implements Listener {

    @EventHandler
    public void inventoryInteract(InventoryClickEvent event) {

        if (event.getView().getTitle().equals(MENU_TITLE_TOWNMENU)) {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);

            ItemStack clicked = event.getCurrentItem();
            ItemMeta meta = clicked.getItemMeta();

            if (!(getUser(player.getName(), "town").equals("none"))) {
                player.sendMessage("Вы уже в городе!");
                return;
            }
            if (event.getCurrentItem() == null) return;
            if (meta == null || !meta.hasDisplayName()) return;
            if (clicked.getType() == Material.AIR) return;

            String town = ChatColor.stripColor(meta.getDisplayName());

            setUser(player.getName(), "town", town);
            setTown(town, "owner", player.getName());

            player.sendMessage("Вы выбрали:" + town);
        }



        if (event.getView().getTitle().equals(MENU_TITLE_JOINMENU)) {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            ItemStack clicked = event.getCurrentItem();
            ItemMeta meta = clicked.getItemMeta();

            // if (!(getUser(player.getName(), "town").equals("none"))) {
            // player.sendMessage("Вы уже в стране");
            // } else {
            if (event.getCurrentItem() == null) return;
            if (meta == null || !meta.hasDisplayName()) return;
            if (clicked.getType() == Material.AIR) return;
            String country = ChatColor.stripColor(meta.getDisplayName());



            // setUser(player.getName(), "town", country);
            //  setCountry(Alias.languageSwitch(country, "EN"), "owner", player.getName());
            player.sendMessage(ChatColor.GREEN + "[DEBUG] Вы выбрали страну: " + ChatColor.YELLOW + country);


            player.sendMessage(languageSwitch(country, "EN"));
            getInstance.initTowns(languageSwitch(country, "EN"));
            getInstance.createMenuTowns(languageSwitch(country, "EN"));

            player.closeInventory();
            player.openInventory(townMenu);
        }
        }


    }
