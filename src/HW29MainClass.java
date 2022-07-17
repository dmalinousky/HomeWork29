import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HW29MainClass {
    public static void main(String[] args) throws Exception {
        // A couple of objects to fill the array
        User user1 = new User("login1", "password1");
        User user2 = new User("login2", "password2");
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        // The program itself
        getMenu(userList);

    }

    public static void getMenu(ArrayList<User> userList) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter what you want to do:\n" +
                "1. Add new user.\n" +
                "2. Delete existing user.\n" +
                "3. Check if user exists.\n" +
                "4. Change existing user's login.\n" +
                "5. Change existing user's password.\n" +
                "6. Exit.");
        try {
            int action = Integer.parseInt(reader.readLine());
            switch (action) {
                case 1 :
                    try {
                        userList.add(User.addUser());
                        System.out.println("New user has been added.");
                        userList.forEach(x -> System.out.print(x.toString()));
                    } catch (Exception exception) {
                        System.out.println("Incorrect data.");
                    }
                    getMenu(userList);
                    break;
                case 2 :
                    try {
                        Integer position = User.checkUser(userList);
                        if (position != null) {
                            userList.remove(position.intValue());
                            System.out.println("The user has been removed.");
                            userList.forEach(x -> System.out.print(x.toString()));
                        } else {
                            System.out.println("Check the data.");
                        }
                    } catch (Exception exception) {
                        System.out.println("Incorrect data.");
                    }
                    getMenu(userList);
                    break;
                case 3 :
                    try {
                        System.out.println((User.checkUser(userList) != null) ? "User was found." : "User wasn't found.");
                    } catch (Exception exception) {
                        System.out.println("Incorrect data.");
                    }
                    getMenu(userList);
                    break;
                case 4 :
                    try {
                        Integer position = User.checkUser(userList);
                        if (position != null) {
                            User.changeLogin(userList, position);
                            System.out.println("The login has been changed.");
                            userList.forEach(x -> System.out.print(x.toString()));
                        } else {
                            System.out.println("Check the data.");
                        }
                    } catch (Exception exception) {
                        System.out.println("Incorrect data.");
                    }
                    getMenu(userList);
                    break;
                case 5 :
                    try {
                        Integer position = User.checkUser(userList);
                        if (position != null) {
                            User.changePassword(userList, position);
                            System.out.println("The password has been changed.");
                            userList.forEach(x -> System.out.print(x.toString()));
                        } else {
                            System.out.println("Check the data.");
                        }
                    }  catch (Exception exception) {
                        System.out.println("Incorrect data.");
                    }
                    getMenu(userList);
                    break;
                case 6 :
                    new User().exit();
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Incorrect data.");
            getMenu(userList);
        }
    }
}
