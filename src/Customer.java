import java.util.Scanner;

public class Customer extends User {

    private Scanner input = new Scanner(System.in);

/*    For test
    static StoreDishes storeDishes = new StoreDishes(2);
    static StoreDishes dishLine = new StoreDishes(5);

    public static void main(String[] args) {
        storeDishes.add(new Dish("dishName1", 12, "flavor1"));
        storeDishes.add(new Dish("dishName2", 12, "flavor2"));
        dishLine.add(new Dish("dishName3", 12, "flavor3"));
        new Customer();
    }*/

    public Customer() {
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                Customer's Menu
                ---------
                   1) BrowseMenu the Dishes
                   2) List the ordered Dishes
                   3) Order some dishes
                   4) Remove dishes from current order
                   0) Go Back to User Menu
                ==>> """);
        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> printDishes();
                case 2 -> printCurrentDishes();
                case 3 -> processOrder();
                case 4 -> removeDishes();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("Press enter key to continue...");
            input.nextLine();
            input.nextLine(); //second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = mainMenu();
        }

        APP.runMenu();
    }

    //print the dish (the toString method is automatically called).
    private void printDishes() {
        System.out.println("List of Dishes are:");
        System.out.println(APP.storeDishes.listDishes());
    }

    //print out a list of all current dishes i.e. that are in the current dish line.
    private void printCurrentDishes() {
        System.out.println("List of CURRENT Dishes are:");
        System.out.println(APP.dishLine.listDishes());
        double totalPrice = 0;
        for (int i = 0; i < APP.dishLine.total; i++) {
            totalPrice += APP.dishLine.dishes[i].getPrice();
        }
        System.out.println("Total Price: " + totalPrice + " ¥");
    }


    private void processOrder() {
        //find out from the user how many products they would like to order
        System.out.print("How many dishes would you like to have in your Menu?  ");
        int numberDishes = input.nextInt();

        APP.dishLine = new StoreDishes();

        //ask the user for the details of the products and add them to the order
        for (int i = 0; i < numberDishes; i++) {
            orderDish();
        }
    }

    private void orderDish() {
        System.out.println("Enter the Dish Name:  ");
        String dishName = input.next();
        //check whether the dish exist in the storeDishes
        int index = APP.storeDishes.checkUserPosition(dishName);
        if (index == -1) {
            System.out.println("Invalid Dish Name, Try again ");
            orderDish();
        }
        //Check whether the dish has been ordered
        if (APP.dishLine.checkUserPosition(dishName) >= 0) {
            System.out.println("Already in Dish Line, Try again ");
            orderDish();
        }
        //Add the dish into the DishLine
        APP.dishLine.add(APP.storeDishes.dishes[index]);
        System.out.println("Order Successfully ");
        System.out.println("Current Ordered Dish Line: " + APP.dishLine.listDishes());

    }

    //remove the dish that stored in the array
    private void removeDishes() {
        //find out from the user how many dishes they would like to remove
        System.out.print("How many dishes would you like to remove in your Menu?  ");
        int numberDishes = input.nextInt();

        //ask the user for the details of the dishes and remove them from the order
        for (int i = 0; i < numberDishes; i++) {
            removeDish();
        }
    }

    private void removeDish() {
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.
        System.out.println("Current Menu:");
        System.out.println(APP.dishLine.listDishes());

        System.out.println("Enter the Dish Name that you would like to remove:  ");
        String name = input.next();

        //check whether the dish Customer want to remove exist in the dishLine
        int index = APP.dishLine.checkUserPosition(name);
        if (index == -1) {
            System.out.println("Not in the Dish Line");
            removeDish();
        }

        APP.dishLine.dishes[index] = null;
        System.out.println("Dish Remove Successfully");

        //update the total number of dishLine
        for (int i = index; i < APP.dishLine.total - 1; i++) {
            APP.dishLine.dishes[i] = APP.dishLine.dishes[i + 1];
            APP.dishLine.total--;
        }
    }
}
