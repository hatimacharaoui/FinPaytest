import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Client client = new Client();
        Prestataire prestataire = new Prestataire();
        Facture facture = new Facture();
        Paiement paiement = new Paiement();
        Statistique statistique = new Statistique();

        int choix1;

        do {
            System.out.println("\n========== FINPAY ==========");
            System.out.println("1. Gestion Clients");
            System.out.println("2. Gestion Prestataires");
            System.out.println("3. Gestion Factures");
            System.out.println("4. Gestion Paiements");
            System.out.println("5. Statistiques");
            System.out.println("0. Quitter");

            System.out.print("Enter votre Choix : ");
            choix1 = sc.nextInt();

            switch (choix1) {

                case 1 -> {
                    int choixClient;
                    do {
                        System.out.println("\n--- Section Client ---");
                        System.out.println("1. Ajouter");
                        System.out.println("2. Modifier");
                        System.out.println("3. Supprimer");
                        System.out.println("4. Lister");
                        System.out.println("5. Rechercher");
                        System.out.println("0. Retour");

                        choixClient = sc.nextInt();

                        switch (choixClient) {
                            case 1 -> client.ajouterClient();
                            case 2 -> client.modifierClient();
                            case 3 -> client.supprimerClient();
                            case 4 -> client.listerClients();
                            case 5 -> client.rechercherClient();
                        }

                    } while (choixClient != 0);
                }


                case 2 -> {
                    int choixPrestataire;
                    do {
                        System.out.println("\n--- Section Prestataire ---");
                        System.out.println("1. Ajouter");
                        System.out.println("2. Modifier");
                        System.out.println("3. Supprimer");
                        System.out.println("4. Lister");
                        System.out.println("5. Rechercher");
                        System.out.println("0. Retour");

                        choixPrestataire = sc.nextInt();

                        switch (choixPrestataire) {
                            case 1 -> prestataire.AjouterP();
                            case 2 -> prestataire.modifierPrestataire();
                            case 3 -> prestataire.supprimerPrestataire();
                            case 4 -> prestataire.listerPrestataires();
                            case 5 -> prestataire.rechercherPrestataire();
                        }

                    } while (choixPrestataire != 0);
                }


                case 3 -> {
                    int choixFacture;
                    do {
                        System.out.println("\n--- Section Facture ---");
                        System.out.println("1. Créer");
                        System.out.println("2. Modifier");
                        System.out.println("3. Supprimer");
                        System.out.println("4. Lister");
                        System.out.println("5. Filtrer par statut");
                        System.out.println("6. Filtrer par prestataire");
                        System.out.println("0. Retour");

                        choixFacture = sc.nextInt();

                        switch (choixFacture) {
                            case 1 -> facture.AjouterFacture();
                            case 2 -> facture.modifieFacture();
                            case 3 -> facture.DeleteFature();
                            case 4 -> facture.afficherFacture();
                            case 5 -> facture.filtrerParStatut();
                            case 6 -> facture.filtrerParPrestataire();
                        }

                    } while (choixFacture != 0);
                }


                case 4 -> {
                    int choixPaiement;
                    do {
                        System.out.println("\n--- Section paiement ---");
                        System.out.println("1. Enregistrer");
                        System.out.println("2. Modifier");
                        System.out.println("3. Lister");
                        System.out.println("4. Paiement partiel");
                        System.out.println("0. Retour");

                        choixPaiement = sc.nextInt();

                        switch (choixPaiement) {
                            case 1 -> paiement.enregistrerPaiement();
                            case 2 -> paiement.modifierPaiement();
                            case 3 -> paiement.listerPaiements();
                            case 4 -> paiement.paiementPartiel();
                        }

                    } while (choixPaiement != 0);
                }


                case 5 -> {
                    int choixStatistique;
                    do {
                        System.out.println("\n--- Section Statistiques ---");
                        System.out.println("1. Total Paiements");
                        System.out.println("2. Total Commissions");
                        System.out.println("3. Factures payées");
                        System.out.println("4. Factures non payées");
                        System.out.println("0. Retour");

                        choixStatistique = sc.nextInt();

                        switch (choixStatistique) {
                            case 1 -> paiement.calculateTotalPaidAmount();
                            case 2 -> paiement.calculateTotalCommissions();
                            case 3 -> facture.getPaidInvoices();
                            case 4 -> facture.getUnpaidInvoices();
                        }

                    } while (choixStatistique != 0);
                }

                default -> System.out.println("Choix invalide ");
            }

        } while (choix1 != 0);
    }
}
