package org.tiagoribeiro.taskmanager.infrastructure.repository;

import org.tiagoribeiro.taskmanager.domain.Task;
import org.tiagoribeiro.taskmanager.domain.TaskId;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;

import java.util.*;

public class InMemoryTaskRepository implements TaskRepository {

    private final Map<TaskId, Task> storage = new HashMap<>();

    @Override
    public Task save(Task task) {
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Task> finById(TaskId id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void delete(TaskId id) {
        storage.remove(id);

    }
}
