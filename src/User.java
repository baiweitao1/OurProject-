public class User {
    public String username;
    private int password;
    boolean isOwner = false;

    public User() {
    }

    public User(String username, int password, boolean isOwner) {
        this.username = username;
        this.password = password;
        this.isOwner = isOwner;
    }

    /**
     * get username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get password
     *
     * @return password
     */
    public int getPassword() {
        return password;
    }

    /**
     * set password
     *
     * @param password
     */
    public void setPassword(int password) {
        this.password = password;
    }

    /**
     * get boolean which show the user's identity
     *
     * @return isOwner
     */
    public boolean isIsOwner() {
        return isOwner;
    }

    /**
     * 设置
     *
     * @param isOwner
     */
    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    public String toString() {
        return "User { username  =  "
                + username + " ,  password  =  "
                + password + " ,  isOwner  =  "
                + isOwner + " }";
    }
}
