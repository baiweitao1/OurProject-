public class StoreUsers {

    private User[] users;
    private int total = 0;

    public StoreUsers(int numberItems) {
        users = new User[numberItems];
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
     * This method builds and returns a String containing all the users in the array
     * that are in the current user line.
     * For each user added to the String, the associated index number is included.
     * @return A String containing all the users in the array, or "No users are in our current
     * user line", if none in the current line.  If no users are stored in the array, the
     * returned String indicates this.
     */
    public String listCurrentUsers() {
        if (isEmpty()) {
            return "No Users in the List";
        } else {
            String listOfUsers = "";
            for (int i = 0; i < total; i++) {
                if (users[i].isInCurrentUsersLine())
                    listOfUsers += i + ": " + users[i] + "\n";
            }
            if (listOfUsers.equals("")) {
                return "No Users are in our current user line";
            } else {
                return listOfUsers;
            }
        }
    }

}
