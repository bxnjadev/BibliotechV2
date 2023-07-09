package cl.ucn.disc.pa.bibliotech.auth;

import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

public interface AuthService {

    boolean login(UserAccessRequest userAccessRequest);

    void logout();

    boolean isLoggedIn();

}
