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

}
