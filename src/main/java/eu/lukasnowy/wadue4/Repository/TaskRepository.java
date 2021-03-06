package eu.lukasnowy.wadue4.Repository;

import eu.lukasnowy.wadue4.Enum.Status;
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
    @Query("SELECT t FROM Task t WHERE t.status = ?1 ORDER BY t.deadline DESC")
    Iterable<Task> getTasksSortedByDeadlineFilter(Status status);

    @Query("SELECT t FROM Task t WHERE t.status = ?1 ORDER BY t.status")
    Iterable<Task> getTasksSortedByStatusFilter(Status status);



    @Query("SELECT t FROM Task t WHERE t.status = ?1")
    Iterable<Task> getTasksFiltered(Status status);

}
