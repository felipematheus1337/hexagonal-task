package com.hexagonal.tasks.config;

import com.hexagonal.tasks.adapters.out.CreateTaskAdapter;
import com.hexagonal.tasks.application.usecases.CreateTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurationBeans {

    @Bean
    public CreateTaskUseCase createTaskUseCase(CreateTaskAdapter adapter) {
        return new CreateTaskUseCase(adapter);
    }
}
