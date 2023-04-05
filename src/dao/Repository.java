package dao;

import entities.Classe;
import entities.Etudiant;

import java.util.List;

public interface Repository<T> {

    public int delete(int id);
    public List<T> list();
    public T get(int id);


}
