package eu.lukasnowy.wadue4;

import eu.lukasnowy.wadue4.Enum.Status;
import eu.lukasnowy.wadue4.Model.Task;
import eu.lukasnowy.wadue4.Repository.TaskRepository;
import eu.lukasnowy.wadue4.Service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskUnitTests  {

    @Mock
    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService(taskRepository);
    }

    @Test
    public void getAllTasks() {
        //when
        taskService.getTasks(null, null);
        //then
        verify(taskRepository).findAll();
    }

    @Test
    public void getTaskByID() {
        //when
        taskService.getTaskById(1);
        //then
        verify(taskRepository).findById(1);
    }

    @Test
    public void getTasksSortedDeadline() {
        //when
        taskService.getTasks("deadline", null);
        //then
        verify(taskRepository).getTasksSortedByDeadline();
    }

    @Test
    public void getTasksSortedStatus() {
        //when
        taskService.getTasks("status", null);
        //then
        verify(taskRepository).getTasksSortedByStatus();
    }

    @Test
    public void getTasksFilter() {
        //when
        taskService.getTasks(null, Status.DONE);
        //then
        verify(taskRepository).getTasksFiltered(Status.DONE);
    }

    @Test
    public void deleteTask() {
        //when
        taskService.deleteTask(1);
        //then
        verify(taskRepository).deleteById(1);
    }

    @Test
    public void editTask() {
        Task t = new Task();
        //when
        taskService.editTask(t);
        //then
        verify(taskRepository).save(t);
    }

    @Test
    public void createTask() {
        Task t = new Task();
        //when
        taskService.createTask(t);
        //then
        verify(taskRepository).save(t);
    }
}
