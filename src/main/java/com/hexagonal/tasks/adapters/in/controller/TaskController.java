package com.hexagonal.tasks.adapters.in.controller;

import com.hexagonal.tasks.adapters.in.controller.mapper.TaskRestMapper;
import com.hexagonal.tasks.adapters.in.controller.request.TaskRequest;
import com.hexagonal.tasks.adapters.in.controller.response.TaskResponse;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.in.CreateTaskInputPort;
import com.hexagonal.tasks.application.ports.in.FinishTaskInputPort;
import com.hexagonal.tasks.application.ports.in.ListPendingTasksInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class TaskController {

    private final CreateTaskInputPort createTaskInputPort;
    private final FinishTaskInputPort finishTaskInputPort;
    private final ListPendingTasksInputPort listPendingTasksInputPort;
    private final TaskRestMapper mapper;

    public TaskController(CreateTaskInputPort createTaskInputPort, FinishTaskInputPort finishTaskInputPort, ListPendingTasksInputPort listPendingTasksInputPort, TaskRestMapper mapper) {
        this.createTaskInputPort = createTaskInputPort;
        this.finishTaskInputPort = finishTaskInputPort;
        this.listPendingTasksInputPort = listPendingTasksInputPort;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> criarTask(@RequestBody TaskRequest request) {

        Task task = mapper.toDomain(request);
        createTaskInputPort.create(task);
        TaskResponse response = mapper.toResponse(request);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> finalizarTask(@PathVariable("id") final Long id) {
        finishTaskInputPort.finalizar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> listarPendingTasks() {
        List<Task> tasks = listPendingTasksInputPort.findPendingTasks();
        var response = tasks.stream()
                .map(mapper::domainToResponse)
                .collect(Collectors.toUnmodifiableList());
        return ResponseEntity.ok(response);

    }

}
