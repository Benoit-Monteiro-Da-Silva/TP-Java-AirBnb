package benoitmonteiro.javabnb.logements;

import benoitmonteiro.javabnb.utilisateurs.Hote;


public class Logement {
    
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    private final int superficie;
    private final int nbVoyageursMax;

    public Logement(Hote paramHote, int paramTarifParNuit, String paramAdresse, int paramSuperficie, int paramNbVoyageursMax) {
        hote = paramHote;
        tarifParNuit = paramTarifParNuit;
        adresse = paramAdresse;
        superficie = paramSuperficie;
        nbVoyageursMax = paramNbVoyageursMax;
    }


    //Getters

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public Hote getHote() {
        return hote;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    
    //Other methods

    public void afficher() {
        hote.afficher();
        System.out.println("Le logement est situé " + adresse + ".");
        System.out.println("Superficie : " + superficie + "m2");
    }

}
