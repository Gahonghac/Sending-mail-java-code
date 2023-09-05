/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author flami
 */
public class EmailSending {

    private String hostMail;
    private String senderMail;
    private String senderPassword;

    public EmailSending(String hostMail, String sennderMail, String senderPassword) {
        this.hostMail = hostMail;
        this.senderMail = sennderMail;
        this.senderPassword = senderPassword;
    }

    public EmailSending() {
    }

    public String getHostMail() {
        return hostMail;
    }

    public void setHostMail(String hostMail) {
        this.hostMail = hostMail;
    }

    public String getSennderMail() {
        return senderMail;
    }

    public void setSennderMail(String sennderMail) {
        this.senderMail = sennderMail;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }
    
    public String getNameFromMail(String mail){
        String name="";
        int posMail = mail.indexOf('@');
        name = mail.substring(0,posMail);
        return name;
    }
    
    public void sendEmail(String hostMail, String sennderMail, String senderPassword,
            String recipientMail, String subject, String content) {
        // Config information of mail sender
        String host = hostMail;
        String sender = sennderMail;
        String password = senderPassword;

        // Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", hostMail);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, senderPassword);
            }
        });
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(recipientMail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientMail));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
//            System.out.println("Sending mail successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
