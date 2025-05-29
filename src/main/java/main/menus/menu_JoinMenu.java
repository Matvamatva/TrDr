package main.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static org.bukkit.Bukkit.getLogger;

public class menu_JoinMenu implements Listener {

    public static final menu_JoinMenu getInstance = new menu_JoinMenu();
    private static final int MENU_SIZE = 18;
    public static final String MENU_TITLE = ChatColor.GREEN + "Выбор страны";

    private final Map<String, Material> countries = new LinkedHashMap<>();
    public static Inventory countryMenu;
    public void InitCountries() {
        countries.clear();
        countries.put("Япония", Material.RED_TERRACOTTA);
        countries.put("Франция", Material.BLUE_WOOL);
        countries.put("Бразилия", Material.GREEN_WOOL);
        countries.put("Италия", Material.WHITE_WOOL);
        countries.put("Канада", Material.RED_BANNER);
        countries.put("Австралия", Material.BLUE_BANNER);
        countries.put("Индия", Material.ORANGE_WOOL);
        countries.put("Германия", Material.BLACK_WOOL);
        countries.put("Мексика", Material.LIME_WOOL);
        countries.put("Россия", Material.WHITE_BANNER);
    }

    public void OpenMenu(Player player) {
            player.sendMessage("DEBUG1");
            player.openInventory(countryMenu);
            player.sendMessage("DEBUG2");
        //    getLogger().info("Меню не найдено. Класс: " + e.getClass() + " / " + "Error: " + e);

    }

    public void CreateMenu() {
        countryMenu = Bukkit.createInventory(null, MENU_SIZE, MENU_TITLE);
        List<String> keys = new ArrayList<>(countries.keySet());
        Collections.shuffle(keys);

        for (int i = 0; i < 10; i++) {
            String country = keys.get(i);
            Material mat = countries.get(country);
            ItemStack item = new ItemStack(mat);
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.YELLOW + country);
                meta.setLore(Collections.singletonList(ChatColor.GRAY + "Нажмите, чтобы выбрать страну"));
                item.setItemMeta(meta);
            }
            getLogger().info("Создан предмет: " + i + " / " + country);
            countryMenu.setItem(i, item);
        }
    }


}
