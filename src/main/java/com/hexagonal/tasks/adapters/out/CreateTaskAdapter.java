package com.hexagonal.tasks.adapters.out;

import com.hexagonal.tasks.adapters.out.repository.TaskRepository;
import com.hexagonal.tasks.adapters.out.repository.entity.TaskEntity;
import com.hexagonal.tasks.adapters.out.repository.mapper.TaskEntityMapper;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.out.CreateTaskOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskAdapter implements CreateTaskOutputPort {

    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public CreateTaskAdapter(TaskRepository repository, TaskEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(Task task) {
        TaskEntity entity = mapper.toEntity(task);
        repository.save(entity);
    }
}
