package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.User;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class ResetPassword {

    @FXML
    private TextField codeMail;

    @FXML
    private TextField mailMdpOublie;

    private User userSelected;

    @FXML
    void envoieMail() throws SQLException {

        User user = new User();
        userSelected = user.getUserByMail(mailMdpOublie.getText());
        if (userSelected != null) {
            //email
            Random rand = new Random();
            userSelected.setCode(rand.nextInt(100000, 1000000));
            System.out.println(userSelected.getCode());

            final String fromEmail = "fantome.pirateh@gmail.com"; //requires valid gmail id
            final String password = "xfoojxddksdyaakj"; // correct password for gmail id
            final String toEmail = userSelected.getEmail(); // can be any email id

            System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            //create Authenticator object to pass in Session.getInstance argument
            javax.mail.Authenticator auth = new javax.mail.Authenticator() {
                //override the getPasswordAuthentication method
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body with this code : " + userSelected.getCode());


        }

    }


    private void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("fantome.pirateh@gmail.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("fantome.pirateh@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void verifCode(ActionEvent event) {
        if (codeMail.getText().equals(String.valueOf(userSelected.getCode())))
            HelloApplication.changeScene("updatePassword");
        else {
            System.out.println("erreur");
        }
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("connexionUser");
    }
}
