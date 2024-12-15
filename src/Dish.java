
public class Dish {

    private String dishName = "";
    private double price = -1;
    private String flavor = "";
    private boolean inCurrentDishesLine = false;

    public Dish() {
    }

    /**
     * Constructor for objects of class Dish
     *
     * @param dishName DishName of the dish
     * @param price    Price of the dish
     * @param flavor   Flavor of the dish
     */
    public Dish(String dishName, double price, String flavor, boolean inCurrentDishesLine) {
        this.dishName = dishName;
        this.price = price;
        this.flavor = flavor;
        this.inCurrentDishesLine = inCurrentDishesLine;
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
     * getter
     *
     * @return inCurrentDishesLine
     */
    public boolean isInCurrentDishesLine() {
        return inCurrentDishesLine;
    }

    /**
     * setter
     *
     * @param inCurrentDishesLine
     */
    public void setInCurrentDishesLine(boolean inCurrentDishesLine) {
        this.inCurrentDishesLine = inCurrentDishesLine;
    }

    /**
     * @return Details of the specific product
     */
    public String toString() {
        return "Dish description: " + dishName
                + ", dish's price: " + price
                + ", flavor: " + flavor
                + ", currently in dish line: " + inCurrentDishesLine;
    }
}
