package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD implements AutoCloseable {
    private Connection connection;

    // constructeur pour établir la connexion à la base de données
    public BDD() throws SQLException {
        // initialisation de la connexion
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hspjava", "hspjava", "FK@dAYuHV9AUx89J");
    }

    // méthode pour obtenir la connexion à la base de données
    public Connection getBDD() {
        return connection;
    }

    // implémentation de la méthode close() pour fermer la connexion à la base de données
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}
