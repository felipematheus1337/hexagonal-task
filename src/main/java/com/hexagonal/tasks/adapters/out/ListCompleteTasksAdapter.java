package com.hexagonal.tasks.adapters.out;

import com.hexagonal.tasks.adapters.out.repository.TaskRepository;
import com.hexagonal.tasks.adapters.out.repository.entity.enums.TaskEntityStatus;
import com.hexagonal.tasks.adapters.out.repository.mapper.TaskEntityMapper;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.out.ListCompletedTasksOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListCompleteTasksAdapter implements ListCompletedTasksOutputPort {

    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public ListCompleteTasksAdapter(TaskRepository repository, TaskEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Task> getListaDeTarefasCompletas() {
        return repository.findTasksByStatus(TaskEntityStatus.COMPLETED)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toUnmodifiableList());
    }
}
