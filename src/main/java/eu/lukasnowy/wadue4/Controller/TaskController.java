package eu.lukasnowy.wadue4.Controller;

import eu.lukasnowy.wadue4.Model.Task;
import eu.lukasnowy.wadue4.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping(path = "/tasks")
    public Iterable<Task> getTasks() {
        return taskService.getTasks();
    }
}
