package cl.ucn.disc.pa.bibliotech.auth;

import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

public interface AuthService {

    /**
     * Make login in the system
     * @param userAccessRequest the credentials
     * @return true login is acces
     */

    boolean login(UserAccessRequest userAccessRequest);

    /**
     * Loogut the program
     */

    void logout();

    /**
     * Check if login
     * @return
     */

    boolean isLoggedIn();

}
