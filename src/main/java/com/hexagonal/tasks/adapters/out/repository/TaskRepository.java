package com.hexagonal.tasks.adapters.out.repository;

import com.hexagonal.tasks.adapters.out.repository.entity.TaskEntity;
import com.hexagonal.tasks.adapters.out.repository.entity.enums.TaskEntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("SELECT t FROM TaskEntity t WHERE t.status = :status")
    List<TaskEntity> findPendingTasks(@Param("status") TaskEntityStatus status);
}
