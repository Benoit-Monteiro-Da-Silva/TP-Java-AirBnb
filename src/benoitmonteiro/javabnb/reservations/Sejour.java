package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;


public class Sejour {

    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    public Sejour(Date paramDateArrivee, int paramNbNuits, Logement paraLogement, int paramNbVoyageurs) {
        dateArrivee = paramDateArrivee;
        nbNuits = paramNbNuits;
        logement = paraLogement;
        nbVoyageurs = paramNbVoyageurs;
    }

    public void afficher() {
        logement.afficher();

        String date = (dateArrivee.getDate() <= 9) ? "0" + dateArrivee.getDate() : "" + dateArrivee.getDate();
        String month = (dateArrivee.getMonth() <= 9) ? "0" + dateArrivee.getMonth() : "" + dateArrivee.getMonth();
        String year = "" + dateArrivee.getYear();
        String dateFormatee = date + "/" + month + "/" + year;

        System.out.println("La date d'arrivée est le " + dateFormatee + " pour " + nbNuits + " nuits.");
        System.out.println("Le prix de ce séjour est de " + tarif() + "€.");  
    }

    private int tarif() {
        return logement.getTarifParNuit() * nbNuits;
    }

}
