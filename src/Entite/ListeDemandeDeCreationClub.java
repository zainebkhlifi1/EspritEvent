package Entite;

public class ListeDemandeDeCreationClub {
    private int id_demande;
    private String nom_club;


    public ListeDemandeDeCreationClub(int id_demande, String nom_club) {
        this.id_demande = id_demande;
        this.nom_club = nom_club;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }


    @Override
    public String toString() {
        return "ListeDemandeDeCreationClub{" +
                "id_demande=" + id_demande +
                ", nom_club='" + nom_club + '\'' +
                '}';
    }
}
