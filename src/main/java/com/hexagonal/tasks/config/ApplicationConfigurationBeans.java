package com.hexagonal.tasks.config;

import com.hexagonal.tasks.adapters.out.*;
import com.hexagonal.tasks.application.usecases.CreateTaskUseCase;
import com.hexagonal.tasks.application.usecases.FinishTaskUseCase;
import com.hexagonal.tasks.application.usecases.ListCompletedTasksUseCase;
import com.hexagonal.tasks.application.usecases.ListPendingTasksUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurationBeans {

    @Bean
    public CreateTaskUseCase createTaskUseCase(CreateTaskAdapter adapter) {
        return new CreateTaskUseCase(adapter);
    }

    @Bean
    public FinishTaskUseCase finishTaskUseCase(FinishTaskAdapter finishTaskAdapter) {
        return new FinishTaskUseCase(finishTaskAdapter);
    }

    @Bean
    public ListPendingTasksUseCase listPendingTasksUseCase(ListPendingTasksAdapter adapter) {
        return new ListPendingTasksUseCase(adapter);
    }

    @Bean
    public ListCompletedTasksUseCase listCompletedTasksUseCase(ListCompleteTasksAdapter adapter) {
        return new ListCompletedTasksUseCase(adapter);
    }
}
