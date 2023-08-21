package First;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    private String name;
    private String email;
    private String password;
    private String address;

    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
}

class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public boolean isEmailTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}

public class MyFirstCode {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your shipping address: ");
        String address = scanner.nextLine();
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
            System.out.println("All fields are required. Please try again.");
        } else if (!isValidEmail(email)) {
            System.out.println("Invalid email address format. Please try again.");
        } else if (userRepository.isEmailTaken(email)) {
            System.out.println("Email address is already registered. Please try again with a different email.");
        } else {
            User user = new User(name, email, password, address);
            userRepository.registerUser(user);
            System.out.println("User registration successful!");
        }
        scanner.close();
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

