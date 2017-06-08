package com.altaire.task.service.impl;

import com.altaire.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altaire.task.repository.TaskRepository;
import com.altaire.task.service.TaskService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/8/17
 * Time: 3:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findOne(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delById(Integer id) {
        taskRepository.delete(id);//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
