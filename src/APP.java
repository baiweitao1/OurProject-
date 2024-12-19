import java.util.Scanner;

public class APP {
    public static StoreUsers storeUsers;
    public static StoreDishes storeDishes;
    public static StoreDishes dishLine;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new APP();
    }

    /**
     * The first User must be the Owner. In this way, the storeDish array will store some available dishes.
     */
    private APP() {
        //initialize the three arrays
        storeUsers = new StoreUsers();
        storeDishes = new StoreDishes();
        dishLine = new StoreDishes();
        System.out.print("""
                Welcome to the Diner.
                Are you the Owner ?
                input y/n
                    ==>> """);
        String judge = sc.next();
        if (!judge.equalsIgnoreCase("y")) {
            System.out.println("The Shop Owner has not come yet. Please wait a second Customer :) ");
        }
        addUser(judge);
        new Owner();
        runMenu();
    }

    public static void runMenu() {
        int option = mainMenu();

        while (option != 0) {
            switch (option) {
                case 1 -> addUser("n");
                case 2 -> printUsers(storeUsers.users);
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("Press enter key to continue...");
            sc.nextLine();
            sc.nextLine(); //second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private static int mainMenu() {
        System.out.print("""
                User's Menu
                ---------
                   1) Add a User
                   2) Print the Current Users
                   0) Exit
                ==>> """);
        int option = sc.nextInt();
        return option;
    }

    /**
     * addUser have two situation : the Customer and the Owner (Owner can only be one person
     * and when we first launch this APP, the first user must be the Owner
     * because the current dishMenu is empty)
     */
    private static void addUser() {
        System.out.println("Input your Username: ");
        String name = sc.next();
        System.out.println("Input your Password (input 8 pure numbers): ");
        String password = sc.next();
        System.out.println("Input your Password again: ");
        String passwordAgain = sc.next();
        while (!password.equals(passwordAgain)) {
            System.out.println("Passwords do not match!\nTry again.");
            addUser();
        }
        System.out.println("Register successful!");

        //Customer user = new Customer();
        User user = new User();
        user.setUsername(name);
        user.setPassword(Integer.valueOf(password));
        storeUsers.add(user);
    }

    //Method Overload This method is for Owner
    private static void addUser(String judge) {
        if (judge.toUpperCase().equals("Y")) {
            addUser();
            storeUsers.users[storeUsers.total - 1].setIsOwner(true);
        } else {
            addUser();
            new Customer();
            //the default isOwner is false, so we don't need to reset the value of User's isOwner.
        }
    }

    private static void printUsers(User[] users) {
        for (int i = 0; i < storeUsers.total; i++) {
            System.out.println(storeUsers.users[i]);
        }
    }

    private void removeUsers() {
        sc.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.
        System.out.println("Current Users:");
        System.out.println(storeUsers.listUsers());

        System.out.println("Enter the User Name that you would like to remove:  ");
        String name = sc.next();

        //check whether the dish Customer want to remove exist in the dishLine
        int index = dishLine.checkUserPosition(name);
        if (index == -1) {
            System.out.println("Not in the User Line");
            removeUsers();
        }

        System.out.println("Dish Remove Successfully");

        //update the total number of storeUser
        for (int i = index; i < storeUsers.total - 1; i++) {
            storeUsers.users[i] = storeUsers.users[i + 1];
            storeUsers.total--;
        }
    }

//    private static void loadUser() {
//        System.out.println("Input your Username: ");
//        String name = sc.nextLine();
//        System.out.println("Input your Password (input 8 pure numbers): ");
//        String password = sc.nextLine();
//        for (int i = 0; i < storeUsers.total; i++) {
//            if (storeUsers.users[i].getUsername().equals(name)) {
//                if (storeUsers.users[i].getPassword() == Integer.valueOf(password)) {
//                    System.out.println("Welcome, " + name "!");
//                    if (!storeUsers.users[i].isOwner) {
//                        new Customer();
//                    } else {
//                        storeUsers.users[i].runMenu();
//                    }
//                }
//            }
//        }
//    }
}
