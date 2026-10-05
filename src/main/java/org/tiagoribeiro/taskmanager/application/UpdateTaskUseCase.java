package org.tiagoribeiro.taskmanager.application;

import org.springframework.stereotype.Service;
import org.tiagoribeiro.taskmanager.application.input.UpdateTaskInput;
import org.tiagoribeiro.taskmanager.application.output.TaskOutput;
import org.tiagoribeiro.taskmanager.domain.TaskId;
import org.tiagoribeiro.taskmanager.domain.TaskNotFoudException;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository =  repository;
    }
    
    public TaskOutput execute(TaskId id, UpdateTaskInput input){
        var task = repository.finById(id).orElseThrow(() -> new TaskNotFoudException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }

}
