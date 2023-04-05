package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Etudiant {

    private int id;
    private String matricule;
    private String nom;
    private String prenom;
    private double moyenne;
    private Classe classe;


    public Etudiant(int id, String nom, String prenom, double moyenne, Classe classe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
        this.classe = classe;
        this.matricule = genererMatricule(classe);
    }

    public Etudiant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String genererMatricule(Classe classe){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String timestamp = now.format(formatter);
        String classeNom = classe.getNom().replaceAll(" ", "");
        return "ET@" + timestamp + classeNom + "#";
    }
}

