package org.tiagoribeiro.taskmanager.infrastructure.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tiagoribeiro.taskmanager.domain.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    private InMemoryTaskRepository repository;

    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }




}