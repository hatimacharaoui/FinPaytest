import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Paiement {
    private int id;
    private int factureId;
    private double montant;
    private double commission;
    private LocalDate datePaiment;

    public Paiement() {}

    public Paiement(int id, int factureId, double montant, double commission, LocalDate datePaiment) {
        this.id = id;
        this.factureId = factureId;
        this.montant = montant;
        this.commission = commission;
        this.datePaiment = datePaiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactureId() {
        return factureId;
    }

    public void setFactureId(int factureId) {
        this.factureId = factureId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public LocalDate getDatePaiment() {
        return datePaiment;
    }

    public void setDatePaiment(LocalDate datePaiment) {
        this.datePaiment = datePaiment;
    }

    public void ajouterPaiement(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID Facture : ");
        factureId = sc.nextInt();

        System.out.println("Montant payé : ");
        montant = sc.nextDouble();

        commission = montant * 0.02;

        String sqlPaiement = "insert into paiement(id_facture,montant,commission) values (?,?,?)";
        String sqlUpdateFacture = "update facture set statut='PAYEE' where id_facture=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps1 = con.prepareStatement(sqlPaiement);
             PreparedStatement ps2 = con.prepareStatement(sqlUpdateFacture)) {

            ps1.setInt(1,factureId);
            ps1.setDouble(2,montant);
            ps1.setDouble(3,commission);
            ps1.executeUpdate();

            ps2.setInt(1,factureId);
            ps2.executeUpdate();

            System.out.println("Paiement enregistré");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void totalPaiements() {
        String sql = "select sum(montant) as total from paiement";

        try (Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("Total des paiement : "+rs.getDouble("total")+" MAD");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void totalCommissions(){
        String sql = "select sum(commission) as total_commission from paiement";

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            if(rs.next()) {
                System.out.println("Total des commissions FinPay : " +
                        rs.getDouble("total_commission")+" MAD");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listerPaiement() throws SQLException {
        String sql = "select * from paiement";

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            System.out.println(
                    rs.getInt("id_paiement")+", "+
                            rs.getInt("id_facture")+", "+
                            rs.getDouble("montant")+", "+
                            rs.getDouble("commission")
            );
        }
    }

    public void paiementPartiel() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer ID Facture : ");
        int idFacure = sc.nextInt();

        System.out.println("Montant payé : ");
        double montant = sc.nextDouble();

        double commission = montant * 0.02;

        Connection con = DBConnection.getConnection();

        String insert = "insert into paiement(id_facture,montant,commission) values (?,?,?)";
        PreparedStatement ps1 = con.prepareStatement(insert);
        ps1.setInt(1,idFacure);
        ps1.setDouble(2,montant);
        ps1.setDouble(3, commission);
        ps1.executeUpdate();

        String totalSql = "select sum(montant) as total from paiement where id_facture=?";
        PreparedStatement ps2 = con.prepareStatement(totalSql);
        ps2.setInt(1,idFacure);
        ResultSet rs = ps2.executeQuery();

        double totalPaye = 0;
        if(rs.next()) {
            totalPaye = rs.getDouble("total");
        }

        String factureSql = "select montant from facture where id_facture=?";
        PreparedStatement ps3 = con.prepareStatement(factureSql);
        ps3.setInt(1, idFacure);
        ResultSet rs2 = ps3.executeQuery();

        double montantFacture = 0;
        if (rs2.next()){
            montantFacture = rs2.getDouble("montant");
        }
        String statut;

        if(totalPaye < montantFacture){
            statut = "PARTIELLE";
        } else {
            statut = "PAYEE";
        }

        String update = "update facture set statut=? where id_facture=?";
        PreparedStatement ps4 = con.prepareStatement(update);
        ps4.setString(1,statut);
        ps4.setInt(2,idFacure);
        ps4.executeUpdate();

        System.out.println("Paiement enregistrer");

    }


}
