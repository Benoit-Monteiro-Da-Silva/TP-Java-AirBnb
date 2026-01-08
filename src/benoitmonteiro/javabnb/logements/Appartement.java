package benoitmonteiro.javabnb.logements;

import benoitmonteiro.javabnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private final int superficieBalcon;
    private final int numeroEtage;

    public Appartement(Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, int pSuperficieBalcon, int pNumeroEtage) {
        super(pHote, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax);
        superficieBalcon = pSuperficieBalcon;
        numeroEtage = pNumeroEtage;
    }

    @Override
    public void afficher() {

        this.getHote().afficher();

        System.out.println("Le logement est un appartement situé " + this.getAdresse() + " au " + etageString() + ".");
        System.out.println("Superficie : " + this.getSuperficie() + "m2");

        String balconString = (superficieBalcon > 0) ? "Oui (" + superficieBalcon + "m2)" : "Non";
        System.out.println("Balcon : " + balconString);
    }

    private String etageString() {
        if (numeroEtage == 0) return "rez-de-chaussée";
        if (numeroEtage == 1) return "1er étage";
        return numeroEtage + "ème étage";
    }

}
