import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FacturePDF {

    public static void genererFactureDepuisDB() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Entrer ID Facture : ");
        int idFacture = sc.nextInt();

        String sql = "SELECT f.id_facture, f.montant, f.statut, " +
                "c.nom AS nom_client, p.nom AS nom_prestataire " +
                "FROM facture f " +
                "JOIN client c ON f.id_client = c.id_client " +
                "JOIN prestataire p ON f.id_prestataire = p.id_prestataire " +
                "WHERE f.id_facture=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFacture);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // Récupération données
                String nomClient = rs.getString("nom_client");
                String nomPrestataire = rs.getString("nom_prestataire");
                double montant = rs.getDouble("montant");
                String statut = rs.getString("statut");

                // Création PDF
                Document document = new Document();
                PdfWriter.getInstance(document,
                        new FileOutputStream("facture_" + idFacture + ".pdf"));

                document.open();

                document.add(new Paragraph("===== FACTURE FinPay ====="));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("ID Facture : " + idFacture));
                document.add(new Paragraph("Client : " + nomClient));
                document.add(new Paragraph("Prestataire : " + nomPrestataire));
                document.add(new Paragraph("Montant : " + montant + " MAD"));
                document.add(new Paragraph("Statut : " + statut));

                document.close();

                System.out.println("✅ Facture PDF générée avec succès !");

            } else {
                System.out.println(" Facture introuvable !");
            }
        }
    }
    }