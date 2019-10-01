package models;


public class AccountService {
    public User login(String username, String password) {
        if (username.equals("adam") || username.equals("betty") && password.equals("password")) {
            return new User(username, password);
        }
        return null;
    }
}
