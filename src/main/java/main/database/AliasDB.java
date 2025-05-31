package main.database;

import java.sql.SQLException;

import static org.bukkit.Bukkit.getLogger;

public class AliasDB extends DbConnect {
    public static String getUser(String nickname, String type) {
        // ArrayList<String> user = new ArrayList<String>();
        String query = "SELECT * FROM 'users' WHERE username = '" + nickname + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                //  for (int i = 1; true; i++) {
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
                // }
            } catch (SQLException e) {
                getLogger().info("Запрос getUser не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().info("Запрос getUser не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }
    public static String getTown(String town_name, String type){
        String query = "SELECT * FROM 'towns' WHERE name = '" + town_name + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                //  for (int i = 1; true; i++) {
                if (type.equalsIgnoreCase("id")) {
                    return String.valueOf(resSet.getInt("id"));
                } else if (type.equalsIgnoreCase("name")) {
                    return resSet.getString("name");
                } else if (type.equalsIgnoreCase("country")) {
                        return resSet.getString("country");
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
                // }
            } catch (SQLException e) {
                getLogger().info("Запрос getTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().info("Запрос getTown не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }
    public static String getCountry(String country_name, String type){
        String query = "SELECT * FROM 'country' WHERE name = '" + country_name + "'";
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                //  for (int i = 1; true; i++) {
                if (type.equalsIgnoreCase("id")) {
                    return String.valueOf(resSet.getInt("id"));
                } else if (type.equalsIgnoreCase("name")) {
                    return resSet.getString("name");
                } else if (type.equalsIgnoreCase("region")) {
                    return resSet.getString("region");
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
                // }
            } catch (SQLException e) {
                getLogger().info("Запрос getTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().info("Запрос getTown не удался. Класс: " + e.getClass() +  " / Error:" + e);
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
            } catch (SQLException e) {
                getLogger().info("Запрос getTown не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().info("Запрос getTown не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }






    public static String getRegionVault(String nickname) {
        String region = getCountry(getTown(getUser(nickname, "town"),"country"), "region");
        if (region.equalsIgnoreCase("Europa")){
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

    //  --------сетЮзер--------
    public static void setUser(String nickname, String type, String value) {
        String query = "";
        if (type.equals("newuser")) {
            query = String.format("INSERT INTO 'users' ('username', 'UUID') VALUES ('%s', '%s')", nickname, value);
        } else {
            query = String.format("UPDATE 'users' SET %s = %s WHERE username = '%s'", type, value, nickname);
        }
        if (conn != null) {
            try {
                statmt.executeUpdate(query);
            } catch (SQLException e) {
                getLogger().info("Запрос setUser не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().info("Запрос setUser не удался. Класс: " + e.getClass() + " / Error:" + e);
            }
        }
    }
}
