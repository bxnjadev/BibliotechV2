package cl.ucn.disc.pa.bibliotech.user;

public class UserAccessRequest {

    private final String name;
    private final String password;

    public UserAccessRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
