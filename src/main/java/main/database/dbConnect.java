package main.database;

import main.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbConnect {
    private static String DBaddress = "";
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() {
        try {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DBaddress);

            main.getInstance().getLogger().info("База подключена");
        } catch (SQLException e) {
            main.getInstance().getLogger().info("Подключение к ДБ не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error: " + e);
        } catch (ClassNotFoundException e) {
            main.getInstance().getLogger().info("Подключение к ДБ не удалось. Класс: " + e.getClass() + " / Error: " + e);
        }
    }

    // --------Создание таблицы--------
    public static void CreateDB() {
        try {
            statmt = conn.createStatement();
            statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

            System.out.println("Таблица users создана или уже существует.");
        } catch (SQLException e) {
            main.getInstance().getLogger().info("Создание таблицы users не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
        }

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
                resSet.close();
                main.getInstance().getLogger().info("Соединения закрыты");
            } catch (SQLException e) {
                main.getInstance().getLogger().info("Закрыть соединение с ДБ не удалось. Класс: " + e.getClass() + " / Error code: " + e.getErrorCode() + " / Error:" + e);
            }

        }
    }

}

