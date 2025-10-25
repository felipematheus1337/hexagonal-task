package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.domain.enums.TaskStatus;
import com.hexagonal.tasks.application.ports.out.CreateTaskOutputPort;

import java.time.LocalDate;

public class CreateTaskUseCase {

    private final CreateTaskOutputPort createTaskOutputPort;

    public CreateTaskUseCase(CreateTaskOutputPort createTaskOutputPort) {
        this.createTaskOutputPort = createTaskOutputPort;
    }

    public void create(Task task) {
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDate.now());

        createTaskOutputPort.create(task);
    }

}
