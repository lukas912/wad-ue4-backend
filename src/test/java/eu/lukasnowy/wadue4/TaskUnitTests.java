package eu.lukasnowy.wadue4;

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
        taskService.getTasks(null);
        //then
        verify(taskRepository).findAll();
    }
}
