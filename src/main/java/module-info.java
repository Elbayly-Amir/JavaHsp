module com.example.javahsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.sql;

    opens com.example.javahsp to javafx.fxml;
    exports com.example.javahsp;
    opens modele to javafx.base;
    requires java.mail;
    requires activation;

    exports modele;
    // autres déclarations du module
}


