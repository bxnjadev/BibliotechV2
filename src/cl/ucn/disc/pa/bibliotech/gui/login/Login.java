package cl.ucn.disc.pa.bibliotech.gui.login;

import cl.ucn.disc.pa.bibliotech.auth.AuthService;
import cl.ucn.disc.pa.bibliotech.gui.menu.MainMenu;
import cl.ucn.disc.pa.bibliotech.helper.GuiHelper;
import cl.ucn.disc.pa.bibliotech.user.UserAccessRequest;

import javax.swing.*;

public class Login extends JFrame {

    private final AuthService authService;
    private final MainMenu mainMenu;

    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel mainPanel;

    public Login(AuthService authService, MainMenu mainMenu) {
        this.authService = authService;
        this.mainMenu = mainMenu;

        loadButtons();
    }

    public void showGui() {
        setContentPane(mainPanel);

        setTitle("Login");
        setSize(300,300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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

        GuiHelper.showActionPerformed("Login Realizado!");

        setVisible(false);
        mainMenu.open();
    }


}
