package cl.ucn.disc.pa.bibliotech.reader.adapters;

import cl.ucn.disc.pa.bibliotech.reader.AdapterReader;
import cl.ucn.disc.pa.bibliotech.user.DefaultUser;
import cl.ucn.disc.pa.bibliotech.user.User;

public class UserAdapterReader implements AdapterReader<User> {

    private static final String CHARACTER_SEPARATOR = ",";

    @Override
    public String write(User object) {
        return object.toString();
    }

    @Override
    public User read(String value) {

        String[] fields = value.split(CHARACTER_SEPARATOR);

        String rut = fields[0];
        String name = fields[1];
        String lastName = fields[2];
        String password = fields[3];

        return new DefaultUser(
            name, rut, lastName, password
        );
    }

}
