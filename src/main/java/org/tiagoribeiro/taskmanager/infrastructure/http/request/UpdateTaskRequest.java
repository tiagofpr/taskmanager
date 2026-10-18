package org.tiagoribeiro.taskmanager.infrastructure.http.request;

import org.tiagoribeiro.taskmanager.application.input.UpdateTaskInput;
import org.tiagoribeiro.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String>title, Optional<String> description, Optional<String> status){
    public UpdateTaskInput toInput(){
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));

    }
}
