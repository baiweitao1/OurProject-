public class User {
    private String username;
    private int password;
    private boolean inCurrentUsersLine = false;

    public User() {
    }

    public User(String username, int password, boolean inCurrentUsersLine) {
        this.username = username;
        this.password = password;
        this.inCurrentUsersLine = inCurrentUsersLine;
    }

    /**
     * Sets username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Sets password
     *
     * @param password
     */
    public void setPassword(int password) {
        this.password = password;
    }

    /**
     * Sets inCurrentUsersLine
     *
     * @param iinnCurrentUsersLine
     */
    public void setInCurrentUsersLine(boolean inCurrentUsersLine) {
        this.inCurrentUsersLine = inCurrentUsersLine;
    }

    public boolean isInCurrentUsersLine() {
        return inCurrentUsersLine;
    }

    public String toString() {
        return "User{username = " + username
                + ", password = " + password
                + ", currently in user line: " + inCurrentUsersLine + "}";
    }
}
