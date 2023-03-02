package com.example.javahsp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.User;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class ResetPassword {

    @FXML
    private TextField codeMail;

    @FXML
    private TextField mailMdpOublie;

    @FXML
    void envoieMail() throws SQLException {
        User user = new User();
        User userSelected = user.getUserByMail(mailMdpOublie.getText());
        if (userSelected != null){

            Random rand = new Random();
            userSelected.setCode(rand.nextInt(100000,1000000));
            System.out.println(userSelected.getCode());

            final String fromEmail = ""; //requires valid gmail id
            final String password = ""; // correct password for gmail id
            final String toEmail = userSelected.getEmail();

            System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password.toCharArray());
                }
            };
            Session session = Session.getInstance(props);

            sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body with this code : "+ userSelected.getCode());


        }

    }
    private void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("lemoine.sebastien15@gmail.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("lemoine.sebastien15@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void verifCode(ActionEvent event) {

    }


    @FXML
    void retour(ActionEvent event) {
        HelloApplication.changeScene("connexionUser");
    }
}
