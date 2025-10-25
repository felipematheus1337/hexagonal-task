package com.hexagonal.tasks.application.ports.in;

import com.hexagonal.tasks.application.domain.Task;

public interface CreateTaskInputPort {

    void create(Task task);
}
