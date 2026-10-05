package org.tiagoribeiro.taskmanager.application.input;

import org.tiagoribeiro.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput(Optional<String> title,
                              Optional<String> description,
                              Optional<TaskStatus> status)
    {
}
