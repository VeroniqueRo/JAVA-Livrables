package personnage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Jouez avec la BDD !");
        System.out.println("**********************************************");

        Scanner sc = new Scanner(System.in);
        int choix=0;

        RequetesPerso listePersonages = new RequetesPerso();

        do {
            System.out.println("Que voulez-vous faire ? ");
            System.out.println("\n1. Afficher tous les personnages de la BDD ? ");
            System.out.println("2. Afficher un personnage de la BDD");
            System.out.println("3. Modifier le nom d'un personnage de la BDD");
            System.out.println("4. Ajouter un guerrier à la BDD");
            System.out.println("5. Ajouter un magicien à la BDD");
            System.out.println("\n6. Quitter");
            System.out.println("**********************************************");
            // Gestion d'une exception simple : Si la saisie n'est pas un "integer"
            try {
                choix = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erreur de saisie : Saisissez un chiffre de 1 à 5");
            }
            sc.nextLine();

            switch (choix) {
                case 1:
                    listePersonages.afficheTousPerso();
                    break;

                case 2:
                    listePersonages.afficheUnPerso();
                    break;

                case 3:
                    listePersonages.modifiePerso();
                    break;

                case 4:
                    listePersonages.ajoutePersoGuerrier();
                    break;

                case 5:
                    listePersonages.ajoutePersoMagicien();
                    break;

                case 6:
                    break;

                default:
//                    System.out.println("Erreur de saisie");
            }

        } while (choix != 6);

        System.out.println("A bientôt !");
    }
}

