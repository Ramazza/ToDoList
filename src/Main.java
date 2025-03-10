import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = -1;
        ArrayList<Task> taskList = new ArrayList<>();

        do{
            System.out.println("*********");
            System.out.println("ToDo List");
            System.out.println("*********");
            System.out.println("1: Add tasks");
            System.out.println("2: View tasks");
            System.out.println("3: Mark task as Complete");
            System.out.println("4: Remove tasks");
            System.out.println("0: Exit");
            System.out.print("Choose an option (0-4): ");

            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                choice = -1;
            }

            switch (choice){
                case 1 -> addTask(taskList);
                case 2 -> showTasks(taskList);
                case 3 -> completeTask(taskList);
                case 4 -> removeTask(taskList);
                case 0 -> System.out.println("Exiting...");
                default -> {
                    System.out.println();
                    System.out.println("Type a NUMBER between 0-4...");
                    System.out.println();
                }
            }
        } while (choice != 0);
    }

    static void addTask(ArrayList<Task> taskList){

        String name;
        String description;

        System.out.println();
        System.out.print("Type tha name of the task: ");
        name = scanner.nextLine();
        System.out.print("Type the description of the task: ");
        description = scanner.nextLine();

        taskList.add(new Task(name, description, false));
        System.out.println();
    }

    static void showTasks(ArrayList<Task> task) {

        if(task.isEmpty()){
            System.out.println();
            System.out.println("There isn't any taks yet");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("ToDo List:");
            for(int i = 0; i < task.size(); i++) {
                String status = task.get(i).getCompletion() ? "✔ Completa" : "❌ Pendente";
                System.out.printf("%d- %s (%s) %s\n",
                        i+1,
                        task.get(i).getName(),
                        task.get(i).getDescription(),
                        status);
            }
            System.out.println();
        }
    }

    static void completeTask(ArrayList<Task> task) {

        int taskOption;

        if(task.isEmpty()){
            System.out.println();
            System.out.println("There isn't any taks yet");
            System.out.println();
        } else {
            showTasks(task);
            System.out.printf("Select which task to mark as complete: (1-%d) ", task.size());
            taskOption = scanner.nextInt() -1;
            scanner.nextLine();

            task.get(taskOption).setCompletion(!task.get(taskOption).getCompletion());

            showTasks(task);
        }
    }

    static void removeTask(ArrayList<Task> task) {
        int taskOption;

        if(task.isEmpty()){
            System.out.println();
            System.out.println("There isn't any taks yet");
            System.out.println();
        } else {
            showTasks(task);
            System.out.printf("Select which task to remove: (1-%d) ", task.size());
            taskOption = scanner.nextInt();
            scanner.nextLine();

            task.remove(taskOption);

            showTasks(task);
        }
    }
}
