package dao;

import entities.Etudiant;

import java.util.List;

public interface IEtudiant extends Repository {


   int add(Etudiant e);
   int update(Etudiant e);
   List<Etudiant> getEtudiantByClasse(String classe);

}
