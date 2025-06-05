package main.menus;

import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static main.database.AliasDB.*;
import static main.Alias.*;
import main.main;
import main.BackComparator;

import java.util.*;

public class Menu_JoinMenu {

    public static final Menu_JoinMenu getInstance = new Menu_JoinMenu();
    public static final String MENU_TITLE_JOINMENU = ChatColor.GREEN + "Выбор страны";
    public static final String MENU_TITLE_TOWNMENU = ChatColor.GREEN + "Выбор города";

    private final Map<String, Material> countries = new LinkedHashMap<>();
    private final Map<String, Material> towns = new LinkedHashMap<>();
    public static Inventory countryMenu;
    public static Inventory townMenu;



    public void initCountries() {
        countries.clear();
        for (int i = 1; true; i++) {
            String country = getCountryName(String.valueOf(i));
           // main.getInstance().getLogger().info(name);
            if (country.equals("null")) {break;}
           // if (getCountry(country, "owner").equals("none")) {
               // main.getInstance().getLogger().info(country);
                countries.put(languageSwitch(country, "RU"), Material.BLACK_BANNER);
            }
    }



    public void initTowns(String name) {
        towns.clear();
        ArrayList<String> temp = getTowns(name);
        main.getInstance().getLogger().info(temp.toString());
        for (int i = 0; true; i++) {
            String town;
            try {
                town = temp.get(i).replace(" ", "");
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            if (getTown(town, "owner").equals("none")) {
                towns.put(town, Material.BLACK_BANNER);
            }
        }
    }

    public void OpenMenu(Player player) {
            player.openInventory(countryMenu);
        //    getLogger().info("Меню не найдено. Класс: " + e.getClass() + " / " + "Error: " + e);
    }

    public void createMenuCountry() {
        initCountries();
        countryMenu = Bukkit.createInventory(null, 18, MENU_TITLE_JOINMENU);
        List<String> keys = new ArrayList<>(countries.keySet());
        Collections.sort(keys, new BackComparator());

        for (int i = 0; i < countries.size(); i++) {

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



    public void createMenuTowns(String name) {
        townMenu = Bukkit.createInventory(null, 18, MENU_TITLE_TOWNMENU);
        List<String> keys = new ArrayList<>(towns.keySet());
        Collections.sort(keys, new BackComparator());

        for (int i = 0; i < towns.size(); i++) {
            String town = keys.get(i);
            Material mat = towns.get(town);
            ItemStack item = new ItemStack(mat);
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(languageSwitch(town, "RU"));
                meta.setLore(Collections.singletonList(ChatColor.GRAY + "Нажмите, чтобы выбрать город"));
                item.setItemMeta(meta);
            }
            townMenu.setItem(i, item);
        }
    }
}
