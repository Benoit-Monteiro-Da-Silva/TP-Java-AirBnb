package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.outils.Utile;


public abstract class Sejour implements Reservable {

    private final Date dateArrivee;
    private final int nbNuits;
    private final int nbVoyageurs;
    private Logement logement;
    protected int prix; //Children have full access to this attribute (read and write)


    /**
     * @implNote Children must override interface method 'boolean aUnNombreDeNuitsCorrect()' and method 'void miseAJourDuPrixDeSejour()'.
     * @implNote 'void miseAJourDuPrixDeSejour' method must update protected attribute 'this.prix'
     */
    public Sejour(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        dateArrivee = paramDateArrivee;
        nbNuits = paramNbNuits;
        logement = paramLogement;
        nbVoyageurs = paramNbVoyageurs;
        
        miseAJourDuPrixDeSejour();
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


    //Setters

    public void setLogement(Logement newLogement) {
        logement = newLogement;
        miseAJourDuPrixDeSejour();
    }


    //Interface methods

    @Override
    public void afficher() {
        logement.afficher();
        System.out.println("La date d'arrivée est le " + Utile.formatDate(dateArrivee) + " pour " + nbNuits + " nuits.");
    }

    @Override
    public boolean aUneDateArriveeCorrect() {
        Date dateActuelle = new Date();
        return dateArrivee.after(dateActuelle);
    }

    @Override
    public boolean aUnNombreDeVoyageursCorrect() {
        return (nbVoyageurs > 0) && (nbVoyageurs <= logement.getNbVoyageursMax());
    }


    //Other methods

    public abstract void miseAJourDuPrixDeSejour();


}
