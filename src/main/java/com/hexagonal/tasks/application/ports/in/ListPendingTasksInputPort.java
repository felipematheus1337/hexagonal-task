package com.hexagonal.tasks.application.ports.in;

import com.hexagonal.tasks.application.domain.Task;

import java.util.List;

public interface ListPendingTasksInputPort {

    List<Task> findPendingTasks();
}
