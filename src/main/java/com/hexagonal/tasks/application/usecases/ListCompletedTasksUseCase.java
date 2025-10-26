package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.in.ListCompletedTasksInputPort;
import com.hexagonal.tasks.application.ports.out.ListCompletedTasksOutputPort;

import java.util.List;

public class ListCompletedTasksUseCase implements ListCompletedTasksInputPort {

    private final ListCompletedTasksOutputPort listCompletedTasksOutputPort;

    public ListCompletedTasksUseCase(ListCompletedTasksOutputPort listCompletedTasksOutputPort) {
        this.listCompletedTasksOutputPort = listCompletedTasksOutputPort;
    }

    @Override
    public List<Task> execute() {

        return listCompletedTasksOutputPort.getListaDeTarefasCompletas();
    }
}
