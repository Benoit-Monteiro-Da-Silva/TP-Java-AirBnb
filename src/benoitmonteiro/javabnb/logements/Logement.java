package benoitmonteiro.javabnb.logements;

import benoitmonteiro.javabnb.utilisateurs.Personne;


public class Logement {
    
    private Personne hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(Personne paramHote, int paramTarifParNuit, String paramAdresse, int paramSuperficie, int paramNbVoyageursMax) {
        hote = paramHote;
        tarifParNuit = paramTarifParNuit;
        adresse = paramAdresse;
        superficie = paramSuperficie;
        nbVoyageursMax = paramNbVoyageursMax;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public void afficher() {
        hote.afficher();
        System.out.println("Le logement est situé " + adresse + ".");
        System.out.println("Superficie : " + superficie + "m2");
    }

}
