/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.email;

import Model.dao.TicketDAO;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author Pham Thinh
 */
public class SendTicket {
    public void sendTicket(String email, String OrderTicketID) {
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
            TicketDAO t = new TicketDAO();
            ArrayList<String[]> ticketList = t.getTicketByOrder_ID(OrderTicketID);

            for (String[] ticket : ticketList) {
                String content = "<html><body>\n"
                        + "    <div style=\"background-color: orangered;max-width: 500px;min-height: 400px;\">\n"
                        + "        <form action=\"\">\n"
                        + "            <div>\n"
                        + "                <h1>Vé điện tử và xác nhận hành trình</h1>\n"
                        + "            </div>\n"
                        + "            <div>\n"
                        + "                <h3 style=\"background-color: gray;padding: 10px 10px; \">MÃ VÉ: " + ticket[0] + "</h3>\n"
                        + "            </div>\n"
                        + "            <div>\n"
                        + "                <h3 style=\"background-color: gray;padding: 10px 10px; \">Thông tin hành khách</h3>\n"
                        + "                <table>\n"
                        + "                    <tr>\n"
                        + "                        <td>Họ và Tên</td>\n"
                        + "                        <td>" + ticket[8] + "</td>\n"
                        + "                    </tr>\n"
                        + "                </table>\n"
                        + "            </div>\n"
                        + "            <div>\n"
                        + "                <h3 style=\"background-color: gray;padding: 10px 10px;\">Thông tin chuyến bay</h3>\n"
                        + "                <table>\n"
                        + "                    <tr>\n"
                        + "                        <td>Loại vé</td>\n"
                        + "                        <td>" + ticket[9] + "</td>\n"
                        + "                    </tr>\n"
                        + "                    <tr>\n"
                        + "                        <td>Cổng</td>\n"
                        + "                        <td>" + ticket[6] + "</td>\n"
                        + "                    </tr>\n"
                        + "                    <tr>\n"
                        + "                        <td>Số Ghế</td>\n"
                        + "                        <td>" + ticket[1] + "</td>\n"
                        + "                    </tr>\n"
                        + "                    <tr>\n"
                        + "                        <td>Điểm đi</td>\n"
                        + "                        <td>" + ticket[4] + "</td>\n"
                        + "                    </tr>\n"
                        + "                    <tr>\n"
                        + "                        <td>Lúc</td>\n"
                        + "                        <td>" + ticket[3] + " " + ticket[2] + "</td>\n"
                        + "                    </tr>\n"
                        + "                    <tr>\n"
                        + "                        <td>Điểm đến</td>\n"
                        + "                        <td>" + ticket[5] + "</td>\n"
                        + "                    </tr>\n"
                        + "                    <tr>\n"
                        + "                        <td>Hành Lý</td>\n"
                        + "                        <td>" + ticket[7] + "</td>\n"
                        + "                    </tr>\n"
                        + "                </table>\n"
                        + "            </div>\n"
                        + "        </form>\n"
                        + "    </div>\n"
                        + "</body></html>";
                
                System.out.println(content);
                mess.setContent(content, "text/html;charset=UTF-8");
                Transport.send(mess);
            }

        } catch (SQLException | MessagingException e) {
        }
    }
    
    public static void main(String[] args) {
        SendTicket s = new SendTicket();
        s.sendTicket("tonykim12123@gmail.com", "etdhdd");
               
    }
}
