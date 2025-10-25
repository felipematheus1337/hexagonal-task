package com.hexagonal.tasks.adapters.out;

import com.hexagonal.tasks.adapters.exception.AdapterException;
import com.hexagonal.tasks.adapters.out.repository.TaskRepository;
import com.hexagonal.tasks.adapters.out.repository.entity.TaskEntity;
import com.hexagonal.tasks.adapters.out.repository.entity.enums.TaskEntityStatus;
import com.hexagonal.tasks.adapters.out.repository.mapper.TaskEntityMapper;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.domain.enums.TaskStatus;
import com.hexagonal.tasks.application.ports.out.FindByIdOutputPort;
import com.hexagonal.tasks.application.ports.out.FinishTaskOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FinishTaskAdapter implements FinishTaskOutputPort {

    private final TaskRepository taskRepository;
    private final FindByIdOutputPort findByIdOutputPort;
    private final TaskEntityMapper mapper;

    public FinishTaskAdapter(TaskRepository taskRepository, FindByIdOutputPort findByIdOutputPort, TaskEntityMapper mapper) {
        this.taskRepository = taskRepository;
        this.findByIdOutputPort = findByIdOutputPort;
        this.mapper = mapper;
    }

    @Override
    public void finalizar(Long id) {
        Optional<Task> task = findByIdOutputPort.findById(id);
        if (task.isEmpty()) throw new AdapterException("Task não encontrada para finalizar.");
        TaskEntity entity = mapper.toEntity(task.get());
        entity.setStatus(TaskEntityStatus.COMPLETED);
        taskRepository.save(entity);

    }
}
