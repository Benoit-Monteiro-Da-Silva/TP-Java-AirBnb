package benoitmonteiro.javabnb.logements;

import benoitmonteiro.javabnb.utilisateurs.Hote;
import benoitmonteiro.javabnb.outils.Comparable;

// 'abstract' for a class means this class can't be instanced. 
// It is also necessary if we want to define abstract methods, that children are forced to re-define.
// It also means that the class won't have to define its interface methods anymore, but if it doesn't do it, its children will.
public abstract class Logement implements Comparable {
    
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


    //Interface methods

    @Override
    public int getComparableAttribute() {
        return tarifParNuit;
    }


    //Other methods

    public abstract void afficher(); // 'abstract' for a method means that Children-classes are forced to define this method their own way.

}
