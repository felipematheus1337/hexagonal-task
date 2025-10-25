package com.hexagonal.tasks.adapters.in.controller.mapper;

import com.hexagonal.tasks.adapters.in.controller.request.TaskRequest;
import com.hexagonal.tasks.adapters.in.controller.response.TaskResponse;
import com.hexagonal.tasks.application.domain.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskRestMapper {

    @Mapping(target = "savedAt", expression = "java(java.time.LocalDate.now())" )
    TaskResponse toResponse(TaskRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "completedAt", ignore = true)
    Task toDomain(TaskRequest request);

    @Mapping(target = "savedAt", source = "completedAt")
    TaskResponse domainToResponse(Task task);
}
