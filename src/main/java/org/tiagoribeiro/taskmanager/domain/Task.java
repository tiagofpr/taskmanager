package org.tiagoribeiro.taskmanager.domain;

import org.springframework.util.Assert;

import java.util.Optional;

public class Task {
    private TaskId id;
    private String title;
    private Optional <String> description;
    private TaskStatus status;

    public Task(String title, Optional <String> description){
        Assert.notNull(title, "Title msut be not nnull");

        this.id = new TaskId();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.PENDING;

    }

}
