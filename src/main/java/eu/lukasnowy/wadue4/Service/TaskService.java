package eu.lukasnowy.wadue4.Service;

import eu.lukasnowy.wadue4.Model.Task;
import eu.lukasnowy.wadue4.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }
}
