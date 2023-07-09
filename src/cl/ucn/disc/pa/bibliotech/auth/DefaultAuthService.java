package cl.ucn.disc.pa.bibliotech.auth;

import cl.ucn.disc.pa.bibliotech.user.User;
import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

import java.util.List;
import java.util.Optional;

public class DefaultAuthService implements AuthService {

    private final List<User> users;
    private User userLogged;

    public DefaultAuthService(List<User> users) {
        this.users = users;
    }

    @Override
    public void login(UserAccessRequest userAccessRequest) {

        Optional<User> userOptional = findUserByName
                (userAccessRequest.getName());

        if (!userOptional.isPresent()) {
            //Warn is not present
            return;
        }

        User user = userOptional.get();
        setUserLogged(user);

    }

    @Override
    public void logout() {
        userLogged = null;
    }

    public User getUserLogged() {
        return userLogged;
    }

    private void setUserLogged(User user){
        userLogged = user;
    }

    @Override
    public boolean isLoggedIn() {
        return userLogged != null;
    }

    private Optional<User> findUserByName(String name) {
        return users.stream().filter(user -> {
                    String nameUser = user.getName();
                    return nameUser.equals(name);
                }).
                findFirst();
    }

}
