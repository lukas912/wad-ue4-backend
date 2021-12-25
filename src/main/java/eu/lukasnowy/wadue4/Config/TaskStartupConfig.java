package eu.lukasnowy.wadue4.Config;

import com.google.gson.Gson;
import eu.lukasnowy.wadue4.Model.Task;
import eu.lukasnowy.wadue4.Service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Configuration
public class TaskStartupConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskService taskService) {

        return args -> {
            //read tasks from json

            try {
                Gson gson = new Gson();

                Reader reader = Files.newBufferedReader(Paths.get("src/main/java/tasks-mock.json"));

                // convert JSON file to map
                Task[] tasks = gson.fromJson(reader, Task[].class);

                taskService.createTasks(List.of(tasks));
            }

            catch (Exception e) {
                throw new Exception("Cannot read json file");
            }


        };
    }
}
