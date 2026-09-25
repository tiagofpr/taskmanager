package org.tiagoribeiro.taskmanager.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tiagoribeiro.taskmanager.infrastructure.repository.InMemoryTaskRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public abstract class TaskRepositoryTest {
    TaskRepository repository;

    protected abstract TaskRepository createRepository();

    @BeforeEach
    public void setUp(){
        this.repository =  createRepository();
    }

    @Test
    void should_save_and_retrieve_task_by_id(){
        //given
        var task = new Task("Passar na padaria", Optional.empty());

        //when
        var saved = repository.save(task);
        Optional<Task> result = repository.finById(saved.getId());

        //then
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(task.getId());
        assertThat(result.get().getDescription()).isEqualTo(task.getDescription());
        assertThat(result.get().getStatus()).isEqualTo(task.getStatus());


    }

    @Test
    void shoud_find_all_persistes_status(){
        //given
        var task1= new Task("Arrumar chuveiro", Optional.of("Comprar chuveiro nono"));
        var task2= new Task("Trocar lampada", Optional.of("Procurar a chave de fenda"));

        repository.save(task1);
        repository.save(task2);

        //when
        List<Task> tasks = repository.findAll();

        //then
        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting(Task::getId).containsExactlyInAnyOrder(task1.getId(), task2.getId());


    }

    @Test
    void shoud_delete_task_by_id(){
        //given
        var task = repository.save(new Task("Treinar na academia", Optional.empty()));
        var taskId = task.getId();

        //when
        repository.delete(taskId);
        Optional<Task> result = repository.finById(taskId);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    void shold_return_empty_when_searching_non_existent_task(){
        //given
        var nonExistentId = new TaskId();

        //when
        Optional<Task> result = repository.finById(nonExistentId);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    void shold_update_task_status_successfuly(){
        //given
        var task = repository.save(new Task("Atualizar carteira de investimento", Optional.empty()));

        task.setDescription(Optional.of("Não esta desatulizada"));
        task.setStatus(TaskStatus.IN_PROGRESS);

        //when
        repository.save(task);
        Optional<Task> result = repository.finById(task.getId());

        //then
        assertThat(result).isPresent();
        assertThat(result.get().getDescription()).isEqualTo(Optional.of("Não esta desatulizada"));
        assertThat(result.get().getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);

    }


}