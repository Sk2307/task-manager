package com.wisemane.taskmanager.repositories;

import com.wisemane.taskmanager.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
}
