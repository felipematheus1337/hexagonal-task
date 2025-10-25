package com.hexagonal.tasks.adapters.in.controller;

import com.hexagonal.tasks.adapters.in.controller.mapper.TaskRestMapper;
import com.hexagonal.tasks.adapters.in.controller.request.TaskRequest;
import com.hexagonal.tasks.adapters.in.controller.response.TaskResponse;
import com.hexagonal.tasks.application.domain.Task;
import com.hexagonal.tasks.application.ports.in.CreateTaskInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TaskController {

    private final CreateTaskInputPort createTaskInputPort;
    private final TaskRestMapper mapper;

    public TaskController(CreateTaskInputPort createTaskInputPort, TaskRestMapper mapper) {
        this.createTaskInputPort = createTaskInputPort;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> criarTask(@RequestBody TaskRequest request) {

        Task task = mapper.toDomain(request);
        createTaskInputPort.create(task);
        TaskResponse response = mapper.toResponse(request);

        return ResponseEntity.ok(response);
    }
}
