package benoitmonteiro.javabnb;

import java.util.ArrayList;
import java.util.Date;

import benoitmonteiro.javabnb.outils.LogementsDomParser;
import benoitmonteiro.javabnb.outils.Utile;
import benoitmonteiro.javabnb.logements.Appartement;
import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.logements.Maison;
import benoitmonteiro.javabnb.utilisateurs.Voyageur;
import benoitmonteiro.javabnb.utilisateurs.Hote;
import benoitmonteiro.javabnb.reservations.Sejour;
import benoitmonteiro.javabnb.reservations.SejourFactory;
import benoitmonteiro.javabnb.reservations.Reservation;


public class Main {

    public static void main(String[] args) {

        //Jeu de données perso
        Voyageur alain = new Voyageur("Alain", "Dupont", 28);
        Hote justine = new Hote("Justine", "Cerise", 19, 3 );

        Maison chezMoi = new Maison(
            justine, 
            80, 
            "14 rue Colbert, 37000 Tours", 
            70, 
            4, 
            50, 
            true);

        Appartement chezLui = new Appartement(
            justine, 
            50,
            "7 rue du Grenier, 41000 Blois", 
            25, 
            2, 
            0, 
            4);


        //Creation de listes
        ArrayList<Logement> listeDeLogements = new ArrayList<>();
        ArrayList<Hote> listeDHotes = new ArrayList<>();

        //Tentative de récupération des logements et des hôtes du fichier res/logements.xml dans listeDeLogements et listeDHotes
        try {
            LogementsDomParser.parse("res/logements.xml", listeDHotes, listeDeLogements);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des données.");
        }

        //Affichage de la liste d'hôtes
        for (Hote hote : listeDHotes) {
            hote.afficher();
        }

        
        //Création d'un séjour
        Date dateSejour = Utile.createDate(25, 8, 2026);
        int nbNuits = 10;
        int nbVoyageurs = 2;
        Logement logementVacances = chezLui;
        Sejour lesVacances;

        lesVacances = SejourFactory.creerSejour(dateSejour, nbNuits, nbVoyageurs, logementVacances);

        try {
            Reservation lesVacancesReservees = new Reservation(lesVacances, alain);
            // lesVacancesReservees.afficher();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("La création de la réservation a échoué.");
        }


    }

}
