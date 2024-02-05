package myMidterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static Users[] user = new Users[20];
    static int userCount = 0;
    static int ctr = 0;
    static Scanner scanner = new Scanner(System.in);

    static Users addUser(int id) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        Users a = new Users();

        System.out.println("*****************************************");
        System.out.println("**               Register              **");
        System.out.println("*****************************************");

        System.out.print("\tEnter Username: ");
        a.setUser_name(reader.readLine());
        
        System.out.print("\tEnter pin: ");
        a.pin = reader.readLine();

        a.id = id;

        user[userCount] = a;
        userCount++;
        System.out.println("Registration successful!\n");
        return a;
    }

    static Users login(String username, String password) {
        for (int i = 0; i < ctr; i++) {
            if (user[i].getUser_name().equals(username) && user[i].pin.equals(password)) {
                return user[i];
            }
        }
        Users emptyUser = new Users();
        emptyUser.id = -1;
        return emptyUser;
    }

    static void addTask(Users loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("**              Add Task               **");
        System.out.println("*****************************************");
        System.out.print("\tEnter Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("\tEnter Time In: ");
        String timeIn = scanner.nextLine();
        System.out.print("\tEnter Time Out: ");
        String timeOut = scanner.nextLine();
        System.out.print("\tEnter Rate (1-10): ");
        int rate = scanner.nextInt();

        loggedInUser.addTask(taskName, timeIn, timeOut, rate);
        System.out.println("\tTask added successfully!\n");
    }

    static void viewTasks(Users loggedInUser) {
        loggedInUser.viewTasks();
        pressEnterToContinue();
    }

    static void loginMenu(Users loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        char option;
        boolean exitMenu = false;
        while (!exitMenu) {
            System.out.println("*****************************************");
            System.out.println("**              Welcome!               **");
            System.out.println("*****************************************");
            System.out.println("**      What would you like to do?     **");
            System.out.println("**\t1. Add Task                        **");
            System.out.println("**\t2. View Tasks                      **");
            System.out.println("**\t3. Back                            **");
            System.out.println("*****************************************");
            System.out.print("   Enter command: ");
            option = scanner.next().charAt(0);
            switch (option) {
                case '1':
                	addTask(loggedInUser);
                    break;
                case '2':
                	viewTasks(loggedInUser);
                    break;
                case '3':
                	exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid option selected");
                    break;
            }
        }
    }

    static void mainMenu(char c) throws IOException {
    switch (c) {
        case 1:
            System.out.println("*****************************************");
            System.out.println("**               Log in                **");
            System.out.println("*****************************************");
            System.out.print("\tEnter Username: ");
            scanner.nextLine();  // Consume the newline character
            String username = scanner.nextLine();
            System.out.print("\tEnter pin: ");
            String password = scanner.nextLine();
            Users loggedInUser = login(username, password);
            if (loggedInUser.id == -1) {
                System.out.println("Invalid username or password. Please try again.");
            } else {
                loginMenu(loggedInUser);
            }
            break;
        case 2:
            user[ctr] = addUser(ctr + 1);
            ctr++;
            System.out.println("\n\n");
            break;
        case 3:
            System.out.println("Exit");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid input. Please try again.");
            break;
    }
    scanner.nextLine();  // Consume the newline character
    }


    public static void main(String[] args) throws IOException {
        int command = 0;
        while (command != 3) {
            System.out.println("*********************************");
            System.out.println("**           Task Manager       **");
            System.out.println("*********************************");
            System.out.println("**      1.) Log in             **");
            System.out.println("**      2.) Register           **");
            System.out.println("**      3.) Exit               **");
            System.out.println("*********************************");
            System.out.print("\tEnter Command: ");
            command = scanner.nextInt();
            mainMenu((char) command);
        }
    }
    
    private static void pressEnterToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
}

