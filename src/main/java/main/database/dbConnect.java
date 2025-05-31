package main.database;

import java.io.IOException;
import java.sql.*;
import main.main;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getLogger;
import java.nio.file.*;

public class dbConnect {
    private static String DBaddress = "jdbc:sqlite:plugins/TrDr/Users.db";
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() {
        Path workPath = Paths.get("./plugins/TrDr");
        if (!(Files.exists(workPath))) {
            try {
                Files.createDirectories(workPath);
            } catch (IOException e) {
                getLogger().info("Не удалось создать папку." + e);
            }
        }
        try {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DBaddress);
            getLogger().info("База данных подключена");
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
                statmt.execute("CREATE TABLE " +
                        "if not exists 'users' " +
                        "(" +
                        "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "'username' TEXT NOT NULL," +
                        "'UUID' TEXT NOT NULL," +
                        "'town' TEXT DEFAULT 'none'," +
                        "'country_perm' TEXT DEFAULT 'none'," +
                        "'PESO' INTEGER DEFAULT 0, " +
                        "'EURO' INTEGER DEFAULT 0," +
                        "'REAL' INTEGER DEFAULT 0," +
                        "'YUAN' INTEGER DEFAULT 0," +
                        "'FRANK' INTEGER DEFAULT 0," +
                        "'RUPEE' INTEGER DEFAULT 0" +
                        ")");
                Thread.sleep(100);
                statmt.execute("CREATE TABLE " +
                        "if not exists 'country' " +
                        "(" +
                        "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "'name' TEXT NOT NULL," +
                        "'region' TEXT NOT NULL," +
                        "'owner' TEXT DEFAULT 'none'," +
                        "'member_number' INTEGER DEFAULT 0," +
                        "'alliance' TEXT DEFAULT 'none'," +
                        "'capital' TEXT DEFAULT 'none'," +
                        "'PESO' INTEGER DEFAULT 0, " +
                        "'EURO' INTEGER DEFAULT 0," +
                        "'REAL' INTEGER DEFAULT 0," +
                        "'YUAN' INTEGER DEFAULT 0," +
                        "'FRANK' INTEGER DEFAULT 0," +
                        "'RUPEE' INTEGER DEFAULT 0," +
                        "'dominated' TEXT DEFAULT 'none'," +
                        "'point_influence' INTEGER DEFAULT 0" +
                        ")");
                Thread.sleep(100);
                statmt.execute("CREATE TABLE " +
                        "if not exists 'towns' " +
                        "(" +
                        "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "'name' TEXT NOT NULL," +
                        "'country' TEXT NOT NULL," +
                        "'owner' TEXT DEFAULT 'none'," +
                        "'member_number' INTEGER DEFAULT 0," +
                        "'PESO' INTEGER DEFAULT 0, " +
                        "'EURO' INTEGER DEFAULT 0," +
                        "'REAL' INTEGER DEFAULT 0," +
                        "'YUAN' INTEGER DEFAULT 0," +
                        "'FRANK' INTEGER DEFAULT 0," +
                        "'RUPEE' INTEGER DEFAULT 0," +
                        "'hasOffice' TEXT DEFAULT 'none'," +
                        "'hasBank' TEXT DEFAULT 'none'," +
                        "'hasFactory' TEXT DEFAULT 'none'," +
                        "'hasCourt' TEXT DEFAULT 'none'," +
                        "'dominated' TEXT DEFAULT 'none'" +
                        ")");
                Thread.sleep(100);
                statmt.execute("CREATE TABLE " +
                        "if not exists 'order' " +
                        "(" +
                        "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "'name' TEXT NOT NULL," +
                        "'town' TEXT NOT NULL," +
                        "'type' TEXT NOT NULL," +
                        "'owner' TEXT DEFAULT 'none'," +
                        "'price' INTEGER DEFAULT 0," +
                        "'one_price' INTEGER DEFAULT 0," +
                        "'descriprion' TEXT DEFAULT '-'" +
                        ")");
                Thread.sleep(100);
                statmt.execute("CREATE TABLE " +
                        "if not exists 'relations' " +
                        "(" +
                        "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "'country1' TEXT DEFAULT 'none'," +
                        "'country2' TEXT DEFAULT 'none'," +
                        "'type' TEXT DEFAULT 'none'," +
                        "'point' INTEGER DEFAULT 0" +
                        ")");
                getLogger().info("Таблицы созданы или уже существуют.");
            } catch (SQLException | InterruptedException e) {
                getLogger().info("Создание таблиц не удалось. Класс: " + e.getClass() + " / Error code: " + " / Error:" + e);
            }
        }
    }
   //  --------гетЮзер--------

    // --------Закрытие--------
    public static void CloseDB() {
        if (conn != null) {
            try {
                conn.close();
                statmt.close();
               // resSet.close();
                getLogger().info("Соединения закрыты");
            } catch (SQLException e) {
                getLogger().info("Закрыть соединение с ДБ не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            }
        }
    }

    public static String escapeSql(Player player) {
        String input = player.getName();
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
