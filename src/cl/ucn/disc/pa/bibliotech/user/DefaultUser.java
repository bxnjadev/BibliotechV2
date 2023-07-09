package cl.ucn.disc.pa.bibliotech.user;

public class DefaultUser implements User {

    private final String name;
    private final String rut;
    private final String lastName;
    private final String password;

    public DefaultUser(String name, String rut, String lastName, String password) {
        this.name = name;
        this.rut = rut;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRut() {
        return rut;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
