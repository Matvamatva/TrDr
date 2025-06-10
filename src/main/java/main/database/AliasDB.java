package main.database;

import main.main;
import org.bukkit.entity.*;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class AliasDB extends DbConnect {



    public static String getUser(String nickname, String type) {
        String query = "SELECT * FROM 'users' WHERE username = '" + nickname + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                if (type.equalsIgnoreCase("id")) {
                    return String.valueOf(resSet.getInt("id"));
                } else if (type.equalsIgnoreCase("username")) {
                    return resSet.getString("username");
                } else if (type.equalsIgnoreCase("UUID")) {
                    return resSet.getString("UUID");
                } else if (
                        type.equalsIgnoreCase("PESO") ||
                                type.equalsIgnoreCase("EURO") ||
                                type.equalsIgnoreCase("REAL") ||
                                type.equalsIgnoreCase("YUAN") ||
                                type.equalsIgnoreCase("FRANK") ||
                                type.equalsIgnoreCase("RUPEE")
                ) {
                    return resSet.getString(type);
                } else if (type.equalsIgnoreCase("town")) {
                    return resSet.getString("town");
                }
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос getUser не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос getUser не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }

    public static String getPragma() {
        String journalMode = null;
        try {
            String query = "PRAGMA journal_mode;";
            resSet = statmt.executeQuery(query);
            if (resSet.next()) {
                journalMode = resSet.getString(1);
            }
            resSet.close();
        } catch (SQLException e) {
            getLogger().severe("Запрос getPragma не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
        }
        return journalMode;
    }

    public static String getTown(String town_name, String type) {
        String query = "SELECT * FROM 'towns' WHERE name = '" + town_name + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                if (type.equalsIgnoreCase("id")) {
                    return String.valueOf(resSet.getInt("id"));
                } else if (type.equalsIgnoreCase("name")) {
                    return resSet.getString("name");
                } else if (type.equalsIgnoreCase("country")) {
                    return resSet.getString("country");
                } else if (type.equalsIgnoreCase("owner")) {
                    return resSet.getString("owner");
                } else if (
                        type.equalsIgnoreCase("PESO") ||
                                type.equalsIgnoreCase("EURO") ||
                                type.equalsIgnoreCase("REAL") ||
                                type.equalsIgnoreCase("YUAN") ||
                                type.equalsIgnoreCase("FRANK") ||
                                type.equalsIgnoreCase("RUPEE")
                ) {
                    return resSet.getString(type);
                }
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос getTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос getTown не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }

    public static String getCountry(String country_name, String type) {
        String query = "SELECT * FROM 'country' WHERE name = '" + country_name + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                if (type.equalsIgnoreCase("id")) {
                    return String.valueOf(resSet.getInt("id"));
                } else if (type.equalsIgnoreCase("name")) {
                    return resSet.getString("name");
                } else if (type.equalsIgnoreCase("region")) {
                    return resSet.getString("region");
                } else if (type.equalsIgnoreCase("owner")) {
                    return resSet.getString("owner");
                } else if (
                        type.equalsIgnoreCase("PESO") ||
                                type.equalsIgnoreCase("EURO") ||
                                type.equalsIgnoreCase("REAL") ||
                                type.equalsIgnoreCase("YUAN") ||
                                type.equalsIgnoreCase("FRANK") ||
                                type.equalsIgnoreCase("RUPEE")
                ) {
                    return resSet.getString(type);
                }
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос getTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос getTown не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }

    public static String getCountryName (String id) {
        String query = "SELECT * FROM 'country' WHERE id = '" + id + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                if (String.valueOf(resSet.getString("name")) != null) return String.valueOf(resSet.getString("name"));
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос getTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос getTown не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }

    public static String getRegionVault(String nickname) {
        String region = getCountry(getTown(getUser(nickname, "town"),"country"), "region");
        if (region.equalsIgnoreCase("Europa")) {
            return "EURO";
        } else if (region.equalsIgnoreCase("Asia")) {
            return "YUAN";
        } else if (region.equalsIgnoreCase("Africa")) {
            return "FRANK";
        } else if (region.equalsIgnoreCase("Oceania")) {
            return "RUPEE";
        } else if (region.equalsIgnoreCase("StAmerica")) {
            return "REAL";
        } else if (region.equalsIgnoreCase("NtAmerica")) {
            return "PESO";
        }
        return "";
    }

    public static void setUser(String nickname, String type, String value) {
        String query = "";
        if (type.equals("newuser")) {
            query = String.format("INSERT INTO 'users' ('username', 'UUID') VALUES ('%s', '%s')", nickname, value);
        } else {
            query = String.format("UPDATE 'users' SET '%s' = '%s' WHERE username = '%s'", type, value, nickname);
        }
        if (conn != null) {
            try {
                statmt.executeUpdate(query);
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос setUser не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос setUser не удался. Класс: " + e.getClass() + " / Error:" + e);
            }
        }
    }

    public static void setTown(String name, String type, String value) {
        String query = "";
        if (type.equals("newtown")) {
            query = String.format("INSERT INTO 'towns' ('name', 'country') VALUES ('%s', '%s')", name, value);
        } else {
            query = String.format("UPDATE 'towns' SET '%s' = '%s' WHERE name = '%s'", type, value, name);
        }
        if (conn != null) {
            try {
                statmt.executeUpdate(query);
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос setTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос setTown не удался. Класс: " + e.getClass() + " / Error:" + e);
            }
        }
    }

    public static void setCountry(String name, String type, String value) {
        String query = "";
        if (type.equals("newcountry")) {
            query = String.format("INSERT INTO 'country' ('name', 'region') VALUES ('%s', '%s')", name, value);
        } else {
            query = String.format("UPDATE 'country' SET '%s' = '%s' WHERE name = '%s'", type, value, name);
        }
        if (conn != null) {
            try {
                statmt.executeUpdate(query);
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос setCountry не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос setCountry не удался. Класс: " + e.getClass() + " / Error:" + e);
            }
        }
    }

    public static ArrayList<String> getTowns (String name) {
        String query = String.format("SELECT * FROM 'country' WHERE name = '%s'", name);
        ArrayList<String> towns = null;
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                String replace = resSet.getString("towns").replace("[","");
                String replace1 = replace.replace("]","");
                towns = new ArrayList<>(Arrays.asList(replace1.split(",")));
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос getTowns не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос getTowns не удался. Класс: " + e.getClass() + " / Error:" + e);
            }
        }
        return towns;
    }

    public static void setTowns (ArrayList<String> value, String name) {

       String query = String.format("UPDATE 'country' SET 'towns' = '%s' WHERE name = '%s'", value.toString(), name);
        if (conn != null) try {
            statmt.executeUpdate(query);
            resSet.close();
        } catch (SQLException e) {
            getLogger().severe("Запрос setTowns не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
        } catch (NullPointerException e) {
            getLogger().severe("Запрос setTowns не удался. Класс: " + e.getClass() + " / Error:" + e);
        }
    }

    public static Double getCurrencyCoff (String name) {
        String query = "SELECT * FROM 'coefficient_exchange' WHERE  = '" + name + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                if (String.valueOf(resSet.getFloat("coff")) != null) {
                    return Double.parseDouble(String.valueOf(resSet.getFloat("coff")));
                }
                resSet.close();
            } catch (SQLException e) {
                getLogger().severe("Запрос getCurrencyCoff не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().severe("Запрос getCurrencyCoff не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return null;
    }
}
