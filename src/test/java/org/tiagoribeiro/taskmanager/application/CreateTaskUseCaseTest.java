package org.tiagoribeiro.taskmanager.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tiagoribeiro.taskmanager.application.input.CreateTaskInput;
import org.tiagoribeiro.taskmanager.application.output.TaskOutput;
import org.tiagoribeiro.taskmanager.domain.Task;
import org.tiagoribeiro.taskmanager.domain.TaskRepository;
import org.tiagoribeiro.taskmanager.infrastructure.repository.InMemoryTaskRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {
    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    @Test
    void shoud_create_task_succesfully(){
        //given
        var input = new CreateTaskInput("Estudar Java", Optional.of("Finalizar o modulo records"));

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        //when
        TaskOutput output =  useCase.execute(input);

        //then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.title());
        assertEquals(Optional.of("Finalizar o modulo records"), output.description());

        verify(repository, times(1)).save(any(Task.class));
    }
    

}