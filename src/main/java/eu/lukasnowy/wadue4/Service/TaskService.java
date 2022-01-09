package eu.lukasnowy.wadue4.Service;

import eu.lukasnowy.wadue4.Enum.Status;
import eu.lukasnowy.wadue4.Model.Task;
import eu.lukasnowy.wadue4.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getTasks(String sort, Status filter) {

        if(sort == null && filter != null) {
            return taskRepository.getTasksFiltered(filter);
        }

        else if(sort.equals("deadline") && filter == null) {
            System.out.println("HERE");
            return taskRepository.getTasksSortedByDeadline();
        }

        if(sort.equals("status") && filter == null) {
            return taskRepository.getTasksSortedByStatus();
        }

        if(sort.equals("status") && filter != null) {
            return taskRepository.getTasksSortedByStatusFilter(filter);
        }
        
        if(sort.equals("deadline") && filter != null) {
            return taskRepository.getTasksSortedByDeadlineFilter(filter);
        }

        else {
            return taskRepository.findAll();
        }

    }

    public void createTasks(Iterable<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public void editTask(Task task) {
            taskRepository.save(task);
    }
}
