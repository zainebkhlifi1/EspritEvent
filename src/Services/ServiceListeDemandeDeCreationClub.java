package Services;

import Entite.ListeDemandeDeCreationClub;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDemande implements Iservice<ListeDemandeDeCreationClub> {

    @Override
    public void ajouter(ListeDemandeDeCreationClub listeDemandeDeCreationClub) throws SQLException {

    }

    @Override
    public void update(ListeDemandeDeCreationClub listeDemandeDeCreationClub) throws SQLException {

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
