import java.util.Scanner;

public class APP {
    public StoreUsers storeUsers;
    private StoreDishes storeDishes;
    private StoreDishes dishLine;
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
        addUser(judge);
        runMenu();
    }

    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> addUser();
                case 2 -> loadUser();
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

    private int mainMenu() {
        System.out.print("""
                    User Menu
                    ---------
                       1) BrowseMenu the Dishes
                       2) List the ordered Dishes
                       3) Order some dishes
                       4) Remove dishes from current order
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
    private void addUser() {
        User user = new User();
        System.out.println("Input your Username: ");
        String name = sc.next();
        user.setUsername(name);

        System.out.println("Input your Password (input 8 pure numbers): ");
        String password = sc.next();
        System.out.println("Input your Password again: ");
        String passwordAgain = sc.next();
        while (!password.equals(passwordAgain)) {
            System.out.println("Passwords do not match!\nTry again.");
            addUser();
        }
        user.setPassword(Integer.valueOf(password));

        storeUsers.add(user);
        System.out.println("Register successful!");
    }

    //Method Overload
    private void addUser(String judge) {
        if (judge.toUpperCase().equals("Y")) {
            addUser();
            storeUsers.users[storeUsers.total - 1].setIsOwner(true);
        } else {
            addUser();
        }
    }

    //Unfinished
    private void printUsers(User[] users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    //Unfinished
    private void removeUsers() {
        sc.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.
        System.out.println("Current Users:");
        System.out.println(storeUsers.listUsers());

        System.out.println("Enter the User Name that you would like to remove:  ");
        String name = sc.next();

        //check whether the dish Customer want to remove exist in the dishLine
        int index = dishLine.checkUserPosition(name);
        if ( index == -1) {
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

    //Unfinished
    private void loadUser() {}
}
