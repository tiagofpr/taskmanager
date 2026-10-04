package org.tiagoribeiro.taskmanager.application;

import org.tiagoribeiro.taskmanager.application.input.CreateTaskInput;
import org.tiagoribeiro.taskmanager.application.output.TaskOutput;
import org.tiagoribeiro.taskmanager.domain.Task;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;

public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input){
        var task =  new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }

}
