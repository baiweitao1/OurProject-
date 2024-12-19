import java.util.Scanner;

public class Owner extends User {

    private Scanner input = new Scanner(System.in);

    public Owner() {
        System.out.println("Welcome, Owner! Add some dishes to your Menu.");
        addDishes();
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                Owner's Menu
                ---------
                   1) List the Dishes on the Menu
                   2) Add Dishes to the Menu
                   3) Update the Menu
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
                case 2 -> addDishes();
                case 3 -> updateMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.print("Press enter key to continue...");
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

    private void addDishes() {
        //find out from the owner how many dishes they would like to add
        System.out.print("How many dishes would you like to have in your Menu?  ");
        int numberDishes = input.nextInt();

        APP.storeDishes = new StoreDishes();

        //ask the user for the details of the products and add them to the order
        for (int i = 0; i < numberDishes; i++) {
            addDish();
        }
    }

    //gather the dish data from the user and create a new dish object.
    private void addDish() {
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the Dish Name:  ");
        String dishName = input.nextLine();
        System.out.print("Enter the Dish Price:  ");
        double dishPrice = input.nextDouble();
        System.out.print("Enter the Dish's Flavor:  ");
        String flavor = input.next();

        boolean isAdded = APP.storeDishes.add(new Dish(dishName, dishPrice, flavor));
        if (isAdded) {
            System.out.println("Dish Added Successfully\n");
        } else {
            System.out.println("No Dish Added\n");
        }
    }


    private void updateMenu() {
        //ask what dish that owner want to change
        System.out.println("Current Menu:");
        System.out.print(APP.storeDishes.listDishes());

        System.out.print("Enter the Dish Name that you would like to update:  ");
        String name = input.next();

        boolean isFound = false;
        int index = 0;
        for (int i = 0; i < APP.storeDishes.total; i++) {
            if (APP.storeDishes.dishes[i].dishName.equals(name)) {
                isFound = true;
                index = i;
                break;
            }
        }

        if (isFound) {
            System.out.println("Searched Dish Exist.");
            System.out.print("""
                    Update the Name to
                    ==>>""");
            String newName = input.next();
            APP.storeDishes.dishes[index].setDishName(newName);
            System.out.println("Update the Price to ->");
            int newPrice = input.nextInt();
            APP.storeDishes.dishes[index].setPrice(newPrice);
            System.out.println("Update the Flavor to ->");
            String newFlavor = input.next();
            APP.storeDishes.dishes[index].setFlavor(newFlavor);

            System.out.println("Update Menu successfully");

            System.out.println("\nUpdated Menu:");
            System.out.println(APP.storeDishes.listDishes());
        } else {
            System.out.println("Searched Dish Not Exist.");
        }
    }
}