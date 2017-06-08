package com.altaire.task.controller;

import com.altaire.task.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.altaire.task.service.TaskService;
import com.altaire.task.service.impl.TaskServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/8/17
 * Time: 3:58 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value="/api/task", produces = "application/json")
public class TaskController {
    @Autowired
    private TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Task> findAll() {
        logger.debug("get all task");
        return taskService.findAll();
    }


    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Task findById(@PathVariable Integer id) {
        logger.debug("get task with id " + id);
        return taskService.findById(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Task save(@RequestBody Task task) {
        logger.debug("post task");
        task.setDateCreated(new Date());
        task.setDateUpdated(new Date());
        return taskService.create(task);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        logger.debug("delete task with id " + id);
        taskService.delById(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Task update(@PathVariable Integer id, @RequestBody Task task) {
        logger.debug("update task with id " + id);
        task.setDateUpdated(new Date());
        return taskService.create(task);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Task newTask() {
        return new Task();
    }

}
