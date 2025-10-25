package com.hexagonal.tasks.adapters.in.consumer;

import com.hexagonal.tasks.adapters.in.consumer.event.TaskMessageEvent;
import com.hexagonal.tasks.adapters.in.consumer.mapper.TaskAMQPMapper;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.in.CreateTaskInputPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskConsumer {

    private final CreateTaskInputPort createTaskInputPort;
    private final TaskAMQPMapper mapper;

    public CreateTaskConsumer(CreateTaskInputPort createTaskAMQPInputPort, CreateTaskInputPort createTaskInputPort, TaskAMQPMapper mapper) {
        this.createTaskInputPort = createTaskInputPort;
        this.mapper = mapper;
    }


    @RabbitListener(queues = "fila.inserir",
            concurrency = "3-10")
    public void consume(@Payload TaskMessageEvent taskEvent) {
        Task task = mapper.toDomain(taskEvent);
        createTaskInputPort.create(task);
    }

}
