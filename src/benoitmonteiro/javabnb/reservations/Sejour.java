package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.outils.Utile;


public class Sejour implements Reservable {

    private final Date dateArrivee;
    private final int nbNuits;
    private final Logement logement;
    private final int nbVoyageurs;

    public Sejour(Date paramDateArrivee, int paramNbNuits, Logement paraLogement, int paramNbVoyageurs) {
        dateArrivee = paramDateArrivee;
        nbNuits = paramNbNuits;
        logement = paraLogement;
        nbVoyageurs = paramNbVoyageurs;
    }

    private int tarif() {
        return logement.getTarifParNuit() * nbNuits;
    }

    public void afficher() {
        logement.afficher();

        System.out.println("La date d'arrivée est le " + Utile.formatDate(dateArrivee) + " pour " + nbNuits + " nuits.");
        System.out.println("Le prix de ce séjour est de " + tarif() + "€.");  
    }

    public boolean aUneDateArriveeCorrect() {
        return dateArrivee.getTime() > new Date().getTime() ? true : false;
    }

    public boolean aUnNombreDeNuitsCorrect() {
        return (nbNuits >= 1 && nbNuits <= 31) ? true : false; 
    }

    public boolean aUnNombreDeVoyageursCorrect() {
        return (nbVoyageurs <= logement.getNbVoyageursMax()) ? true : false;
    }

}
