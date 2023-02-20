package com.wisemane.taskmanager.repositories;

import com.wisemane.taskmanager.entities.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TasksRepositoryTest {

    @Autowired
    private TasksRepository tasksRepository;

    @Test
    public void testCreateTask(){
        TaskEntity task = new TaskEntity();
        task.setTitle("Test task");
        task.setDescription("Test Description");
        task.setCompleted(false);
        var savedTask = tasksRepository.save(task);
        assertNotNull(savedTask);
    }

    @Test
    public void testReadTaskWorks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test task 1");
        task1.setDescription("Test Description 1");
        task1.setCompleted(false);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test task 2");
        task2.setDescription("Test Description 2");
        task2.setCompleted(false);
        tasksRepository.save(task1);
        tasksRepository.save(task2);
        var tasks = tasksRepository.findAll();
        assertNotNull(tasks);
        assertEquals(2, tasks.size());
    }

    @Test
    public void testFindByCompletedWorks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test task 1");
        task1.setDescription("Test Description 1");
        task1.setCompleted(false);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test task 2");
        task2.setDescription("Test Description 2");
        task2.setCompleted(true);
        tasksRepository.save(task1);
        tasksRepository.save(task2);
        var completedTasks = tasksRepository.findAllByCompleted(true);
        var incompleteTasks = tasksRepository.findAllByCompleted(false);
        assertEquals(1, completedTasks.size());
        assertEquals(1, incompleteTasks.size());
    }

}