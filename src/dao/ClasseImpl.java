package dao;

import entities.Classe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClasseImpl implements IClasse {

    private DB db = new DB();
    private int ok;
    private ResultSet rs;

    @Override
    public int add(Classe c) {
        String sql = "INSERT INTO classe VALUES(NULL, ?, ?)";
        try {
            //Initialisation de la requete
            db.initPrepar(sql);
            //Passage de valeurs
            db.getPstm().setString(1, c.getNom());
            db.getPstm().setInt(2, c.getEffectif());

            //Exécution de la requete
            ok = db.executeMaj();
            //Fermeture de la connexion
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }



    @Override
    public int update(Classe c) {
        String sql = "UPDATE classe SET nom=?, effectif=? WHERE id=?";
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1, c.getNom());
            db.getPstm().setInt(2, c.getEffectif());
            db.getPstm().setInt(3, c.getId());
            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM classe WHERE id=?";
        try{
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Classe> list() {
        List<Classe> classes = new ArrayList<>();
        String sql = "SELECT * FROM classe ORDER BY nom ASC";
        try{
            db.initPrepar(sql);
            rs = db.executeSelect();
            while(rs.next()){
                Classe classe = new Classe();
                classe.setId(rs.getInt(1));
                classe.setNom(rs.getString(2));
                classe.setEffectif(rs.getInt(3));
                classes.add(classe);
            }
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return classes;
    }

    @Override
    public Classe get(int id) {
        Classe classe = null;
        String sql = "SELECT * FROM classe WHERE id=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            rs = db.executeSelect();
            if(rs.next()){
                classe = new Classe();
                classe.setId(rs.getInt("id"));
                classe.setNom(rs.getString("nom"));
                classe.setEffectif(rs.getInt("effectif"));
                }
        }catch (Exception e){
            e.printStackTrace();
        }
        return classe;
    }
}
