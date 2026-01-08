package benoitmonteiro.javabnb.utilisateurs;

public class Personne {
    
    private final String prenom;
    private final String nom;
    private final int age;

    public Personne(String paramPrenom, String paramNom, int paramAge) {
        prenom = paramPrenom;
        nom = paramNom;
        age = paramAge;
    }

    public void afficher() {
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }

}
