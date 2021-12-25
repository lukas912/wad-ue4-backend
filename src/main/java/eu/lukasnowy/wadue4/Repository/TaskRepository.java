package eu.lukasnowy.wadue4.Repository;

import eu.lukasnowy.wadue4.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
