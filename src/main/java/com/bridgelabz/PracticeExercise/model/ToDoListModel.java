package com.bridgelabz.PracticeExercise.model;

import com.bridgelabz.PracticeExercise.dto.ToDoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="To-Do_List")
public class ToDoListModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private boolean completed;

    public ToDoListModel(ToDoDTO todo) {
        this.name = todo.name;
        this.description = todo.description;
    }

    public ToDoListModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ToDoListModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
