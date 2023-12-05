package Services;

import Entite.Responsable;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceResponsable implements Iservice<Responsable>{
    private Connection con= DataSource.getInstance().getCon();
    private Statement ste;
    public ServiceResponsable()
    {
        try {
            ste = con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void ajouter(Responsable responsable) throws SQLException {

        String req="INSERT INTO `responsableclub` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, '"+responsable.getNom()+"', '"+responsable.getPrenom()+"', '"+responsable.getAge()+"');";
        int res=   ste.executeUpdate(req);
    }

    @Override
    public void update(Responsable responsable) throws SQLException {
            String req = "UPDATE responsableclub SET nom = '" + responsable.getNom() +
                    "', prenom = '" + responsable.getPrenom() +
                    "', age = '" + responsable.getAge() +
                    "' WHERE id = " + responsable.getId();
            int res = ste.executeUpdate(req);
        }

    @Override
        public void Supprimer(int id) throws SQLException {
            String req = "DELETE FROM responsableclub WHERE id = " + id;
            int res = ste.executeUpdate(req);
        }

    @Override
    public ArrayList<Responsable> readAll() throws SQLException {
        ArrayList<Responsable> list=new ArrayList<>();
        try {
            System.out.println("Liste des responsables :");

            ResultSet resultSet = ste.executeQuery("select * from responsableclub");
            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String nom=resultSet.getString("nom");

                String prenom=resultSet.getString("prenom");
                int age=resultSet.getInt("age");
                Responsable r=new Responsable(id,nom,prenom,age);
                list.add(r);
            }

        }catch (SQLException e)
        {
            System.out.println(e);
        }

        return list;
    }
    @Override
        public Responsable get(int id) throws SQLException {
            Responsable responsable = null;
            try {
                ResultSet resultSet = ste.executeQuery("SELECT * FROM responsableclub WHERE id = " + id);
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    int age = resultSet.getInt("age");
                    responsable = new Responsable(id, nom, prenom, age);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return responsable;
        }

//    public void afficherListeResponsables() {
//        try {
//            ArrayList<Responsable> listeResponsables = readAll();
//            if (!listeResponsables.isEmpty()) {
//                System.out.println("Liste des responsables :");
//                for (Responsable responsable : listeResponsables) {
//                    System.out.println(responsable);
//                }
//            } else {
//                System.out.println("La liste des responsables est vide.");
//            }
//        } catch (SQLException e) {
//            System.out.println("Erreur lors de la lecture des responsables : " + e.getMessage());
//        }
//    }





    }