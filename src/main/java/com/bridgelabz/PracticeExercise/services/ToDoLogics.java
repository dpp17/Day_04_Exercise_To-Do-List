package com.bridgelabz.PracticeExercise.services;

import com.bridgelabz.PracticeExercise.dto.ToDoDTO;
import com.bridgelabz.PracticeExercise.model.ToDoListModel;
import com.bridgelabz.PracticeExercise.repository.ToDoRepo;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoLogics {
    @Autowired
    ToDoRepo listRepo;

    public ToDoListModel saveList(ToDoDTO list){
        ToDoListModel userList = new ToDoListModel(list);
        return listRepo.save(userList);
    }

    public String getDescripitonById(long id){
        Optional<ToDoListModel> listId = listRepo.findById(id);
        if(listId.isPresent()){
            return "==>> " + listId;
        }
            return "ID doesn't found !!";
    }

    public List<ToDoListModel> getAllDescripitons(){
        return listRepo.findAll();
    }

    public String editToDoListDescription(ToDoListModel list, long id) {
        Optional<ToDoListModel> editDesc = listRepo.findById(id);
        if (editDesc.isPresent()) {
            editDesc.get().setName(list.getName());
            editDesc.get().setDescription(list.getDescription());
            listRepo.save(editDesc.get());
            return "Message Edited Successfully.... Name:: " + list.getName() +" || Description :: " + list.getDescription();
        }
        else
            return " :: Message ID doesn't Exist ::";
    }

    public String deleteDescriptionById(long id){
        Optional<ToDoListModel> list = listRepo.findById(id);
        if(list.isPresent()){
            listRepo.deleteById(id);
            return "Deleted Successfully !!!";
        }
        return "Message with this ID doesn't Exist";
    }

    public String deleteAllDescriptionById(){
        listRepo.deleteAll();
        return "All Records are Deleted";
    }
}

