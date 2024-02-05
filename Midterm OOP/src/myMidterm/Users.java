package myMidterm;

import java.util.ArrayList;
import java.util.List;

public class Users implements Task{
	int id;
    private String user_name;
    String pin;
    List<Task> tasks;

    public Users() {
        tasks = new ArrayList<>();
    }

    void addTask(String TaskName, String TimeStart, String TimeStop, int Rate) {
        Task newTask = new Task() {
            @Override
            public String getTaskName() {
                return TaskName;
            }

            @Override
            public String getTimeIn() {
                return TimeStart;
            }

            @Override
            public String getTimeOut() {
                return TimeStop;
            }

            @Override
            public int getRate() {
                return Rate;
            }
        };
        tasks.add(newTask);
    }
    void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\tNo tasks found.");
        } else {
            System.out.println("\tTasks:");
            for (Task task : tasks) {
                System.out.println("\t- Task: " + task.getTaskName() +
                        ", TimeIn: " + task.getTimeIn() +
                        ", TimeOut: " + task.getTimeOut() +
                        ", Rate: " + task.getRate());
            }
        }
        
    }
    @Override
    public String getTaskName() {
        // Implementation not needed in User class for this example
        return null;
    }

    @Override
    public String getTimeIn() {
        // Implementation not needed in User class for this example
        return null;
    }

    @Override
    public String getTimeOut() {
        // Implementation not needed in User class for this example
        return null;
    }

    @Override
    public int getRate() {
        // Implementation not needed in User class for this example
        return 0;
    }

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
