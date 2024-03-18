package br.com.roberto.temporalpoc.workflows.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface EmailSenderActivity {
    @ActivityMethod
    String sendEmail(String recipient, String subject, String body);
}
