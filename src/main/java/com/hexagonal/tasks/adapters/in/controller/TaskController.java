package com.hexagonal.tasks.adapters.in.controller;

import com.hexagonal.tasks.adapters.in.controller.request.TaskRequest;
import com.hexagonal.tasks.adapters.in.controller.response.TaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TaskController {


    @PostMapping
    public ResponseEntity<TaskResponse> criarTask(@RequestBody TaskRequest request) {

        return null;
    }
}
