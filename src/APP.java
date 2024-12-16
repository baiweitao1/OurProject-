import java.util.Scanner;

public class APP {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Unfinished
        //print out List
        addUsers();//customer or owner

    }

    //Unfinished
    public static void printList() {
        System.out.println("""
                """);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:addUsers();
            break;
        }
    }

    //Unfinished
    public static void addUsers() {
        User[] users = new User[10];
        User user = new User();
        System.out.println("add how many users");

        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("enter user name");
            String name = sc.next();
            user.setUsername(name);
            System.out.println("enter password(8位数)");
            int password = sc.nextInt();
            user.setPassword(password);
            users[i] = user;
        }
    }

    //Unfinished
    public static void printUsers(User[] users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    //Unfinished
    public static void removeUsers() {}

    //Unfinished
    public static void loadUser() {}
}
