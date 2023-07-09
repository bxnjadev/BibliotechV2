package cl.ucn.disc.pa.bibliotech.gui.login;

import cl.ucn.disc.pa.bibliotech.auth.AuthService;
import cl.ucn.disc.pa.bibliotech.helper.GuiHelper;
import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

import javax.swing.*;

public class Login {

    private final AuthService authService;

    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login(AuthService authService) {
        this.authService = authService;

        loadButtons();
    }

    private void loadButtons() {
        loginButton.addActionListener(action -> {
            onButtonClick();
        });
    }

    private void onButtonClick() {

        String user = userField.getText();
        String password = new String(passwordField.getPassword());

        UserAccessRequest accessRequest = new UserAccessRequest(user, password);

        boolean status = authService.login(accessRequest);

        if (!status) {
            GuiHelper.showMessageError("Usuario incorrecto");
            return;
        }

    }


}
