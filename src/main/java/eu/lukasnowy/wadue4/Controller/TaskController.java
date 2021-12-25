package eu.lukasnowy.wadue4.Controller;

import eu.lukasnowy.wadue4.Model.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskController {
    @GetMapping(path = "/tasks")
    public Iterable<Task> getTasks() {
        return null;
    }
}
