package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.outils.Utile;


public abstract class Sejour implements Reservable {

    private final Date dateArrivee;
    private final int nbNuits;
    private final Logement logement;
    private final int nbVoyageurs;

    public Sejour(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        dateArrivee = paramDateArrivee;
        nbNuits = paramNbNuits;
        logement = paramLogement;
        nbVoyageurs = paramNbVoyageurs;
    }


    //Getters

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public Logement getLogement() {
        return logement;
    }

    public int getNbVoyageurs() {
        return nbVoyageurs;
    }


    //Interface methods

    public void afficher() {
        logement.afficher();
        System.out.println("La date d'arrivée est le " + Utile.formatDate(dateArrivee) + " pour " + nbNuits + " nuits.");
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
