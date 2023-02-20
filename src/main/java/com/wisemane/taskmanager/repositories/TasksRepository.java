package com.wisemane.taskmanager.repositories;

import com.wisemane.taskmanager.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TasksRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByCompleted(boolean completed);

    @Query("" +
            "SELECT t FROM tasks t " +
            "WHERE t.completed = false " +
            "AND t.dueDate < CURRENT_DATE")
    List<TaskEntity> findAllOverdue();

    @Query("" +
            "SELECT t FROM tasks t" +
            "WHERE t.title LIKE %?1%")
    List<TaskEntity> findAllByTitle(String title);

    List<TaskEntity> findAllByTitleIsContainingIgnoreCase(String titleFragment);

    List<TaskEntity> findAllByCompletedAndDueDateBefore(boolean completed, Date dueDate);
}
