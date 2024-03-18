package br.com.roberto.temporalpoc.workflows.activities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailSenderActivityImpl implements EmailSenderActivity {
    @Override
    public String sendEmail(String recipient, String subject, String body) {
        log.info(String.format("[WORKFLOW EXECUTION DATA: %s, %s, %s]", recipient, subject, body));
        return String.format("E-mail sobre %s enviado para %s com sucesso! Conteúdo: %s", recipient, subject, body);
    }
}
