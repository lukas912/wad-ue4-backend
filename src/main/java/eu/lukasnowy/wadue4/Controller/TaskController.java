package eu.lukasnowy.wadue4.Controller;

import eu.lukasnowy.wadue4.Enum.Status;
import eu.lukasnowy.wadue4.Model.Task;
import eu.lukasnowy.wadue4.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public Iterable<Task> getTasks(@RequestParam(required = false) String sort, @RequestParam(required = false) Status filter) {

        return taskService.getTasks(sort, filter);
    }

    @GetMapping(path="/task/{id}")
    public Optional<Task> getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping(path="/task")
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @DeleteMapping(path = "/task/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

    @PutMapping(path = "/task")
    public void editTask(@RequestBody Task task) {
        taskService.editTask(task);
    }
}
