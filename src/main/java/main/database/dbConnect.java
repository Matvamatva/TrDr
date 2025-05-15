package main.database;

import java.sql.*;
import java.util.ArrayList;


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
        try {
            statmt = conn.createStatement();
            statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'username' TEXT NOT NULL, 'UUID' INTEGER NOT NULL);");

            getLogger().info("Таблица users создана или уже существует.");
        } catch (SQLException e) {
            getLogger().info("Создание таблицы users не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
        }


    }

    public static String getUser(String query, String type) {
       // ArrayList<String> user = new ArrayList<String>();

        try {
            resSet = statmt.executeQuery(query);
            if (type.equalsIgnoreCase("id")) {
                return String.valueOf(resSet.getInt("id"));
            } else if (type.equalsIgnoreCase("username")) {
                return resSet.getString("username");
            } else if (type.equalsIgnoreCase("UUID")) {
                return resSet.getString("UUID");
            }
        } catch (SQLException e) {
            getLogger().info("Запрос ResultSet не удался. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
        }
        return "";
    }

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

    // --------Закрытие--------
    public static void CloseDB() {
        if (conn != null) {
            try {
                conn.close();
                statmt.close();
                //resSet.close();
                getLogger().info("Соединения закрыты");
            } catch (SQLException e) {
                getLogger().info("Закрыть соединение с ДБ не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            }
        }
    }



}

