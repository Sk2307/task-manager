package com.wisemane.taskmanager.services;

import com.wisemane.taskmanager.repositories.NotesRepository;
import com.wisemane.taskmanager.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TasksService {

    final TasksRepository tasksRepository;

    final NotesRepository notesRepository;

    public TasksService(TasksRepository tasksRepository, NotesRepository notesRepository) {
        this.tasksRepository = tasksRepository;
        this.notesRepository = notesRepository;
    }
}
