package personnage;

import java.sql.*;

public class ConnexionBDD {

    // Méthode qui lance la connexion à la BDD (A rappeler quand on veut faire une requête sur la BDD)
    public static Connection ouvrir() {

        // Procédure levant une exception en cas de problème de connexion (mot de passe invalide...)
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            // Url de connexion qui doit toujours commancer par JDBC +  le type de BDD
//          // + Localisation de la machine physique + le port utilisé (à trouver directement dans MySQL)
//          // + Nom de la base de donnée utilisée
            String url = "jdbc:mysql://localhost:3306/test-jdbc";
            String user = "root";
            String passwd = "";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("ConnexionBDD effective !");

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}