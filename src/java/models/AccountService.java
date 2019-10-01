package models;


public class AccountService {
    public User login(String username, String password) {
        if (password.equals("password") && username.equals("adam") || username.equals("betty")) {
            return new User(username, password);
        }
        return null;
    }
}
