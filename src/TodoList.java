import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private static ArrayList<String>Task=new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			DisplayMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				AddTask();
				break;
			case 2:
				ViewTask();
				break;
			case 3:
				MarkTaskComplete();
				break;
			case 4:
				DeleteTask();
				break;
			case 5:
				System.out.println("Exit from this application");
				return;
			default:
				System.out.println("invalid input.please try again");
					
			}
		}
		

	}

	public static void DisplayMenu() {
		System.out.println("\n ----TodoList Menu---- \n");
		System.out.println("1.Add a Task");
		System.out.println("2.View All Tasks");
		System.out.println("3.Mark a Task as Complete");
		System.out.println("4.Delete a Task");
		System.out.println("5.Exit");
		System.out.println("Enter Your Choice:");
	}
	
	public static void AddTask() {
		System.out.println("Enter the Task:");
		String task=sc.nextLine();
		Task.add(task);
		System.out.println("Task added Successfully");
	}
	
	public static void ViewTask() {
		if(Task.isEmpty()) {
			System.out.println("No Task available");
			return;
		}
		System.out.println("\n ----Your Task----\n");
		for(int i=0;i<Task.size();i++) {
		System.out.println((i+1)+"."+Task.get(i));
		}
	}
	
	public static void MarkTaskComplete() {
		if(Task.isEmpty()) {
			System.out.println("No Task available");
			return;
		}
		ViewTask();
		System.out.println("Enter the task number to mark as complete:");
		int TaskNo=sc.nextInt();
		sc.nextLine();
		
		if(TaskNo<=0 || TaskNo>Task.size()) {
			System.out.println("Invalid Task no.");
		}
		else {
			String completedTask= Task.get(TaskNo-1)+"[Task completed]";
			Task.set(TaskNo-1,completedTask);
			System.out.println("Task marked as completed");
		}
	}
	
	public static void DeleteTask() {
		if(Task.isEmpty()) {
			System.out.println("No Task available");
			return;
		}
		ViewTask();
		System.out.println("Enter the task number to delete:");
		int TaskNo=sc.nextInt();
		sc.nextLine();
		
		if(TaskNo<=0 || TaskNo>Task.size()) {
			System.out.println("Invalid Task no.");
		}
		else {
			Task.remove(TaskNo-1);
			System.out.println("Task deleted sucessfully.");
		}
	}
}

