import java.util.Scanner;

/**
 * This class runs the application and handles the Product I/O
 * @version 2.2
 *
 */
public class Owner extends User{

    private Scanner input = new Scanner(System.in);
    private StoreDishes storeDishes;

    public static void main(String[] args) {
        new Owner();
    }

    public Owner() {
        processOrder();
        runMenu();
    }

    private int mainMenu(){
        System.out.print("""
               Shop Menu
               ---------
                  1) List the Dishes
                  2) List the current Dishes
                  3) Display the dish's prize
                  4) Display cheapest Dish
                  5) List Dishes that are more expensive than a given price
                  0) Exit
               ==>> """);
        int option = input.nextInt();
        return option;
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> printDishes();
                case 2 -> printCurrentDishes();
                case 3 -> printAverageDishesPrice();
                case 4 -> printCheapestProduct();
                case 5 -> printDishesAboveAPrice();
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


    private void processOrder(){
        //find out from the user how many products they would like to order
        System.out.print("How many dishes would you like to have in your Menu?  ");
        int numberProducts = input.nextInt();

        storeDishes = new StoreDishes(numberProducts);

        //ask the user for the details of the products and add them to the order
        for (int i = 0; i < numberProducts; i++){
            addProduct();
        }
    }

    //gather the dish data from the user and create a new dish object.
    private void addProduct(){
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the Dish Name:  ");
        String dishName = input.nextLine();
        System.out.print("Enter the Dish Price:  ");
        double dishPrice = input.nextDouble();
        System.out.print("Enter the Dish's Flavor:  ");
        String flavor = input.next();

        //Ask the user to type in either a Y or an N.  This is then
        //converted to either a True or a False (i.e. a boolean value).
        System.out.print("Is this Dish in your current line (y/n): ");
        char currentProduct = input.next().charAt(0);
        boolean inCurrentDishesLine = false;
        if ((currentProduct == 'y') || (currentProduct == 'Y')) {
            inCurrentDishesLine = true;
        }

        boolean isAdded = storeDishes.add(new Dish(dishName, dishPrice, flavor, inCurrentDishesLine));
        if (isAdded){
            System.out.println("Dish Added Successfully");
        }
        else{
            System.out.println("No Dish Added");
        }
    }

    //print the dish (the toString method is automatically called).
    private void printDishes(){
        System.out.println("List of Dishes are:");
        System.out.println(storeDishes.listDishes());
    }

    //print out a list of all current products i.e. that are in the current dish line.
    private void printCurrentDishes(){
        System.out.println("List of CURRENT Dishes are:");
        System.out.println(storeDishes.listCurrentDishes());
    }

    //print out the average dish price for all products stored in the array
    private void printAverageDishesPrice(){
        double averagePrice = storeDishes.averageDishesPrice();
        if (averagePrice != -1){
            System.out.println("The average dish price is: " + averagePrice);
        }
        else{
            System.out.println("There are no products in the storeDishes.");
        }
    }

    //print out the dish name that is the cheapest of those stored in the array
    private void printCheapestProduct(){
        Dish cheapestDish = storeDishes.cheapestProduct();
        if (cheapestDish != null) {
            System.out.println("The cheapest Dish is:  " + cheapestDish.getDishName());
        }
        else{
            System.out.println("There are no products in the storeDishes.");
        }
    }

    //ask the user to enter a price and print out all products costing that price or more.
    private void printDishesAboveAPrice(){
        System.out.print("View the Dishes costing more than this price:  ");
        double price = input.nextDouble();
        System.out.println(storeDishes.listDishesAboveAPrice(price));
    }

}