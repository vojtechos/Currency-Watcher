package cz.spsmb.tests;

import cz.spsmb.service.mail.Mail;
import cz.spsmb.service.mail.MailService;
import cz.spsmb.service.mail.SimpleMailService;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailTest {

    public static void Start() {

        try(InputStream input = MailTest.class.getClassLoader().getResourceAsStream("config.properties")){

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            Properties prop = new Properties();
            prop.load(input);
            Mail mailSend = new Mail();
            mailSend.setTo("gg.polacek@gmail.com"); // default: christian.abraham@email.cz
            mailSend.setSubject("Mailsender Test");
            mailSend.setBody("Success");
            MailService mailService = new SimpleMailService(prop);
            mailService.send(mailSend);

            /*
                Mail mailSend2 = new Mail();
                mailSend2.setTo("minecaft0018@email.cz");
                mailSend2.setSubject("Mailsender Test");
                mailSend2.setBody("Success2");
                mailService.send(mailSend2);
            */
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
