package org.tiagoribeiro.taskmanager.application.output;

import org.tiagoribeiro.taskmanager.domain.Task;

import javax.swing.text.html.Option;
import java.lang.classfile.Opcode;
import java.util.Optional;

public record TaskOutput(String id, String title, Optional<String> description, String status) {

    public static TaskOutput from(Task task){
        return new TaskOutput(task.getId().toString(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name());
    }
}
