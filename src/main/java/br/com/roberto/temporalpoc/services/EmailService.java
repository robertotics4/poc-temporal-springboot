package br.com.roberto.temporalpoc.services;

public interface EmailService {
    String sendEmail(String recipient, String subject, String body);
}
