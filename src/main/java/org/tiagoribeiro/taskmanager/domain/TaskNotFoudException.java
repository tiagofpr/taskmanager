package org.tiagoribeiro.taskmanager.domain;

public class TaskNotFoudException extends RuntimeException {
    public TaskNotFoudException(TaskId taskId) {
        super("Task with id " + taskId + " not found");
    }
}
