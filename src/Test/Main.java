package Test;
import java.sql.SQLException;
import java.util.ArrayList;

import Entite.ListeDemandeDeCreationClub;
import Entite.Responsable;
import Services.ServiceListeDemandeDeCreationClub;
import Services.ServiceResponsable;

public class Main {
    public static void main(String[] args) {

        ServiceResponsable ser=new ServiceResponsable();
        Responsable p1=new Responsable(10,"zaineb","khlifi");
        ServiceListeDemandeDeCreationClub serlist=new ServiceListeDemandeDeCreationClub();
        ListeDemandeDeCreationClub l1=new ListeDemandeDeCreationClub(10,"dance");
        try {
            ser.ajouter(p1);
            System.out.println("Responsable  ajouté");
        }catch (SQLException e)
        {
            System.out.println(e);
        }


        ArrayList<Responsable> l=null;
        try {
            l = ser.readAll();
        }catch (SQLException e)
        {
            System.out.println(e);
        }


        l.forEach(e-> System.out.println(e));

        // Mise à jour d'un responsable
        Responsable responsableToUpdate = new Responsable(1, "fares", "loukil", 40);
        try {
            ser.update(responsableToUpdate);
            System.out.println("Responsable mis à jour avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du responsable : " + e.getMessage());
        }
// Suppression de responsable par id
        int idResponsableASupprimer = 2;
        try {
            ser.Supprimer(idResponsableASupprimer);
            System.out.println("Responsable supprimé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du responsable : " + e.getMessage());
        }

//Lecture d'un responsable par id
        int idResponsableALire = 3;
        try {
            Responsable responsableLu = ser.get(idResponsableALire);
            if (responsableLu != null) {
                System.out.println("Responsable trouvé : " + responsableLu);
            } else {
                System.out.println("Aucun responsable trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la lecture du responsable : " + e.getMessage());
        }

    }


    }