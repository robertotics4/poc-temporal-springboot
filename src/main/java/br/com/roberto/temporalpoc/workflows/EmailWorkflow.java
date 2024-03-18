package br.com.roberto.temporalpoc.workflows;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface EmailWorkflow {
    @WorkflowMethod
    String sendEmail(String recipient, String subject, String body);
}
