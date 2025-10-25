package com.hexagonal.tasks.application.ports.out;

import com.hexagonal.tasks.application.domain.Task;

public interface CreateTaskOutputPort {

    void create(Task task);
}
