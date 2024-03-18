package br.com.roberto.temporalpoc.workers;

import br.com.roberto.temporalpoc.workflows.EmailWorkflowImpl;
import br.com.roberto.temporalpoc.workflows.activities.EmailSenderActivityImpl;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TemporalWorkerRunner implements CommandLineRunner {
    private final String taskQueue;
    private final WorkerFactory workerFactory;

    public TemporalWorkerRunner(@Value("${temporal.taskQueue}") String taskQueue, WorkerFactory workerFactory) {
        this.taskQueue = taskQueue;
        this.workerFactory = workerFactory;
    }
    @Override
    public void run(String... args) throws Exception {
        // Criar um worker para workflows
        var worker = workerFactory.newWorker(taskQueue);

        // Registrar a implementação do workflow
        worker.registerWorkflowImplementationTypes(EmailWorkflowImpl.class);

        // Criar um worker para atividades
        var activityWorker = workerFactory.newWorker(taskQueue);

        // Registrar a implementação da atividade
        activityWorker.registerActivitiesImplementations(new EmailSenderActivityImpl());

        // Iniciar o worker
        workerFactory.start();

        System.out.println("Worker iniciado. Escutando a fila de tarefas '" + taskQueue + "'.");
    }
}
