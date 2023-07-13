package Control.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public void sendEmail(String email) {
        //boolean test = false;

        String toEmail = email;
        final String fromEmail = "thinhph9@gmail.com";
        final String password = "lbjlgbpjzhvwfnmv";

        try {

            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "587");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.tsl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message mess = new MimeMessage(session);

            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("INFORMATION TICKET");
            mess.setContent(""
                    + "<!DOCTYPE html>\r\n"
                    + "<html>\r\n"
                    + "<head>\r\n"
                    + "    <meta charset=\"UTF-8\">\r\n"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"\r\n>"
                    + "</head>"
                    + "<body>\r\n"
                    + "<h3>FPT-Airlines Xin Chào!</h3>\r\n"
                    + "</br>\r\n"
                    + " <p>Quý khách vui lòng xác nhận <a href=\"http://localhost:8080/FPT/payment.jsp\">Tại đây</a></p>\r\n"
                    + "</body>\r\n"
                    + "</html>", "text/html;charset=UTF-8");

            Transport.send(mess);
            //test = true;

        } catch (Exception e) {
        }

        //return test;
    }

    public void sendEmailCancel(String email) {
        //boolean test = false;

        String toEmail = email;
        final String fromEmail = "thinhph9@gmail.com";
        final String password = "lbjlgbpjzhvwfnmv";

        try {

            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "587");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.tsl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message mess = new MimeMessage(session);

            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("INFORMATION TICKET");
            mess.setContent(""
                    + "<!DOCTYPE html>\r\n"
                    + "<html>\r\n"
                    + "<head>\r\n"
                    + "    <meta charset=\"UTF-8\">\r\n"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"\r\n>"
                    + "</head>"
                    + "<body>\r\n"
                    + "<h3>FPT-Airlines Xin Chào!</h3>\r\n"
                    + "</br>\r\n"
                    + " <p>Vé quý khách đã được được hủy.Cảm ơn quý khách đã sử dụng dịch vụ!</p>\r\n"
                    + "</body>\r\n"
                    + "</html>", "text/html;charset=UTF-8");

            Transport.send(mess);
            //test = true;

        } catch (Exception e) {
        }
    }
}
