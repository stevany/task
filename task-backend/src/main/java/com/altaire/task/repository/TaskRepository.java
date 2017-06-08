package com.altaire.task.repository;

import com.altaire.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/8/17
 * Time: 3:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
