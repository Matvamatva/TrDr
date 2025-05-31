package main.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Menu_JoinMenu implements Listener {

    public static final Menu_JoinMenu getInstance = new Menu_JoinMenu();
    private static final int MENU_SIZE = 18;
    public static final String MENU_TITLE = ChatColor.GREEN + "Выбор страны";

    private final Map<String, Material> countries = new LinkedHashMap<>();
   // List<String> list = new ArrayList<>(Arrays.asList("банан", "яблоко", "апельсин"));
    public static Inventory countryMenu;
    public void initCountries() {
        countries.clear();

        countries.put("Япония", Material.RED_TERRACOTTA);
    }

    public void OpenMenu(Player player) {
            player.openInventory(countryMenu);
        //    getLogger().info("Меню не найдено. Класс: " + e.getClass() + " / " + "Error: " + e);

    }

    public void createMenu() {
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
            countryMenu.setItem(i, item);
        }
    }


}
