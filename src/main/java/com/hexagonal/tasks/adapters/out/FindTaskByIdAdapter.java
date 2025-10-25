package com.hexagonal.tasks.adapters.out;

import com.hexagonal.tasks.adapters.out.repository.TaskRepository;
import com.hexagonal.tasks.adapters.out.repository.mapper.TaskEntityMapper;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.out.FindByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindTaskByIdAdapter implements FindByIdOutputPort {

    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public FindTaskByIdAdapter(TaskRepository repository, TaskEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }
}
