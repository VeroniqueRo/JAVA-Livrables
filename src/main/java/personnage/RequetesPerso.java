package personnage;

import java.util.Scanner;
import java.sql.*;

public class RequetesPerso {

    public void afficheTousPerso() {
        try {
            // Appel la classe ConnexionBDD et lance la connexion
            Connection conn = ConnexionBDD.ouvrir();

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM personnage");

            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.print("\nTABLEAU DE TOUS LES PERSONNAGES DE LA BDD");
            System.out.println("\n****************************************************************************************************");
            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            System.out.println("\n****************************************************************************************************");

            // Méthode pour afficher le résultat de la requête : Boucle sur toutes les lignes du tableau result
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");
                System.out.println("\n---------------------------------------------------------------------------------------------------");
            }

            // Autre méthode pour récupérer les résultats quand on connait le nom des colonnes
            // Nota : Les méthodes getInt et getString doivent être utilisé avec les bons formats (int et String) sinon cela lèvera une exception
//            while (result.next()) {
//
//                System.out.print("\t" + result.getInt("Id") + "\t |");
//                System.out.print("\t" + result.getString("Type") + "\t |");
//                System.out.print("\t" + result.getString("Nom") + "\t |");
//                System.out.print("\t" + result.getString("Image") + "\t |");
//                System.out.print("\t" + result.getInt("NiveauVie") + "\t |");
//                System.out.print("\t" + result.getInt("Attaque") + "\t |");
//                System.out.print("\t" + result.getInt("Arme") + "\t |");
//                System.out.print("\t" + result.getInt("Bouclier") + "\t |\n");
//
//            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afficheUnPerso() {
        try {
            // Appel la classe ConnexionBDD et lance la connexion
            Connection conn = ConnexionBDD.ouvrir();
            // Création d'un objet Statement
//            Statement state = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Quel personnage voulez-vous afficher ? ");
            int persoAAfficher = sc.nextInt();

            String query = "SELECT * FROM personnage WHERE Id = ?";
            PreparedStatement state = conn.prepareStatement(query);
            state.setInt(1, persoAAfficher);

//            String query = "SELECT * FROM personnage WHERE Id = " + persoAAfficher;
            ResultSet result = state.executeQuery();

            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.print("\nAFFICHE LE PERSONNAGE DE LA BDD CHOISI");
            System.out.println("\n------------------------------------------------------------------------------------------");

            // Permet d'afficher les infos de la première ligne
//            result.first();
//            System.out.println("Type : " + result.getString("Type"));
//            System.out.println("Nom : " + result.getString("Nom"));
//            System.out.println("Image : " + result.getString("Image"));
//            System.out.println("Niveau de vie : " + result.getString("NiveauVie"));
//            System.out.println("Niveau d'attaque : " + result.getString("Attaque"));
//            System.out.println("Niveau de l'arme : " + result.getString("Arme"));
//            System.out.println("Niveau du bouclier : " + result.getString("Bouclier"));

//            System.out.print("\nAFFICHE LE PERSONNAGE DE LA BDD CHOISI");
//            System.out.println("\n------------------------------------------------------------------------------------------");
//
            result.first();
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");
                System.out.println("\n---------------------------------------------------------------------------------------");

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void modifiePerso() {
        try {
            // Appel la classe ConnexionBDD et lance la connexion
            Connection conn = ConnexionBDD.ouvrir();
            Scanner sc = new Scanner(System.in);

            afficheTousPerso();
            System.out.println("Choisissez le personnage à modifier");
            int idPersoModif = sc.nextInt();
            sc.nextLine();

            System.out.println("Saisir le nouveau nom du personnage");
            String nomAModifier = sc.nextLine();

            // Requète à éxécuter
            String query = "UPDATE personnage SET Nom = ? WHERE Id= ?";

            // Exécute la requête
            PreparedStatement state = conn.prepareStatement(query);

            // Indique ce qui doit être dans le ?
            state.setString(1, nomAModifier);
            state.setInt(2, idPersoModif);

            state.executeUpdate();
            state.close();

            afficheTousPerso();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supprimeUnPerso() {
        try {
            // Appel la classe ConnexionBDD et lance la connexion
            Connection conn = ConnexionBDD.ouvrir();
            Scanner sc = new Scanner(System.in);

            afficheTousPerso();
            System.out.println("Choisissez l'id du personnage à supprimer");
            int idPersoSupp = sc.nextInt();
            sc.nextLine();

            // Requète à éxécuter
            String query = "DELETE FROM personnage WHERE Id= ?";

            // Exécute la requête
            PreparedStatement state = conn.prepareStatement(query);

            // Indique ce qui doit être dans le ?
            state.setInt(1, idPersoSupp);

            state.execute();
            state.close();

            afficheTousPerso();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajoutePersoGuerrier() {
        try {

            // Appel la classe ConnexionBDD et lance la connexion
            Connection conn = ConnexionBDD.ouvrir();
            Scanner sc = new Scanner(System.in);

            System.out.print("\nAJOUTER UN GUERRIER A LA BDD");
            System.out.println("\n********************************************************************");

            System.out.println("Quel nom souhaitez-vous donner à votre Guerrier ? ");
            String nomAAjouter = sc.nextLine();
            System.out.println("Quelle image souhaitez-vous donner à votre Guerrier ? ");
            String image = sc.nextLine();
            System.out.println("Quelle force souhaitez-vous donner à l'arme de votre Guerrier ? ");
            int arme = sc.nextInt();
            System.out.println("Quel force souhaitez-vous donner au bouclier de votre Guerrier ? ");
            int bouclier = sc.nextInt();

            //Instancier le guerrier
            Guerrier guerrier = new Guerrier(nomAAjouter, image, arme, bouclier);
            System.out.println(guerrier);

            // Requète à éxécuter
            String query2 = "INSERT INTO personnage VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

            // Exécute la requête
            PreparedStatement state4 = conn.prepareStatement(query2);

            // Indique ce qui doit être dans le ?
            state4.setString(1, guerrier.getType());
            state4.setString(2, guerrier.getNom());
            state4.setString(3, guerrier.getImage());
            state4.setInt(4, guerrier.getNiveauVie());
            state4.setInt(5, guerrier.getAttaque());
            state4.setInt(6, guerrier.getArme());
            state4.setInt(7, guerrier.getBouclier());

            state4.executeUpdate();
            state4.close();

            afficheTousPerso();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajoutePersoMagicien() {
        try {

            // Appel la classe ConnexionBDD et lance la connexion
            Connection conn = ConnexionBDD.ouvrir();
            Scanner sc = new Scanner(System.in);

            System.out.print("\nAJOUTER UN MAGICIEN A LA BDD");
            System.out.println("\n********************************************************************");

            System.out.println("Quel nom souhaitez-vous donner à votre Magicien ? ");
            String nomAAjouter = sc.nextLine();
            System.out.println("Quelle image souhaitez-vous donner à votre Magicien ? ");
            String image = sc.nextLine();
            System.out.println("Quelle force souhaitez-vous donner au sort de votre Magicien ? ");
            int sort = sc.nextInt();
            System.out.println("Quel force souhaitez-vous donner au bouclier de votre Magicien ? ");
            int bouclier = sc.nextInt();

            //Instancier le guerrier
            Magicien magicien = new Magicien(nomAAjouter, image, sort, bouclier);
            System.out.println(magicien);

            // Requète à éxécuter
            String query = "INSERT INTO personnage VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

            // Exécute la requête
            PreparedStatement state = conn.prepareStatement(query);

            // Indique ce qui doit être dans le ?
            state.setString(1, magicien.getType());
            state.setString(2, magicien.getNom());
            state.setString(3, magicien.getImage());
            state.setInt(4, magicien.getNiveauVie());
            state.setInt(5, magicien.getAttaque());
            state.setInt(6, magicien.getSort());
            state.setInt(7, magicien.getBouclier());

            state.executeUpdate();
            state.close();

            afficheTousPerso();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
