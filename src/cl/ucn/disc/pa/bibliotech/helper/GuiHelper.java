package cl.ucn.disc.pa.bibliotech.helper;

import javax.swing.*;

public class GuiHelper {

    private static final String TITLE_ERROR = "Error";
    private static final String TITLE_PERFORMED = "Realizado!";

    public static void showMessageError(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, TITLE_ERROR,
                JOptionPane.ERROR_MESSAGE);
    }

    public static  void showActionPerformed(String message){
        JOptionPane.showMessageDialog(new JFrame(), message, TITLE_PERFORMED,
                JOptionPane.INFORMATION_MESSAGE);
    }

}
