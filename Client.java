import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class Client {
    private int id;
    private String nom;
    private String email;

    public Client(){}

    public Client( int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer Nom : ");
        nom = sc.nextLine();

        System.out.println("Email : ");
        email = sc.nextLine();

        String sql = "insert into client(nom,email) values (?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nom);
            ps.setString(2, email);
            ps.executeUpdate();

            System.out.println("Client ajouté");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}











