package com.hexagonal.tasks.adapters.in.controller.mapper;

import com.hexagonal.tasks.adapters.in.controller.request.TaskRequest;
import com.hexagonal.tasks.adapters.in.controller.response.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskRestMapper {

    @Mapping(target = "savedAt", expression = "java(java.time.LocalDate.now())" )
    TaskResponse toResponse(TaskRequest request);
}
