package org.tiagoribeiro.taskmanager.application;

import org.springframework.stereotype.Service;
import org.tiagoribeiro.taskmanager.domain.TaskId;
import org.tiagoribeiro.taskmanager.domain.TaskNotFoudException;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository =  repository;
    }

    public void exexute(TaskId taskId){
        if(repository.finById(taskId).isEmpty()){
            throw new TaskNotFoudException(taskId);
        }
        repository.delete(taskId);
    }
}
