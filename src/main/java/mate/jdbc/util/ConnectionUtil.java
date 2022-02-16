package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION_LINK = "jdbc:mysql://localhost:3306/taxi_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver for MySQL", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", USER);
            dbProperties.put("password", PASSWORD);
            return DriverManager.getConnection(CONNECTION_LINK, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB", e);
        }
    }
}