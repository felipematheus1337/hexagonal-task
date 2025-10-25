package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.application.ports.in.FinishTaskInputPort;
import com.hexagonal.tasks.application.ports.out.FinishTaskOutputPort;

public class FinishTaskUseCase implements FinishTaskInputPort {

    private final FinishTaskOutputPort finishTaskOutputPort;

    public FinishTaskUseCase(FinishTaskOutputPort finishTaskOutputPort) {
        this.finishTaskOutputPort = finishTaskOutputPort;
    }

    @Override
    public void finalizar(Long id) {
        finishTaskOutputPort.finalizar(id);
    }
}
