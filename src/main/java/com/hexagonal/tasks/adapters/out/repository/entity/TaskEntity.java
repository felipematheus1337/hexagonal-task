package com.hexagonal.tasks.adapters.out.repository.entity;

import com.hexagonal.tasks.adapters.out.repository.entity.enums.TaskEntityStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskEntityStatus status;
    private LocalDate createdAt;

    private LocalDate completedAt;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String description, TaskEntityStatus status, LocalDate createdAt, LocalDate completedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskEntityStatus getStatus() {
        return status;
    }

    public void setStatus(TaskEntityStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDate completedAt) {
        this.completedAt = completedAt;
    }
}
