import java.util.Scanner;

public class Customer extends User {
    private Scanner input = new Scanner(System.in);
    //private StoreDishes storeDishes;
    //For test
    static StoreDishes storeDishes = new StoreDishes(2);
    static StoreDishes dishLine = new StoreDishes(5);

    public static void main(String[] args) {
        storeDishes.add(new Dish("dishName1", 12, "flavor1"));
        storeDishes.add(new Dish("dishName2", 12, "flavor2"));
        dishLine.add(new Dish("dishName3", 12, "flavor3"));
        new Customer();
    }

    private Customer() {
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                Shop Menu
                ---------
                   1) BrowseMenu the Dishes
                   2) List the ordered Dishes
                   3) Order some dishes
                   4) Remove dishes from current order
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
                case 2 -> printCurrentDishes();
                case 3 -> processOrder();
                case 4 -> removeDishes();
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
        System.out.println(dishLine.listDishes());
        //Total: 1234566 ¥


        
    }


    private void processOrder() {
        //find out from the user how many products they would like to order
        System.out.print("How many dishes would you like to have in your Menu?  ");
        int numberDishes = input.nextInt();

        dishLine = new StoreDishes(5);

        //ask the user for the details of the products and add them to the order
        for (int i = 0; i < numberDishes; i++) {
            orderDish();
        }
    }

    private void orderDish() {
        System.out.println("Enter the Dish Name:  ");
        String dishName = input.next();
        //check whether the dish exist in the storeDishes
        int index = storeDishes.checkDishPosition(dishName);
        if (index == -1) {
            System.out.println("Invalid Dish Name, Try again ");
            orderDish();
        }
        //Check whether the dish has been ordered
        if (dishLine.checkDishPosition(dishName) >= 0) {
            System.out.println("Already in Dish Line, Try again ");
            orderDish();
        }
        //Add the dish into the DishLine
        dishLine.add(storeDishes.dishes[index]);
        System.out.println("Order Successfully ");
        System.out.println("Current Ordered Dish Line: " + dishLine.listDishes());

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
        System.out.println("Remove Dish Successfully");
    }

    private void removeDish() {
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.
        System.out.println("Current Menu:");
        System.out.println(dishLine.listDishes());

        System.out.println("Enter the Dish Name that you would like to remove:  ");
        String name = input.next();

        //check whether the dish Customer want to remove exist in the dishLine
        if (dishLine.checkDishPosition(name) == -1) {
            System.out.println("Not in the Dish Line");
            removeDish();
        }

        boolean isRemoved = false;
        int index = 0;
        for (int i = 0; i < dishLine.total; i++) {
            if (dishLine.dishes[i].dishName.equals(name)) {
                isRemoved = true;
                index = i;
                dishLine.total--;
                dishLine.dishes[i] = null;
                break;
            }
        }

        if (isRemoved) {
            System.out.println("Dish Remove Successfully");
        } else {
            System.out.println("Dish Not Found");
        }

        for (int i = index; i < dishLine.total - 1; i++) {
            dishLine.dishes[i] = dishLine.dishes[i + 1];
        }
    }

//    //gather the dish data from the user and create a new dish object.
//    private void addDish(){
//        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.
//
//        System.out.print("Enter the Dish Name:  ");
//        String dishName = input.nextLine();
//        System.out.print("Enter the Dish Price:  ");
//        double dishPrice = input.nextDouble();
//        System.out.print("Enter the Dish's Flavor:  ");
//        String flavor = input.next();
//
//        //Ask the user to type in either a Y or an N.  This is then
//        //converted to either a True or a False (i.e. a boolean value).
//        System.out.print("Is this Dish in your current line (y/n): ");
//        char currentProduct = input.next().charAt(0);
//        boolean inCurrentDishesLine = false;
//        if ((currentProduct == 'y') || (currentProduct == 'Y')) {
//            inCurrentDishesLine = true;
//        }
//
//        boolean isAdded = storeDishes.add(new Dish(dishName, dishPrice, flavor, inCurrentDishesLine));
//        if (isAdded){
//            System.out.println("Dish Added Successfully");
//        }
//        else{
//            System.out.println("No Dish Added");
//        }
//    }

}
