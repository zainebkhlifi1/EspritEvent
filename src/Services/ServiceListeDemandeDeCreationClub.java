package Services;

import Entite.ListeDemandeDeCreationClub;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceListeDemandeDeCreationClub implements Iservice<ListeDemandeDeCreationClub> {
    private Connection con= DataSource.getInstance().getCon();
    private Statement ste;

    public ServiceListeDemandeDeCreationClub()
    {
        try {
            ste = con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void ajouter(ListeDemandeDeCreationClub listeDemandeDeCreationClub) throws SQLException {
        String req="INSERT INTO `demande` (`id_demande','nom_club') VALUES (NULL, '"+listeDemandeDeCreationClub.getId_demande()+"', '"+listeDemandeDeCreationClub.getNom_club();
        int res=   ste.executeUpdate(req);
    }

    @Override
    public void update(ListeDemandeDeCreationClub listeDemandeDeCreationClub) throws SQLException {
        String req = "UPDATE `demande` SET `nom_club` = ? WHERE `id_demande` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(req);
        preparedStatement.setString(1, listeDemandeDeCreationClub.getNom_club());
        preparedStatement.setInt(2, listeDemandeDeCreationClub.getId_demande());
        preparedStatement.executeUpdate();
    }

    @Override
    public void Supprimer(int id) throws SQLException {

    }

    @Override
    public ArrayList<ListeDemandeDeCreationClub> readAll() throws SQLException {
        return null;
    }

    @Override
    public ListeDemandeDeCreationClub get(int id) throws SQLException {
        return null;
    }
}
