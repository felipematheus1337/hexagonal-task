package com.hexagonal.tasks.adapters.out.repository.mapper;

import com.hexagonal.tasks.adapters.out.repository.entity.TaskEntity;
import com.hexagonal.tasks.application.domain.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskEntityMapper {

    TaskEntity toEntity(Task task);
}
