package dao;

import entities.Classe;

public interface IClasse extends Repository{
    int add(Classe c);

    int update(Classe c);
}
