package user;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, UserData> users;

    public AccountService() {
        users = new HashMap<>();
    }

    public void addUser(String login, String password) {
        users.put(login, new UserData(login, password));
    }

    public boolean logIn(String login, String password) {
        if(users.get(login).comparePassword(password)) {
            return true;
        } else {
            return false;
        }
    }
}
