package org.tiagoribeiro.taskmanager.infrastructure.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiagoribeiro.taskmanager.application.CreateTaskUseCase;
import org.tiagoribeiro.taskmanager.application.input.CreateTaskInput;
import org.tiagoribeiro.taskmanager.infrastructure.http.request.CreateTaskRequest;
import org.tiagoribeiro.taskmanager.infrastructure.http.response.TaskResponse;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase){
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request){
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }


}
