package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.model.ApplicationForm;
import org.niu.leaves.jsp.servlet.utility.Messages;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sunny on 9/03/2017.
 */
public class EmailService {

    /**
     * Email session instance used for sending emails
     */

    public String sendEmail(ApplicationForm applicationForm) throws IOException, MessagingException {
        Properties props = new Properties();
        InputStream input = null;

        input = this.getClass().getResourceAsStream("/config/config.properties");
        props.load(input);
        props.put("mail.transport.protocol", props.getProperty("TRANSPORT_PROTOCOL"));
        props.put("mail.smtp.auth", props.getProperty("SMTPS_AUTH"));
        props.put("mail.smtp.starttls.enable", props.getProperty("SMTP_STARTTLES"));
        props.put("mail.smtp.host", props.getProperty("SMTP_HOST"));
        props.put("mail.smtp.port", props.getProperty("SMTP_POST"));
        props.put("mail.smtp.ssl.enable", props.getProperty("SMTP_SSL"));
        props.put("mail.smtp.socketFactory.class", props.getProperty("SMTP_SOCKETFACTORY_CLASS"));
        props.put("mail.smtp.socketFactory.fallback", props.getProperty("SMTP_SOCKETFACTORY_FALLBACK"));

        String senderEmailId = applicationForm.getManagerEmail();
        String senderEmailPassword = applicationForm.getManagerEmailPassword();
        String receiverEmailId = applicationForm.getUserEmail();
        Authenticator authenticator = new SMTPAuthenticator(senderEmailId, senderEmailPassword);
        Session mailSession = Session.getInstance(props, authenticator);
        Message msg = new MimeMessage(mailSession);

        //Send email from sender to receiver

        msg.setFrom(new InternetAddress(senderEmailId));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmailId));
        msg.setSubject("Apply for leaves");

        String message = "<!DOCTYPE html>";
        message += "<html><head><h1 align=center>Leave Application</h1>";
        String leaveApplication = "";
        String name = applicationForm.getName();
        String sickType = applicationForm.getApplicationLeaveType();
        String manager = applicationForm.getManagerName();
        String reason = applicationForm.getReason();
        //String department = applicationForm.getDepartment();
        String status = applicationForm.getStatus();
        message += "<body><div><table align=center border=1>" +
                "<tr><th>Applicant Name :</th>" + name + "</tr>" +
                "<tr><th>Sick Type :</th>" + sickType + "</tr>" +
                "<tr><th>Reason :</th>" + reason + "</tr>" +
                "<tr><th>Manager :</th>" + manager + "</tr>" +
                "<tr><th>Status</th>" + status + "</tr>";
        int size = applicationForm.getLeaveList().size();
        for (int i = 0; i < size; i++) {
            String fromDate = applicationForm.getLeaveList().get(i).getFromDate();
            String toDate = applicationForm.getLeaveList().get(i).getToDate();
            String totalDays = applicationForm.getLeaveList().get(i).getTotalDays();
            leaveApplication = leaveApplication + " Name: " + name + " SickType: " +
                    sickType + " fromdate: " + fromDate + " todate: " + toDate +
                    "totalDays: " + totalDays + " reason: " + reason + "manager: " + manager + ";";
            message += "<tr><th>FromDate :</th>" + fromDate + "</tr>";
            message += "<tr><th>ToDate :</th>" + toDate + "</tr>";
            message += "<tr><th>Days :</th>" + totalDays + "</tr>";
        }
        message += "</table></div></body>";
        message += "</html>";

        msg.setContent(message, "text/html");
        //message.setText(sw.toString());
        Transport transport = mailSession.getTransport();

        transport.connect(props.getProperty("SMTP_HOST"), senderEmailId, senderEmailPassword);
        transport.send(msg);
        transport.close();
        return "Okay";
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        private String username;
        private String password;

        SMTPAuthenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
}
