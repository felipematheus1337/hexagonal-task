package com.hexagonal.tasks.adapters.out.repository;

import com.hexagonal.tasks.adapters.out.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
