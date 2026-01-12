package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.utilisateurs.Voyageur;
import benoitmonteiro.javabnb.outils.Utile;


public class Reservation {

    private final Reservable objetReservable;
    private final Voyageur voyageur;
    private final Date dateDeReservation;

    /**
     * 
     * @param pObjetReservable
     * @param pVoyageur
     * @throws IllegalArgumentException si le nombre de nuits, le nombre de voyageurs ou la date d'arrivée est incorrecte
     * @throws IllegalArgumentException si le voyageur ou l'objet réservable est null
     */
    public Reservation(Reservable pObjetReservable, Voyageur pVoyageur) {
        
        if (pObjetReservable == null) {
            throw new IllegalArgumentException("Objet Réservable est null");
        }
        if (pVoyageur == null) {
            throw new IllegalArgumentException("Voyageur est null");
        }
        if (!pObjetReservable.aUnNombreDeNuitsCorrect()) {
            throw new IllegalArgumentException("Le nombre de nuits du séjour n'est pas correct.");
        }
        if (!pObjetReservable.aUnNombreDeVoyageursCorrect()) {
            throw new IllegalArgumentException("Le nombre de voyageurs du séjour dépasse la capacité du logement (ou est négatif)");
        }
        if (!pObjetReservable.aUneDateArriveeCorrect()) {
            throw new IllegalArgumentException("La date d'arrivée du séjour est dans le passé.");
        }

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
