package org.tiagoribeiro.taskmanager.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tiagoribeiro.taskmanager.application.input.CreateTaskInput;
import org.tiagoribeiro.taskmanager.application.output.TaskOutput;
import org.tiagoribeiro.taskmanager.infrastructure.repository.InMemoryTaskRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CreateTaskUseCaseTest {
    CreateTaskUseCase useCase;

    @BeforeEach
    void setUp(){
        this.useCase = new CreateTaskUseCase(new InMemoryTaskRepository());
    }

    @Test
    void shoud_create_task_succesfully(){
        //given
        var input = new CreateTaskInput("Estudar Java", Optional.of("Finalizar o modulo records"));

        //when
        TaskOutput output =  useCase.execute(input);

        //then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.title());
        assertEquals(Optional.of("Finalizar o modulo records"), output.description());

    }
    

}