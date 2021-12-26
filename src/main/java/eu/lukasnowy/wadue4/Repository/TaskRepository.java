package eu.lukasnowy.wadue4.Repository;

import eu.lukasnowy.wadue4.Model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    @Query("SELECT t FROM Task t ORDER BY t.deadline DESC")
    Iterable<Task> getTasksSortedByDeadline();

    @Query("SELECT t FROM Task t ORDER BY t.status")
    Iterable<Task> getTasksSortedByStatus();
}
