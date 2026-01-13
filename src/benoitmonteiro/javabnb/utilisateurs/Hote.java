package benoitmonteiro.javabnb.utilisateurs;

public class Hote extends Personne {

    private final int delaiDeReponse;

    public Hote(String pPrenom, String pNom, int pAge, int pDelaiDeReponse) {
        super(pPrenom, pNom, pAge);
        delaiDeReponse = pDelaiDeReponse;
    }

    @Override
    public void afficher(){
        String delaiString = (delaiDeReponse == 1)? "l'heure" : "les 12 heures";

        super.afficher();
        System.out.println(" qui s'engage à réponde dans " + delaiString + ".");
    }

    //Methode pour comparer deux hôtes (basée sur la méthode 'super' qui compare deux personnes)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false; 
        
        if (!super.equals(obj)) return false;

        Hote hote = (Hote) obj;
        return delaiDeReponse == hote.delaiDeReponse;
    }

}
