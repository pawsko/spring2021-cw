package pl.javastart.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface TaskRepository extends CrudRepository <Task, Long> {
//    Task save(Task task);
//    Optional<Task> findById(Long id);
}
