package com.employee.util;
import javax.mail.*;
import javax.mail.internet.*;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.util.Properties;

public class EmailService {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String USERNAME = "daali.22.ssss@gmail.com";
    private static final String PASSWORD = "gcmulohlmonjhuck";

    public static void sendEmail(String to, String subject, String body) throws MessagingException {

        // Set up properties for the SMTP connection
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);

        // Disable SSL certificate validation
        properties.put("mail.smtp.ssl.trust", "*");

        // Custom SSL Factory to trust all certificates
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };

            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            SSLSocketFactory sslSocketFactory = sc.getSocketFactory();
            properties.put("mail.smtp.ssl.socketFactory", sslSocketFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up session
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Create email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USERNAME));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        // Send email
        Transport.send(message);
        System.out.println("Email sent successfully!");
    }
}