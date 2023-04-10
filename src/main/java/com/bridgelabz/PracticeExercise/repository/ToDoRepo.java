package com.bridgelabz.PracticeExercise.repository;

import com.bridgelabz.PracticeExercise.model.ToDoListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDoListModel,Long> {
}
