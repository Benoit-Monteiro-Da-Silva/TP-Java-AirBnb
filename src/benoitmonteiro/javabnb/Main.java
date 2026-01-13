package benoitmonteiro.javabnb;

import java.util.ArrayList;
import java.util.Date;

import benoitmonteiro.javabnb.outils.JavaBnBData;
import benoitmonteiro.javabnb.outils.Utile;
import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.utilisateurs.Voyageur;
import benoitmonteiro.javabnb.utilisateurs.Hote;
import benoitmonteiro.javabnb.reservations.Sejour;
import benoitmonteiro.javabnb.reservations.SejourFactory;
import benoitmonteiro.javabnb.reservations.Reservation;


public class Main {

    public static void main(String[] args) {

        //Récupération des données (logements et hôtes)
        JavaBnBData data = JavaBnBData.getInstance();
        ArrayList<Logement> logements = data.getLogements();
        ArrayList<Hote> hotes = data.getHotes();

        //Création d'un voyageur
        Voyageur alain = new Voyageur("Alain", "Durant", 31);

        //Création d'un séjour
        Date dateSejour = Utile.createDate(25, 8, 2026);
        int nbNuits = 10;
        int nbVoyageurs = 2;
        Logement logementVacances = logements.get(0);
        Sejour lesVacances = SejourFactory.creerSejour(dateSejour, nbNuits, nbVoyageurs, logementVacances);

        try {
            Reservation lesVacancesReservees = new Reservation(lesVacances, alain);
            lesVacancesReservees.afficher();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("La création de la réservation a échoué.");
        }


    }

}
