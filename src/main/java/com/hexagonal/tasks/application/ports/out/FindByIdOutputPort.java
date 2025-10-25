package com.hexagonal.tasks.application.ports.out;

import com.hexagonal.tasks.application.domain.Task;

import java.util.Optional;

public interface FindByIdOutputPort {

    Optional<Task> findById(Long id);
}
