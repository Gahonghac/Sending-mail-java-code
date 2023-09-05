/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_mail;

/**
 *
 * @author flami
 */
public class Java_Mail {

  
    public static void main(String[] args) {
        String hostMail = "smtp.gmail.com";
        String senderMail = "flamingotran1532002@gmail.com";
        String senderPassword = "vhojdnhxgomlnelw";
  
        String subject="Confirming Leave Log Application";
        String recipientMail="totrongphuc239@gmail.com";
        String content="Hi,\n"
                + "You have a leave log application from staff. Please sign in IBM system and confirm this application.\n"
                + "Thanks.";
        EmailSending emailSending = new EmailSending();
        emailSending.sendEmail(hostMail, senderMail, senderPassword, recipientMail, subject, content);
//        emailSending.sendEmail2();
    }
}
