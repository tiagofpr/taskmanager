package org.tiagoribeiro.taskmanager.application;

import org.springframework.stereotype.Service;
import org.tiagoribeiro.taskmanager.application.output.TaskOutput;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;

import java.util.List;

@Service
public class GetTaskUseCase {
    private final TaskRepository repository;

    public GetTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutput> execute(){
        return repository.findAll().stream().map(TaskOutput::from).toList();
    }
}
