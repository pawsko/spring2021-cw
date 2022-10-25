package pl.javastart.todo;

import org.springframework.stereotype.Controller;
import pl.javastart.todo.dto.NewTaskDto;
import pl.javastart.todo.dto.TaskDurationDto;
import pl.javastart.todo.exception.TaskAlreadyCompletedException;
import pl.javastart.todo.exception.TaskAlreadyStartedException;
import pl.javastart.todo.exception.TaskNotFoundException;

import java.time.LocalDateTime;
import java.util.Scanner;

@Controller
class TaskController {
    private final TaskService taskService;
    private final Scanner scanner;

    TaskController(TaskService taskService, Scanner scanner) {
        this.taskService = taskService;
        this.scanner = scanner;
    }

    public void loop() {
        Option option;
        do {
            printOptions();
            option = chooseOption();
            evaluateOption(option);
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję:");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }

    private Option chooseOption() {
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        return Option.fromInt(optionNumber);
    }

    private void evaluateOption(Option option) {
        try {
            switch (option) {
                case ADD -> addTask();
                case PRINT_SINGLE -> printTask();
                case NOT_STARTED_TASK -> notStartedTask();
                case FINISHED_TASK -> finishedTask();
                case START_TASK -> startTask();
                case STOP_TASK -> completeTask();
                case EXIT -> exit();
            }
        } catch (TaskNotFoundException e) {
            System.out.println("Nie odnaleziono zadania o takim numerze");
        }
    }

    private void finishedTask() {
        taskService.AllFinishedTask()
                .forEach(System.out::println);
    }

    private void notStartedTask() {
        taskService.AllNotStartedTask()
                .forEach(System.out::println);
    }

    private void addTask() {
        System.out.println("Podaj tytuł zadania:");
        String title = scanner.nextLine();
        System.out.println("Opis zadania:");
        String description = scanner.nextLine();
        System.out.println("Priorytet (wyższa liczba = wyższy priorytet):");
        int priority = scanner.nextInt();
        scanner.nextLine();
        NewTaskDto task = new NewTaskDto(title, description, priority);
        Long savedTaskId = taskService.saveTask(task);
        System.out.println("Zadanie zapisane z identyfikatorem " + savedTaskId);
    }

    private void startTask() {
        System.out.println("Podaj id zadania, które chcesz wystartować:");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        try {
            LocalDateTime startTime = taskService.startTask(taskId);
            System.out.println("Czas rozpoczęcia zadania: " + startTime);
        } catch (TaskAlreadyStartedException e) {
            System.out.println("Zadanie zostało już wcześniej wystartowane.");
        }
    }

    private void completeTask() {
        System.out.println("Podaj id zadania, które chcesz zatrzymać:");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        try {
            TaskDurationDto taskDurationDto = taskService.completeTask(taskId);
            System.out.println(taskDurationDto);
        } catch (TaskAlreadyCompletedException e) {
            System.out.println("Zadanie zostało juz wcześniej zakończone");
        } catch (TaskAlreadyStartedException e) {
            System.out.println("Wystartuj zadanie zanim je zakończysz");
        }
    }

    private void printTask() {
        System.out.println("Podaj identyfikator zadania:");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        taskService.getTaskInfo(taskId)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Brak wpisu o takim id")
                );
    }

    private void exit() {
        System.out.println("Koniec programu!");
        System.exit(0);
    }

    private enum Option {
        ADD(1, "Dodaj nowe zadanie"),
        PRINT_SINGLE(2, "Wyświetl zadanie"),
        NOT_STARTED_TASK(3, "Wyświetl nierozpoczęte zadania"),
        FINISHED_TASK(4, "Wyświetl zakończone zadania"),
        START_TASK(5, "Wystartuj zadanie"),
        STOP_TASK(6, "Zakończ zadanie"),
        EXIT(7, "Koniec programu");

        private final int number;
        private final String name;

        Option(int number, String name) {
            this.number = number;
            this.name = name;
        }

        static Option fromInt(int option) {
            return values()[option - 1];
        }

        @Override
        public String toString() {
            return number + " - " + name;
        }
    }
}
