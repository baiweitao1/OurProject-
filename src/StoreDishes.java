public class StoreDishes {

    public Dish[] dishes = new Dish[10];
    public int total = 0;  //dual purpose. 1) number of items stored in array, 2) next available index location

    /**
     * creat a dish array which is large enough to hold the dishes
     */
    public StoreDishes() {
        dishes = new Dish[15];
    }

    private boolean isFull() {
        return total == dishes.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    /**
     * If there is space available, add the dish object, passed as a parameter, to the array.
     *
     * @param dish Dish object to be added to the array.
     * @return Status of the add; true for success, false for fail.
     */
    public boolean add(Dish dish) {
        if (isFull()) {
            return false;
        } else {
            dishes[total] = dish;
            total++;
            return true;
        }
    }

    /**
     * This method builds and returns a String containing all the products in the array.
     * For each product in the array, the associated index number is included.
     * If no dishes are stored in the array, the String "No dishes in the store" is returned.
     *
     * @return A String containing all the dishes in the array, or "No dishes in the store",
     * if empty.
     */
    public String listDishes() {
        if (isEmpty()) {
            return "No dishes are ordered";
        } else {
            String listOfDishes = "";
            for (int i = 0; i < total; i++) {
                listOfDishes += (i + 1) + " Dish : " + dishes[i] + "\n";
            }
            return listOfDishes;
        }
    }

    /**
     * This method builds and returns an int which show the position of the Customer wanted Dish in the Menu
     *
     * @param dishName
     * @return The index of the Customer wanted Dish,
     * if the wanted Dish exist in the Menu, then print out "Searched Dish found "
     * and return the index of the wanted Dish
     * if the wanted Dish doesn't exist in the Menu, then print out "Searched Dish not found "
     * and return -1
     */
    public int checkUserPosition(String dishName) {
        for (int i = 0; i < total; i++) {
            if (dishName.equals(dishes[i].dishName)) {
                System.out.println("Searched Dish found ");
                return i;
            }
        }
        return -1;
    }

}
