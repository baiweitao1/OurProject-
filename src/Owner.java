import java.util.Scanner;

/**
 * This class runs the application and handles the Product I/O
 *
 * @version 2.2
 */
public class Owner extends User {

    private Scanner input = new Scanner(System.in);
    private StoreDishes storeDishes;

    public static void main(String[] args) {
        new Owner();
    }

//    Just for test
//    private Owner() {
//        addDishes();
//        runMenu();
//    }

    private int mainMenu() {
        System.out.print("""
                ShopOwner's Menu
                ---------
                   1) List the Dishes on the Menu
                   2) Add Dishes to the Menu
                   3) Update the Menu
                   0) Exit
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
            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine(); //second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    //print the dish (the toString method is automatically called).
    private void printDishes() {
        System.out.println("List of Dishes are:");
        System.out.println(storeDishes.listDishes());
    }

    //print out a list of all current dishes i.e. that are in the current dish line.
    private void printCurrentDishes() {
        System.out.println("List of CURRENT Dishes are:");
        System.out.println(storeDishes.listCurrentDishes());
    }

    private void addDishes() {
        //find out from the user how many products they would like to order
        System.out.print("How many dishes would you like to have in your Menu?  ");
        int numberDishes = input.nextInt();

        storeDishes = new StoreDishes(numberDishes);

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

        boolean isAdded = storeDishes.add(new Dish(dishName, dishPrice, flavor));
        if (isAdded) {
            System.out.println("Dish Added Successfully");
        } else {
            System.out.println("No Dish Added");
        }
    }


    private void updateMenu() {
        //ask what dish that owner want to change
        System.out.println("Current Menu:");
        System.out.println(storeDishes.listDishes());
        System.out.println("Enter the Dish Name that you would like to update:  ");
        String name = input.next();
        boolean isFinded = false;
        int index = 0;
        for (int i = 0; i < storeDishes.total; i++) {
            if (storeDishes.dishes[i].dishName.equals(name)) {
                isFinded = true;
                index = i;
                break;
            }
        }
        if (isFinded) {
            System.out.println("Searched Dish Exist.");
            System.out.println("Update the Name to ->");
            String newName = input.next();
            storeDishes.dishes[index].setDishName(newName);
            System.out.println("Update the Price to ->");
            int newPrice = input.nextInt();
            storeDishes.dishes[index].setPrice(newPrice);
            System.out.println("Update the Flavor to ->");
            String newFlavor = input.next();
            storeDishes.dishes[index].setFlavor(newFlavor);

            System.out.println("Update Menu successfully");

            System.out.println("\nUpdated Menu:");
            System.out.println(storeDishes.listDishes());
        } else {
            System.out.println("Searched Dish Not Exist.");
        }
    }
}