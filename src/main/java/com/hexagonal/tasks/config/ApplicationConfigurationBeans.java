package com.hexagonal.tasks.config;

import com.hexagonal.tasks.adapters.out.CreateTaskAdapter;
import com.hexagonal.tasks.adapters.out.FindTaskByIdAdapter;
import com.hexagonal.tasks.adapters.out.FinishTaskAdapter;
import com.hexagonal.tasks.application.usecases.CreateTaskUseCase;
import com.hexagonal.tasks.application.usecases.FinishTaskUseCase;
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
}
