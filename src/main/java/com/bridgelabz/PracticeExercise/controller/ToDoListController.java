package com.bridgelabz.PracticeExercise.controller;

import com.bridgelabz.PracticeExercise.dto.ToDoDTO;
import com.bridgelabz.PracticeExercise.model.ToDoListModel;
import com.bridgelabz.PracticeExercise.services.ToDoLogics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    @Autowired
    ToDoLogics iList;


    //////////////////// ::  Save Description  :: ////////////////////
    @PostMapping("/saveList")
    public String getList(@RequestBody ToDoDTO list){
        iList.saveList(list);
        return "Saved Successfully!!!";
    }

    //////////////////// ::  Get Description By Id :: ////////////////////
    @GetMapping("/getDesc/{id}")
    public String getListById(@PathVariable long id){
        return iList.getDescripitonById(id);
    }

    //////////////////// ::  Get All Description  :: ////////////////////
    @GetMapping("/getAllDesc")
    public List<ToDoListModel> getAllDescriptions(){
        return iList.getAllDescripitons();
    }

    //////////////////// ::  Edit Description :: ////////////////////
    @PutMapping("/editDesc/{id}")
    public String editId(@RequestBody ToDoDTO listToDo, @PathVariable long id){
        ToDoListModel list = new ToDoListModel(listToDo);
        return iList.editToDoListDescription(list,id);
    }

    //////////////////// ::  Delete Description By Id :: ////////////////////
    @DeleteMapping("/deleteDesc/{id}")
    public String deleteDescription(@PathVariable long id){
        return iList.deleteDescriptionById(id);
    }

    //////////////////// ::  Delete All Description :: ////////////////////
    @DeleteMapping("/deleteAllDesc/")
    public String deleteAllDescription(){
        return iList.deleteAllDescriptionById();
    }

}
