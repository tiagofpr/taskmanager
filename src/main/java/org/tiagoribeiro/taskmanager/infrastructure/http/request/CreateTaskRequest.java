package org.tiagoribeiro.taskmanager.infrastructure.http.request;

import org.tiagoribeiro.taskmanager.application.input.CreateTaskInput;

import java.util.Optional;

public record CreateTaskRequest(String title, Optional<String> description) {
    public CreateTaskInput toInput(){
        return new CreateTaskInput(title, description);
    }

}
