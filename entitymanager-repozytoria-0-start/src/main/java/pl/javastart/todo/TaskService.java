package pl.javastart.todo;

import org.springframework.stereotype.Service;

import pl.javastart.todo.dto.NewTaskDto;
import pl.javastart.todo.dto.TaskDurationDto;
import pl.javastart.todo.exception.*;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static long nextId = 1;
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Long saveTask(NewTaskDto newTask) {
        Task taskToSave = new Task(
                newTask.getTitle(),
                newTask.getDescription(),
                newTask.getPriority());
        taskToSave.setId(nextId);
        Task savedTask = taskRepository.save(taskToSave);
        nextId++;
        return savedTask.getId();
    }

    public Optional<String> getTaskInfo(Long taskId) {
        return taskRepository.findById(taskId).map(Task::toString);
    }

    @Transactional
    public LocalDateTime startTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() != null) {
            throw new TaskAlreadyStartedException();
        }
        task.setStartTime(LocalDateTime.now());
        return task.getStartTime();
    }

    @Transactional
    public TaskDurationDto completeTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() == null) {
            throw new TaskNotStartedException();
        } else if (task.getCompletionTime() != null) {
            throw new TaskAlreadyCompletedException();
        }
        task.setCompletionTime(LocalDateTime.now());
        return new TaskDurationDto(task.getStartTime(), task.getCompletionTime());
    }

    public List<NewTaskDto> AllNotStartedTask() {
        return taskRepository.findAllByStartTimeIsNullOrderByPriorityDesc()
                .stream().map(task -> new NewTaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getPriority()
                )).collect(Collectors.toList());
    }

    public List<NewTaskDto> AllFinishedTask() {
        return taskRepository.findAllByCompletionTimeIsNotNullOrderByCompletionTimeDesc()
                .stream().map(task -> new NewTaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getPriority()
                )).collect(Collectors.toList());
    }
}
