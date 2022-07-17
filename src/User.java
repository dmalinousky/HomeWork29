import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User {" +
                "login = \'" + login + '\'' +
                ", password = \'" + password + "\'}\n";
    }

    public static User addUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Provide new user's login:");
        String providedLogin = reader.readLine();
        System.out.println("Provide new user's password:");
        String providedPassword = reader.readLine();
        User user = new User();
        user.setLogin(providedLogin);
        user.setPassword(providedPassword);
        return user;
    }

    public static Integer checkUser(ArrayList<User> userList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Provide login for search:");
        String providedLogin = reader.readLine();
        System.out.println("Provide password for search:");
        String providedPassword = reader.readLine();
        // Because of forEach method isExist variable can't be usual
        Integer[] isExist = {null};
        userList.forEach(x -> {
            if (x.getLogin().equals(providedLogin) && x.getPassword().equals(providedPassword)) {
                isExist[0] = userList.indexOf(x);
            }
        });
        return isExist[0];
    }

    public static void changeLogin(ArrayList<User> userList, Integer position) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter new login:");
        String newLogin = reader.readLine();
        userList.get(position).setLogin(newLogin);
        System.out.println("Incorrect data!");
    }

    public static void changePassword(ArrayList<User> userList, Integer position) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter new password:");
        String newPassword = reader.readLine();
        userList.get(position).setPassword(newPassword);
        System.out.println("Incorrect data!");
    }

    public void exit() {
        System.out.println("Exiting...");
        return;
    }
}
