package main;

import dao.ClasseImpl;
import dao.IClasse;
import entities.Classe;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        IClasse iClasse = new ClasseImpl();
        Classe classe = new Classe();

        classe.setNom("GDA");

        if (iClasse.add(classe) == 1) {
            System.out.println("Classe créée avec Succés !");
        } else {
            System.out.println("Insertion échouée !");
        }

        List<Classe> listeClasses = iClasse.list();
        System.out.println("Liste des CLasses");
        for (Classe c : listeClasses) {
            System.out.println(c.getNom() + " [ " + c.getEffectif() + " ] ");
        }
    }

}