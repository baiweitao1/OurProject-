public class StoreUsers {

    public User[] users;
    public int total = 0;

    /**
     * creat a user array which is large enough to hold the users
     */
    public StoreUsers() {
        users = new User[10];
    }

    private boolean isFull() {
        return total == users.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    /**
     * If there is space available, add the user object, passed as a parameter, to the array.
     *
     * @param user user object to be added to the array.
     * @return Status of the add; true for success, false for fail.
     */
    public boolean add(User user) {
        if (isFull()) {
            return false;
        } else {
            users[total] = user;
            total++;
            return true;
        }
    }

    /**
     * This method builds and returns a String containing all the products in the array.
     * For each product in the array, the associated index number is included.
     * If no user are stored in the array, the String "No users in the store" is returned.
     *
     * @return A String containing all the dishes in the array, or "No users in the store",
     * if empty.
     */
    public String listUsers() {
        if (isEmpty()) {
            return "No users in the List";
        } else {
            String listOfUsers = "";
            for (int i = 0; i < total; i++) {
                listOfUsers += i + ": " + users[i] + "\n";
            }
            return listOfUsers;
        }
    }

    /**
     * This method builds and returns an int which show the position of the user in the users array
     *
     * @param userName
     * @return The index where the user is stored in the array,
     * if the wanted user exist in the users array, then print out "Searched User found "
     * and return the index of the wanted Dish
     * if the wanted user doesn't exist in the users array, then print out "Searched User not found "
     * and return -1
     */
    public int checkUserPosition(String userName) {
        for (int i = 0; i < total; i++) {
            if (userName.equals(users[i].getUsername())) {
                System.out.println("Searched User found ");
                return i;
            }
        }
        return -1;
    }

    public void removeUser(String userName) {
        for (int i = 0; i < total; i++) {

        }
    }

}
