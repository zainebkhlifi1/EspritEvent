package Services;

import Entite.Administrateur;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceAdministrateur implements IService<Administrateur>{

    private Connection con= DataSource.getInstance().getCon();

    private Statement ste;


    public ServiceAdministrateur()
    {
        try {
            ste = con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    @Override
    public void ajouter(Administrateur admin) throws SQLException {
        String req="INSERT INTO `administrateur` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, '"+personne.getNom()+"', '"+personne.getPrenom()+"', '"+personne.getAge()+"');";
        int res=   ste.executeUpdate(req);
    }

    @Override
    public void update(Personne personne) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public ArrayList<Personne> readAll() throws SQLException {
        ArrayList<Personne> list=new ArrayList<>();
        try {
            ResultSet resultSet = ste.executeQuery("select * from personne");
            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String nom=resultSet.getString(2);

                String prenom=resultSet.getString(3);
                int age=resultSet.getInt(4);
                Personne p=new Personne(id,nom,prenom,age);
                list.add(p);
            }

        }catch (SQLException e)
        {
            System.out.println(e);
        }


        return list;
    }

    @Override
    public Personne get(int id) throws SQLException {
        return null;
    }
}