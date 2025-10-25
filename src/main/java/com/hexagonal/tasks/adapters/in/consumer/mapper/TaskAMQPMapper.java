package com.hexagonal.tasks.adapters.in.consumer.mapper;

import com.hexagonal.tasks.adapters.in.consumer.event.TaskMessageEvent;
import com.hexagonal.tasks.application.domain.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskAMQPMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "completedAt", ignore = true)
    Task toDomain(TaskMessageEvent event);
}
