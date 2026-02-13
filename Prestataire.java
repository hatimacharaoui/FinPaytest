import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Prestataire {

    private int id_Prestataire;
    private String nom;

    public Prestataire(){

    }
    public Prestataire( int id_Prestataire, String nom) {
        this.id_Prestataire = id_Prestataire;
        this.nom = nom;
    }

    public int getId_Prestataire() {
        return id_Prestataire;
    }

    public void setId_Prestataire(int id_Prestataire) {
        this.id_Prestataire = id_Prestataire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterPrestataire() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nom : ");
        nom = sc.nextLine();

        String sql = "insert into prestataire(nom) values (?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,nom);
            ps.executeUpdate();

            System.out.println("Prestataire ajouté");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
