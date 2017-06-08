package com.altaire.task.service;

import com.altaire.task.model.Task;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/8/17
 * Time: 3:52 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TaskService {
    Task create(Task task);

    Task findById(Integer id);

    void delById(Integer id);

    List<Task> findAll();

}
