package main.database;

import java.sql.*;
import main.main;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getLogger;


public class dbConnect {
    private static String DBaddress = "jdbc:sqlite:plugins/TrDr/Users.db";
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() {
        try {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DBaddress);
            getLogger().info("База подключена");
        } catch (SQLException e) {
            getLogger().info("Подключение к ДБ не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error: " + e);
        } catch (ClassNotFoundException e) {
            getLogger().info("Подключение к ДБ не удалось. Класс: " + e.getClass() + " / Error: " + e);
        }
        CreateDB();
    }

    // --------Создание таблицы--------
    private static void CreateDB() {
        if (conn != null) {
            try {
                statmt = conn.createStatement();
                statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'username' TEXT NOT NULL, 'UUID' TEXT NOT NULL);");
                getLogger().info("Таблица users создана или уже существует.");
            } catch (SQLException e) {
                getLogger().info("Создание таблицы users не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            }
        }
    }
   //  --------гетЮзер--------
    public static String getUser(String query, String type) {
        // ArrayList<String> user = new ArrayList<String>();
        if (conn != null) {
            try {
                resSet = statmt.executeQuery(query);
                for (int i = 1; i <= 10; i++) {
                    if (type.equalsIgnoreCase("id")) {
                        return String.valueOf(resSet.getInt("id"));
                    } else if (type.equalsIgnoreCase("username")) {
                        return resSet.getString("username");
                    } else if (type.equalsIgnoreCase("UUID")) {
                        return resSet.getString("UUID");
                    }
                }
            } catch (SQLException e) {
                getLogger().info("Запрос getUser не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            } catch (NullPointerException e) {
                getLogger().info("Запрос getUser не удался. Класс: " + e.getClass() +  " / Error:" + e);
            }
        }
        return "";
    }

    //  --------сетЮзер--------
    public static void setUser(String query) {
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

    // --------Закрытие--------
    public static void CloseDB() {
        if (conn != null) {
            try {
                conn.close();
                statmt.close();
                resSet.close();
                getLogger().info("Соединения закрыты");
            } catch (SQLException e) {
                getLogger().info("Закрыть соединение с ДБ не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            }
        }
    }

    public static String escapeSql(String input, Player player) {
        if (input == null) {
            return null;
        }
        if (
                input.contains("'") ||
                input.contains("\\") ||
                input.contains("\\n") ||
                input.contains("\\'") ||
                input.contains("'\\") ||
                input.contains("--")
        ) {
            player.kickPlayer("Вы используете запрещённый символ в нике");
            return null;
        } else {
            return input;
        }
    }
}
/*


   /*  --------Заполнение таблицы--------
   public static void WriteDB() throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");

        System.out.println("Таблица заполнена");
    } */

// -------- Вывод таблицы--------
   /* public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  phone = resSet.getString("phone");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    } */


 /*   public static String escapeSql(String x, boolean escapeDoubleQuotes) {
        int stringLength = x.length();
        StringBuilder sBuilder = new StringBuilder(x.length() * 11/10);
        for (int i = 0; i < stringLength; ++i) {
            char c = x.charAt(i);
            switch (c) {
                case 0: // Must be escaped for 'mysql'
                    sBuilder.append('\\');
                    sBuilder.append('0');
                    break;
                case '\n': // Must be escaped for logs
                    sBuilder.append('\\');
                    sBuilder.append('n');
                    break;
                case '\r':
                    sBuilder.append('\\');
                    sBuilder.append('r');
                    break;
                case '\\':
                    sBuilder.append('\\');
                    sBuilder.append('\\');
                    break;
                case '\'':
                    sBuilder.append('\\');
                    sBuilder.append('\'');
                    break;
                case '"': // Better safe than sorry
                    if (escapeDoubleQuotes) {
                        sBuilder.append('\\');
                    }
                    sBuilder.append('"');
                    break;
                case '\032': // This gives problems on Win32
                    sBuilder.append('\\');
                    sBuilder.append('Z');
                    break;
                case '\u00a5':
                case '\u20a9':
                    // escape characters interpreted as backslash by mysql
                    // fall through
                default:
                    sBuilder.append(c);
            }
        }
        return sBuilder.toString();
    } */
