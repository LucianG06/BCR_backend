//package com.bcr.backend_bcr.email;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Configuration
//public class MailSenderConfiguration {
//    @Bean("javaMailSender")
//    public JavaMailSender javaMailSender() {
////        JavaMailSenderImpl sender = new JavaMailSenderImpl();
////        sender.setHost("smtp.gmail.com");
////        sender.setPort(587);
////        sender.setUsername("trascaluciangeorge@gmail.com");
////        sender.setPassword("12lucian34!1");
////
////        Properties props = sender.getJavaMailProperties();
////        props.put("mail.transport.protocol", "smtp");
////        props.put("mail.smtp.auth", "true");
////        props.put("mail.smtp.starttls.enable", "true");
////        props.put("mail.debug", "true");
////
////        return sender;
//        return new JavaMailSenderImpl();
//    }
//}
