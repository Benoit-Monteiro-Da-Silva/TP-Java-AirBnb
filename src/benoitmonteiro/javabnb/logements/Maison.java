package benoitmonteiro.javabnb.logements;

import benoitmonteiro.javabnb.utilisateurs.Hote;

public class Maison extends Logement {

    private final int superficieJardin;
    private final boolean possedePiscine;

    public Maison(Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, int pSuperficieJardin, boolean pPossedePiscine) {
        super(pHote, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax);
        superficieJardin = pSuperficieJardin;
        possedePiscine = pPossedePiscine;
    }

    @Override
    public void afficher() {

        this.getHote().afficher();
        
        System.out.println("Le logement est une maison située " + this.getAdresse() + ".");
        System.out.println("Superficie : " + this.getSuperficie() + "m2");

        String jardinString = (superficieJardin > 0) ? "Oui (" + superficieJardin + " m2)" : "Non";
        System.out.println("Jardin : " + jardinString);

        String piscineString = (possedePiscine) ? "Oui" : "Non";
        System.out.println("Piscine : " + piscineString);
    }

    public boolean hasPiscine() {
        return possedePiscine;
    }

}
