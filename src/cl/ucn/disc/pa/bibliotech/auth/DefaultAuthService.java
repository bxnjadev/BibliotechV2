package cl.ucn.disc.pa.bibliotech.auth;

import cl.ucn.disc.pa.bibliotech.user.User;
import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

import java.util.List;
import java.util.Locale;

public class DefaultAuthService implements AuthService {

    private final List<User> users;
    private User userLogged;

    public DefaultAuthService(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean login(UserAccessRequest userAccessRequest) {

        User userSearched = findUserByName
                (userAccessRequest.getName());

        if (userSearched == null) {
            return false;
        }

        if (!userSearched.getPassword().equals(userAccessRequest.getPassword())) {
            return false;
        }

        setUserLogged(userSearched);
        return true;
    }

    @Override
    public void logout() {
        userLogged = null;
    }

    public User getUserLogged() {
        return userLogged;
    }

    private void setUserLogged(User user) {
        userLogged = user;
    }

    @Override
    public boolean isLoggedIn() {
        return userLogged != null;
    }

    private User findUserByName(String name) {
        name = name.toLowerCase(Locale.ROOT);

        for (User user : users) {
            String userName = user.getName();
            userName = userName.toLowerCase(Locale.ROOT);

            if (userName.equals(name)) {
                return user;
            }
        }

        return null;
    }

}
