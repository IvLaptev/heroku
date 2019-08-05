package user;

public class UserData {
    private String login;
    private String password;

    public UserData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }
}
