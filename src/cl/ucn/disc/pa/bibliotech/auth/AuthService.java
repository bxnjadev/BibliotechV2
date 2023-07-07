package cl.ucn.disc.pa.bibliotech.auth;

import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

public interface AuthService {

    void login(UserAccessRequest userAccessRequest);

    void logout();

    boolean isLoggedIn();

}
