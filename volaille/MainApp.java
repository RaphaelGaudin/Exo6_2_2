package com.volaille.volaille;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Elevage elevage = new Elevage();
    private TextField prixKgCanardField = new TextField();
    private TextField poidsAbattageCanardField = new TextField();
    private TextField prixKgPouletField = new TextField();
    private TextField poidsAbattagePouletField = new TextField();
    private TextField poidsVolailleField = new TextField();
    private TextField nombreIdentiqueField = new TextField();
    private TextArea outputArea = new TextArea();
    private Label labelVolaillesAAbattre = new Label("IDs des Volailles à abattre : ");
    private Label labelVolaillesSousPoidsAbattage = new Label("IDs des Volailles sous le poids d'abattage : ");



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion de l'élevage de volailles");

        // Création des éléments graphiques
        Label prixKgCanardLabel = new Label("Prix au kg pour les canards :");
        Label poidsAbattageCanardLabel = new Label("Poids d'abattage des canards :");
        Label prixKgPouletLabel = new Label("Prix au kg pour les poulets :");
        Label poidsAbattagePouletLabel = new Label("Poids d'abattage des poulets :");
        Label poidsVolailleLabel = new Label("Poids de la volaille :");
        Label nombreIdentiqueLabel = new Label("Nombre de volailles identiques :");

        Button ajouterVolailleButton = new Button("Ajouter Volaille");
        Button ajouterCanardsIdentiquesButton = new Button("Ajouter Canards Identiques");
        Button ajouterPouletsIdentiquesButton = new Button("Ajouter Poulets Identiques");

        // Mise en place des éléments graphiques dans une grille
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        grid.add(prixKgCanardLabel, 0, 0);
        grid.add(prixKgCanardField, 1, 0);
        grid.add(poidsAbattageCanardLabel, 0, 1);
        grid.add(poidsAbattageCanardField, 1, 1);
        grid.add(prixKgPouletLabel, 0, 2);
        grid.add(prixKgPouletField, 1, 2);
        grid.add(poidsAbattagePouletLabel, 0, 3);
        grid.add(poidsAbattagePouletField, 1, 3);



        grid.add(poidsVolailleLabel, 0, 4);
        grid.add(poidsVolailleField, 1, 4);
        grid.add(nombreIdentiqueLabel, 0, 5);
        grid.add(nombreIdentiqueField, 1, 5);

        grid.add(ajouterVolailleButton, 0, 6);
        grid.add(ajouterCanardsIdentiquesButton, 1, 6);
        grid.add(ajouterPouletsIdentiquesButton, 2, 6);

        outputArea.setEditable(false);
        grid.add(outputArea, 0, 7, 3, 1);

        // Gestionnaires d'événements
        ajouterVolailleButton.setOnAction(e -> ajouterVolaille());
        ajouterCanardsIdentiquesButton.setOnAction(e -> ajouterCanardsIdentiques());
        ajouterPouletsIdentiquesButton.setOnAction(e -> ajouterPouletsIdentiques());

        grid.add(labelVolaillesAAbattre, 0, 10, 3, 1);
        grid.add(labelVolaillesSousPoidsAbattage, 0, 11, 3, 1);

        // Création de la scène
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void ajouterVolaille() {
        try {
            double poidsVolaille = Double.parseDouble(poidsVolailleField.getText());
            int nombreIdentique = Integer.parseInt(nombreIdentiqueField.getText());
            String typeVolaille = askTypeVolaille();

            if (typeVolaille != null) {
                for (int i = 0; i < nombreIdentique; i++) {
                    if (typeVolaille.equals("Canard")) {
                        Canard canard = new Canard(elevage.getProchainID(), poidsVolaille);
                        if (canard.getPoids() >= Double.parseDouble(poidsAbattageCanardField.getText())) {
                            elevage.ajouterCanardAAbattre(canard);
                        } else {
                            elevage.ajouterCanardSousPoidsAbattage(canard);
                        }
                    } else if (typeVolaille.equals("Poulet")) {
                        Poulet poulet = new Poulet(elevage.getProchainID(), poidsVolaille);
                        if (poulet.getPoids() >= Double.parseDouble(poidsAbattagePouletField.getText())) {
                            elevage.ajouterPouletAAbattre(poulet);
                        } else {
                            elevage.ajouterPouletSousPoidsAbattage(poulet);
                        }
                    }
                }

                afficherVolailles();
            }
        } catch (NumberFormatException e) {
            afficherMessageErreur("Veuillez saisir des nombres valides.");
        }
    }

    private void ajouterCanardsIdentiques() {
        try {
            double poidsCanards = Double.parseDouble(poidsVolailleField.getText());
            int nombreIdentique = Integer.parseInt(nombreIdentiqueField.getText());
            Canard canard = new Canard(elevage.getProchainID(), poidsCanards);

            for (int i = 0; i < nombreIdentique; i++) {
                elevage.enregistrerVolaille(canard);
            }

            if (poidsCanards >= Double.parseDouble(poidsAbattageCanardField.getText())) {
                elevage.ajouterCanardAAbattre(canard);
            }
            else {
                elevage.ajouterCanardSousPoidsAbattage(canard);
            }

            afficherVolailles();
            afficherVolaillesAAbattre(); // Mettez à jour le label avec la liste des IDs des volailles à abattre
            afficherVolaillesSousPoidsAbattage(); // Mettez à jour le label avec la liste des IDs des volailles sous poids
        } catch (NumberFormatException e) {
            afficherMessageErreur("Veuillez saisir des nombres valides.");
        }
    }

    private void ajouterPouletsIdentiques() {
        try {
            double poidsPoulet = Double.parseDouble(poidsVolailleField.getText());
            int nombreIdentique = Integer.parseInt(nombreIdentiqueField.getText());
            Poulet poulet = new Poulet(elevage.getProchainID(), poidsPoulet);

            for (int i = 0; i < nombreIdentique; i++) {
                elevage.enregistrerVolaille(poulet);
            }

            if (poidsPoulet >= Double.parseDouble(poidsAbattagePouletField.getText())) {
                elevage.ajouterPouletAAbattre(poulet);
            }
            else {
                elevage.ajouterPouletSousPoidsAbattage(poulet);
            }

            afficherVolailles();
            afficherVolaillesAAbattre(); // Mettez à jour le label avec la liste des IDs des volailles à abattre
            afficherVolaillesSousPoidsAbattage(); // Mettez à jour le label avec la liste des IDs des volailles sous poids
        } catch (NumberFormatException e) {
            afficherMessageErreur("Veuillez saisir des nombres valides.");
        }
    }

    private void afficherVolailles() {
        outputArea.clear();
        for (Volaille volaille : elevage.getAnimaux()) {
            String typeVolaille = volaille instanceof Poulet ? "Poulet" : "Canard";
            outputArea.appendText("Type: " + typeVolaille + ", ID: " + volaille.getNumeroIdentification() + ", Poids: " + volaille.getPoids() + "\n");
        }
    }

    private void afficherVolaillesAAbattre() {
        StringBuilder volaillesAAbattreText = new StringBuilder("IDs des Volailles à abattre : ");

        for (Canard canard : elevage.getCanardsAAbattre()) {
            volaillesAAbattreText.append(canard.getNumeroIdentification()).append(" ");
        }

        for (Poulet poulet : elevage.getPouletsAAbattre()) {
            volaillesAAbattreText.append(poulet.getNumeroIdentification()).append(" ");
        }

        elevage.afficherVolaillesAAbattre();

        labelVolaillesAAbattre.setText(volaillesAAbattreText.toString());
    }

    private void afficherVolaillesSousPoidsAbattage() {
        StringBuilder volaillesSousPoidsAbattageText = new StringBuilder("IDs des Volailles sous poids d'abattage : ");

        for (Canard canard : elevage.getCanardsSousPoidsAbattage()) {
            volaillesSousPoidsAbattageText.append(canard.getNumeroIdentification()).append(" ");
        }

        for (Poulet poulet : elevage.getPouletsSousPoidsAbattage()) {
            volaillesSousPoidsAbattageText.append(poulet.getNumeroIdentification()).append(" ");
        }

        elevage.afficherVolaillesSousPoidsAbattage();

        labelVolaillesSousPoidsAbattage.setText(volaillesSousPoidsAbattageText.toString());
    }

    private void afficherMessageErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String askTypeVolaille() {
        TextInputDialog dialog = new TextInputDialog("Canard");
        dialog.setTitle("Saisir le type de volaille");
        dialog.setHeaderText("Entrez le type de volaille (Canard ou Poulet) :");
        dialog.setContentText("Type de volaille:");

        // Attend que l'utilisateur entre un type de volaille valide
        String result = dialog.showAndWait().orElse(null);
        if (result != null && (result.equalsIgnoreCase("Canard") || result.equalsIgnoreCase("Poulet"))) {
            return result;
        }
        return null;
    }

}
