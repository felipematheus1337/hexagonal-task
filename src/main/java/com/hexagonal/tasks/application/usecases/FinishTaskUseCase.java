package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.application.ports.out.FinishTaskOutputPort;

public class FinishTaskUseCase {

    private final FinishTaskOutputPort finishTaskOutputPort;

    public FinishTaskUseCase(FinishTaskOutputPort finishTaskOutputPort) {
        this.finishTaskOutputPort = finishTaskOutputPort;
    }

    public void finalizar(Long id) {
        finishTaskOutputPort.finalizar(id);
    }
}
