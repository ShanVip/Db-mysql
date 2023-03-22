package com.company;
import java.sql.*;

public class DB {
    private  final String HOST = "localhost";
    private  final String PORT = "6033";
    private  final String DB_NAME = "app_db";
    private  final String LOGIN = "db_user";
    private  final String PASS = "db_user_pass";


    private Connection dbConn = null;
        private Connection getDbConnection() throws ClassNotFoundException, SQLException {
            String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
            Class.forName("com.mysql.cj.jdbc.Driver");

            dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
            return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }


    //Создание колон в БД
    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))" +
                " ENGINE=MYISAM";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }
//
//    //Внесение данных в колоны в БД
//    public void insertArticle(String title, String text, String date, String avtor) throws SQLException, ClassNotFoundException{
//        String sql ="INSERT INTO `articles` (title, text, date, avtor) VALUES (?,?,?,?)";
//
//        PreparedStatement prSt = getDbConnetion().prepareStatement(sql);
//        prSt.setString(1, title);
//        prSt.setString(2, text);
//        prSt.setString(3, date);
//        prSt.setString(4, avtor);
//
//        prSt.executeUpdate();
//    }
//
//    //Получение данных с БД
    public void getArticles(String table) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM " + table + " WHERE `title`  LIKE '%post%' OR `id` = 4 ORDER BY `id` ASC LIMIT 1 OFFSET 1";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while(res.next()){
            System.out.println(res.getString("title"));
        }
    }
//
//    //Обновление БД
//    public void updateArticles() throws SQLException, ClassNotFoundException{
//        String sql = "UPDATE `articles` SET `title` = ? WHERE `id` = 2";
//        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
//        prSt.setString(1, "New Update");
//
//        prSt.executeUpdate();
//    }
//
//    //Удалние БД или данных
//    public void deleteSomething() throws SQLException, ClassNotFoundException{
//        //String sql = "DELETE FROM `articles` WHERE `id` = 3 "; //Удалить данные с таблицы
//        String sql = "DROP TABLE `articles`"; //Удалить саму таблицу
//
//        Statement statement = getDbConnection().createStatement();
//        statement.executeUpdate(sql);
//    }




}
