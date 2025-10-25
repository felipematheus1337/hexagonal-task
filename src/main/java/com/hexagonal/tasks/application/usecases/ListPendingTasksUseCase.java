package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.in.ListPendingTasksInputPort;
import com.hexagonal.tasks.application.ports.out.ListPendingTasksOutputPort;

import java.util.List;

public class ListPendingTasksUseCase implements ListPendingTasksInputPort {

    private final ListPendingTasksOutputPort listPendingTasksOutputPort;

    public ListPendingTasksUseCase(ListPendingTasksOutputPort listPendingTasksOutputPort) {
        this.listPendingTasksOutputPort = listPendingTasksOutputPort;
    }

    @Override
    public List<Task> findPendingTasks() {

        return listPendingTasksOutputPort.execute();
    }
}
