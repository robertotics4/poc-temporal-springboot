package br.com.roberto.temporalpoc.services;

import br.com.roberto.temporalpoc.workflows.EmailWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final WorkflowClient workflowClient;

    @Override
    public String sendEmail(String recipient, String subject, String body) {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue("emailTaskQueue")
                .setWorkflowId("sendEmailWorkflow")
                .build();

        EmailWorkflow workflow = workflowClient.newWorkflowStub(EmailWorkflow.class, options);

        return workflow.sendEmail(recipient, subject, body);
    }
}
