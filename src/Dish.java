
public class Dish {

    public String dishName = "";
    public double price = -1;
    public String flavor = "";
    //private boolean inCurrentDishesLine = false;

    public Dish() {
    }

    /**
     * Constructor for objects of class Dish
     *
     * @param dishName DishName of the dish
     * @param price    Price of the dish
     * @param flavor   Flavor of the dish
     *                 This is for Owner
     */
    public Dish(String dishName, double price, String flavor) {
        this.dishName = dishName;
        this.price = price;
        this.flavor = flavor;
    }

    /**
     * getter
     *
     * @return dishName
     */
    public String getDishName() {
        return dishName;
    }

    /**
     * setter
     *
     * @param dishName
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * getter
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter
     *
     * @return flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * setter
     *
     * @param flavor
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * @return Details of the specific product
     */
    public String toString() {
        return " Dish description:   " + dishName
                + "   ,   dish's price: " + price
                + "   ,   flavor: " + flavor;
    }
}
