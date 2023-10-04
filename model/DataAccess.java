package model;
import java.sql.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {

    private Connection connection;

    public DataAccess(String url, String user, String password) throws SQLException {
    connection = (Connection) DriverManager.getConnection(url, user, password);
    System.out.println("Connexion à la base de données !"+url);
    }
}

