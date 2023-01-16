package com.example.javahsp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {

    private static Stage stage;
    @Override
    public void start(Stage firstStage) throws IOException {
        stage=firstStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HSP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



    public static void changeScene(String fichierFxml)  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fichierFxml+".fxml"));
        Scene scene = null;
        try {

            scene = new Scene(fxmlLoader.load());
            stage.setTitle("Connexion");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void changeScene(String fichierFxml, Object controller)  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fichierFxml+".fxml"));
        Scene scene = null;
        try {

            fxmlLoader.setController(controller);
            scene = new Scene(fxmlLoader.load());
            stage.setTitle("Inscription");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

