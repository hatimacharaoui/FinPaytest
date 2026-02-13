//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.Scanner;
//
//public class Facture {
//    private int idFacture;
//    private int idClient;
//    private int idPrestataire;
//    private double montant;
//    private String statut;
////    private LocalDate date_facture;
////    private Prestataire prestataire;
////    private Client client;
//
//
//    public Facture(int idFacture, int idClient, int idPrestataire, double montant, String statut) {
//        this.idFacture = idFacture;
//        this.idClient = idClient;
//        this.idPrestataire = idPrestataire;
//        this.montant = montant;
//        this.statut = statut;
//    }
//
//    public int getIdFacture() {
//        return idFacture;
//    }
//
//    public void setIdFacture(int idFacture) {
//        this.idFacture = idFacture;
//    }
//
//    public int getIdClient() {
//        return idClient;
//    }
//
//    public void setIdClient(int idClient) {
//        this.idClient = idClient;
//    }
//
//    public int getIdPrestataire() {
//        return idPrestataire;
//    }
//
//    public void setIdPrestataire(int idPrestataire) {
//        this.idPrestataire = idPrestataire;
//    }
//
//    public double getMontant() {
//        return montant;
//    }
//
//    public void setMontant(double montant) {
//        this.montant = montant;
//    }
//
//    public String getStatut() {
//        return statut;
//    }
//
//    public void setStatut(String statut) {
//        this.statut = statut;
//    }
//
//    public void creerFacture(){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Entrer ID Client : ");
//        idClient = sc.nextInt();
//
//        System.out.println("Entrer ID Prestataire : ");
//        idPrestataire = sc.nextInt();
//
//        System.out.println("Entrer Montant : ");
//        montant = sc.nextDouble();
//
//        statut = "NON_PAYEE";
//
//        String sql = "insert into facture(id_client,id_prestatire,montant,statut) values (?,?,?,?)";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)){
//
//            ps.setInt(1,idClient);
//            ps.setInt(2,idPrestataire);
//            ps.setDouble(3,montant);
//            ps.setString(4,statut);
//            ps.executeUpdate();
//
//            System.out.println("Facture crée");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void modifierFacture() {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("ID Facture : ");
//        int id = sc.nextInt();
//
//        System.out.print("Nouveau montant : ");
//        double montant = sc.nextDouble();
//
//        String sql = "UPDATE facture SET montant=? WHERE id_facture=?";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setDouble(1, montant);
//            ps.setInt(2, id);
//            ps.executeUpdate();
//
//            System.out.println("Facture modifiée.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void supprimerFacture() {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("ID Facture à supprimer : ");
//        int id = sc.nextInt();
//
//        String sql = "DELETE FROM facture WHERE id_facture=?";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//            ps.executeUpdate();
//
//            System.out.println("Facture supprimée.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void listerFactures() {
//
//        String sql = "SELECT * FROM facture";
//
//        try (Connection con = DBConnection.getConnection();
//             Statement st = con.createStatement();
//             ResultSet rs = st.executeQuery(sql)) {
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id_facture") + " | " +
//                                rs.getDouble("montant") + " | " +
//                                rs.getString("statut") + " | Prestataire: " +
//                                rs.getInt("id_prestataire")
//                );
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void filtrerParStatut() {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Statut (NON_PAYEE / PARTIELLE / PAYEE) : ");
//        String statut = sc.nextLine();
//
//        String sql = "SELECT * FROM facture WHERE statut=?";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, statut);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id_facture") + " | " +
//                                rs.getDouble("montant") + " | " +
//                                rs.getString("statut")
//                );
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void filtrerParPrestataire() {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("ID Prestataire : ");
//        int idPrestataire = sc.nextInt();
//
//        String sql = "SELECT * FROM facture WHERE id_prestataire=?";
//
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, idPrestataire);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id_facture") + " | " +
//                                rs.getDouble("montant") + " | " +
//                                rs.getString("statut")
//                );
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Facture {

    private int idFacture;
    private Client client;            // Remplace idClient
    private Prestataire prestataire;  // Remplace idPrestataire
    private double montant;
    private String statut;

    // Constructeur
    public Facture(int idFacture, Client client, Prestataire prestataire, double montant, String statut) {
        this.idFacture = idFacture;
        this.client = client;
        this.prestataire = prestataire;
        this.montant = montant;
        this.statut = statut;
    }

    public Facture() {} // constructeur vide

    // Getters et Setters
    public int getIdFacture() { return idFacture; }
    public void setIdFacture(int idFacture) { this.idFacture = idFacture; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Prestataire getPrestataire() { return prestataire; }
    public void setPrestataire(Prestataire prestataire) { this.prestataire = prestataire; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }


    public void creerFacture() {
        Scanner sc = new Scanner(System.in);


        int idClient = 0;
        while (true) {
            System.out.print("Entrer ID Client existant : ");
            idClient = sc.nextInt();

            String checkClient = "SELECT * FROM client WHERE id_client=?";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(checkClient)) {

                ps.setInt(1, idClient);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    client = new Client();
                    client.setId(idClient);
                    client.setNom(rs.getString("nom"));
                    break;
                } else {
                    System.out.println("ID Client introuvable. Réessayez.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        int idPrestataire = 0;
        while (true) {
            System.out.print("Entrer ID Prestataire existant : ");
            idPrestataire = sc.nextInt();

            String checkPrest = "SELECT * FROM prestataire WHERE id_prestataire=?";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(checkPrest)) {

                ps.setInt(1, idPrestataire);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    prestataire = new Prestataire();
                    prestataire.setId_Prestataire(idPrestataire);
                    prestataire.setNom(rs.getString("nom"));
                    break;
                } else {
                    System.out.println("ID Prestataire introuvable. Réessayez.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        System.out.print("Entrer Montant : ");
        montant = sc.nextDouble();
        statut = "NON_PAYEE";


        String sql = "INSERT INTO facture(id_client,id_prestataire,montant,statut) VALUES (?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, client.getId());
            ps.setInt(2, prestataire.getId_Prestataire());
            ps.setDouble(3, montant);
            ps.setString(4, statut);
            ps.executeUpdate();

            System.out.println("Facture créée avec succès.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void listerFactures() {
        String sql = "SELECT f.id_facture, f.montant, f.statut, c.nom AS nom_client, p.nom AS nom_prestataire " +
                "FROM facture f " +
                "JOIN client c ON f.id_client = c.id_client " +
                "JOIN prestataire p ON f.id_prestataire = p.id_prestataire";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_facture") + " | " +
                                rs.getDouble("montant") + " | " +
                                rs.getString("statut") + " | Client: " +
                                rs.getString("nom_client") + " | Prestataire: " +
                                rs.getString("nom_prestataire")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void filtrerParPrestataire() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID Prestataire : ");
        int idPrestataire = sc.nextInt();

        String sql = "SELECT f.id_facture, f.montant, f.statut, c.nom AS nom_client, p.nom AS nom_prestataire " +
                "FROM facture f " +
                "JOIN client c ON f.id_client = c.id_client " +
                "JOIN prestataire p ON f.id_prestataire = p.id_prestataire " +
                "WHERE f.id_prestataire=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPrestataire);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_facture") + " | " +
                                rs.getDouble("montant") + " | " +
                                rs.getString("statut") + " | Client: " +
                                rs.getString("nom_client") + " | Prestataire: " +
                                rs.getString("nom_prestataire")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
