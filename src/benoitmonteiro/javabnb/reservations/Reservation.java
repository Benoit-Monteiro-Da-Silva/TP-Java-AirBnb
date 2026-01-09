package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.utilisateurs.Voyageur;
import benoitmonteiro.javabnb.outils.Utile;


public class Reservation {

    private final Reservable objetReservable;
    private final Voyageur voyageur;
    private final Date dateDeReservation;

    public Reservation(Reservable pObjetReservable, Voyageur pVoyageur) {
        objetReservable = pObjetReservable;
        voyageur = pVoyageur;
        dateDeReservation = new Date();
    }

    public void afficher() {
        System.out.println("Date de la réservation : " + Utile.formatDate(dateDeReservation));
        System.out.print("Voyageur : ");
        voyageur.afficher();
        System.out.println("");
        System.out.print("A réservé chez ");
        objetReservable.afficher();
    }

}
