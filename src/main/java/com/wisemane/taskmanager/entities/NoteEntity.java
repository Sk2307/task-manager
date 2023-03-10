package com.wisemane.taskmanager.entities;

import jakarta.persistence.*;

@Entity(name = "notes")
public class NoteEntity extends BaseEntity{

    @Column(name = "body", nullable = false, length = 500)
    String body;

    @ManyToOne()
    TaskEntity task;
}
