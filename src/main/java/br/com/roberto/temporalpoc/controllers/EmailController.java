package br.com.roberto.temporalpoc.controllers;

import br.com.roberto.temporalpoc.model.dto.SendMailDTO;
import br.com.roberto.temporalpoc.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody SendMailDTO sendMailDTO) {
        String result = emailService.sendEmail(sendMailDTO.recipient(), sendMailDTO.subject(), sendMailDTO.body());

        if (!Objects.isNull(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(400).body("Falha no envio do e-mail");
        }
    }
}
