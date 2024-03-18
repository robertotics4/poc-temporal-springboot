package br.com.roberto.temporalpoc.workflows;

import br.com.roberto.temporalpoc.workflows.activities.EmailSenderActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class EmailWorkflowImpl implements EmailWorkflow {
    private final EmailSenderActivity emailSender = Workflow.newActivityStub(
            EmailSenderActivity.class,
            ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(10)).build()
    );

    @Override
    public String sendEmail(String recipient, String subject, String body) {
        return emailSender.sendEmail(recipient, subject, body);
    }
}
