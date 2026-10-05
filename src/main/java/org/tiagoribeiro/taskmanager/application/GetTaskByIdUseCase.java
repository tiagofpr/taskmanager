package org.tiagoribeiro.taskmanager.application;

import org.springframework.stereotype.Service;
import org.tiagoribeiro.taskmanager.application.output.TaskOutput;
import org.tiagoribeiro.taskmanager.domain.TaskId;
import org.tiagoribeiro.taskmanager.domain.TaskNotFoudException;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository =  repository;
    }

    public TaskOutput execute(TaskId id){
       return repository.finById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoudException(id));
    }

}
