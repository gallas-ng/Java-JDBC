package dao;

import entities.Classe;
import entities.Etudiant;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EtudiantImpl implements IEtudiant {

    private DB db = new DB();
    private int ok;
    private ResultSet rs;

    @Override
    public int add(Etudiant e) {
        String sql = "INSERT INTO etudiant VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            //Initialisation de la requete
            db.initPrepar(sql);
            //Passage de valeurs
            db.getPstm().setString(1, e.getMatricule());
            db.getPstm().setString(2, e.getNom());
            db.getPstm().setString(3, e.getPrenom());
            db.getPstm().setDouble(4, e.getMoyenne());
            //db.getPstm().setObject(5, e.getClasse());
            db.getPstm().setInt(5, e.getClasse().getId());
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
    public int update(Etudiant e) {
        String sql = "UPDATE etudiant SET nom=?, prenom=?, moyenne=?, classe=? WHERE id=?";
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1, e.getNom());
            db.getPstm().setString(2, e.getPrenom());
            db.getPstm().setDouble(3, e.getMoyenne());
            db.getPstm().setInt(4, e.getClasse().getId());
            db.getPstm().setInt(5, e.getId());
            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }


    @Override
    public int delete(int id) {
        String sql = "DELETE FROM etudiant WHERE id=?";
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
    public List<Etudiant> list() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM etudiant ORDER BY nom ASC";
        try{
            db.initPrepar(sql);
            rs = db.executeSelect();
            while(rs.next()){
                Etudiant user = new Etudiant();
                user.setId(rs.getInt(1));
                user.setMatricule(rs.getString(2));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setMoyenne(rs.getDouble(4));
                user.setClasse((Classe) rs.getObject(6));
                etudiants.add(user);
            }
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return etudiants;
    }

    @Override
    public Etudiant get(int id) {
        Etudiant etudiant = null;
        String sql = "SELECT * FROM etudiant WHERE id=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            rs = db.executeSelect();
            if(rs.next()){
                etudiant = new Etudiant();
                etudiant.setId(rs.getInt("id"));
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setMoyenne(rs.getDouble("moyenne"));
                etudiant.setClasse((Classe) rs.getObject("classe"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return etudiant;
    }

    @Override
    public List<Etudiant> getEtudiantByClasse(String classe) {
        return null;
    }
}
