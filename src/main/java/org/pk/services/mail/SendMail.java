package org.pk.services.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {
    public void send(String to, String subject, String text) {
        // SMTP Server information
        String host = "smtp.gmail.com";
        String user = "tempmail@mail.com";
        String password = "*********";

        // mail content
        String from = "" + user;
        String tos = "" + to;
        String subject_ = "" + subject;
        String text_ = "" + text;

        // send mail
        try {
            // SMTP Server information settings
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.trust", host);

            // SMTP Server information settings
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            // Mail content settings
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos));
            message.setSubject(subject_);
            message.setText(text_);

            // send mail
            Transport.send(message);

            System.out.println("Mail was sent Successfully.");

        } catch (AddressException e) {
            System.out.println("\nAddressException Error");
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("\nMessagingException Error");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("\nException Error");
            e.printStackTrace();
        }
    }
}
