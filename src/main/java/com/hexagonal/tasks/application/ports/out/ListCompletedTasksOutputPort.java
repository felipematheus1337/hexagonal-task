package com.hexagonal.tasks.application.ports.out;

import com.hexagonal.tasks.application.domain.Task;

import java.util.List;

public interface ListCompletedTasksOutputPort  {

    List<Task> getListaDeTarefasCompletas();
}
