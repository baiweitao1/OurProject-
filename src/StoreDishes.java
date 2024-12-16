public class StoreDishes {

    public Dish[] dishes;
    public int total = 0;  //dual purpose. 1) number of items stored in array, 2) next available index location

    public StoreDishes(int numberItems) {
        dishes = new Dish[numberItems];
    }

    private boolean isFull() {
        return total == dishes.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    /**
     * If there is space available, add the dish object, passed as a parameter, to the array.
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
     * @return A String containing all the dishes in the array, or "No dishes in the store",
     * if empty.
     */
    public String listDishes() {
        if (isEmpty()) {
            return "No dishes in the store";
        } else {
            String listOfDishes = "";
            for (int i = 0; i < total; i++) {
                listOfDishes += i + ": " + dishes[i] + "\n";
            }
            return listOfDishes;
        }
    }

    /**
     * This method returns the cheapest dish in the array.
     * If no dishes are stored in the array, null is returned.
     *
     * @return The cheapest Dish in the array or null, if no dishes are added yet.
     */
    public Dish cheapestProduct() {
        if (!isEmpty()) {
            Dish cheapestDish = dishes[0];
            for (int i = 1; i < total; i++) {
                if (dishes[i].getPrice() < cheapestDish.getPrice())
                    cheapestDish = dishes[i];
            }
            return cheapestDish;
        } else {
            return null;
        }
    }

    /**
     * This method builds and returns a String containing all the dishes in the array
     * that are in the current dish line.
     * For each dish added to the String, the associated index number is included.
     * @return A String containing all the dishes in the array, or "No dishes are in our current
     * dish line", if none in the current line.  If no dishes are stored in the array, the
     * returned String indicates this.
     */
    public String listCurrentDishes() {
        if (isEmpty()) {
            return "No Products in the store";
        } else {
            String listOfDishes = "";
            for (int i = 0; i < total; i++) {
                if (dishes[i].isInCurrentDishesLine())
                    listOfDishes += i + ": " + dishes[i] + "\n";
            }
            if (listOfDishes.equals("")) {
                return "No Products are in our current product line";
            } else {
                return listOfDishes;
            }
        }
    }

    /**
     * This method returns the average dish price of all the products in the array.
     * If no dishes are stored in the array, the value returned is -1.
     *
     * @return The average dish's price, or -1 if no products exist.
     */
    public double averageDishesPrice() {
        if (!isEmpty()) {
            double totalPrice = 0;
            for (int i = 0; i < total; i++) {
                totalPrice += dishes[i].getPrice();
            }
            return totalPrice / total;
        } else {
            return -1;
        }

    }

    /**
     * This method builds and returns a String containing all the dishes in the array
     * that are more expensive that a specific amount (passed as a parameter).
     *
     * For each product added to the String, the associated index number is included.
     * If no dishes are stored in the array, the returned String indicates this.
     *
     * @param price The value used to filter for products costing more than it.
     * @return A String containing all the products in the array more expensive than the parameter value
     * or "No Dishes are more expensive than: ", if none are more expensive.  If no Dishes are
     * in the array, the returned String contains "No Dishes in store".
     */
    public String listDishesAboveAPrice(double price) {
        if (isEmpty()) {
            return "No Dishes in the store";
        } else {
            String str = "";
            for (int i = 0; i < total; i++) {
                if (dishes[i].getPrice() > price)
                    str += i + ": " + dishes[i] + "\n";
            }
            if (str.equals("")) {
                return "No dishes are more expensive than: " + price;
            } else {
                return str;
            }
        }
    }

}
