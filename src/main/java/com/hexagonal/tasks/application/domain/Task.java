package com.hexagonal.tasks.application.domain;

import com.hexagonal.tasks.application.domain.enums.TaskStatus;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    
    private Long id;
    private String description;
    private TaskStatus status;
    private LocalDate createdAt;
    private LocalDate completedAt;

    public Task() {
        this.createdAt = LocalDate.now();
    }

    public Task(Long id, String description, LocalDate createdAt, TaskStatus status, LocalDate completedAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", completedAt=" + completedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description) && status == task.status && Objects.equals(createdAt, task.createdAt) && Objects.equals(completedAt, task.completedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status, createdAt, completedAt);
    }
}
