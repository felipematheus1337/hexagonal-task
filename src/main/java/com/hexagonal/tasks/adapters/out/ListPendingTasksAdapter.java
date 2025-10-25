package com.hexagonal.tasks.adapters.out;

import com.hexagonal.tasks.adapters.out.repository.TaskRepository;
import com.hexagonal.tasks.adapters.out.repository.entity.enums.TaskEntityStatus;
import com.hexagonal.tasks.adapters.out.repository.mapper.TaskEntityMapper;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.out.ListPendingTasksOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListPendingTasksAdapter implements ListPendingTasksOutputPort {

    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public ListPendingTasksAdapter(TaskRepository repository, TaskEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Task> execute() {
        return repository.findPendingTasks(TaskEntityStatus.PENDING)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toUnmodifiableList());
    }
}
