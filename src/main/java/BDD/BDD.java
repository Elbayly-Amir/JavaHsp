package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
    private Connection cnx;

    public Connection getBDD() throws SQLException {
        this.cnx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user?serverTimezone=UTC"
                , "hspjava"
                , "FK@dAYuHV9AUx89J");
        return cnx;
    }
}

