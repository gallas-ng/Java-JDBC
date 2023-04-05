package entities;

public class Classe {

    private int id;
    private String nom;
    private int effectif;


    public Classe() {
        this.effectif = 0;
    }

    public Classe(int id, String nom, int effectif) {
        this.id = id;
        this.nom = nom;
        this.effectif = effectif;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }


}
