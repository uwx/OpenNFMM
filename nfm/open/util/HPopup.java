package nfm.open.util;

import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import nfm.open.Madness;

/**
 * The H is for 'Hansen'
 *
 * @author Rafael
 */
public final class HPopup {

    private HPopup() {
    }

    public static void message(final Object message) throws HeadlessException {
        JOptionPane.showMessageDialog(Madness.frame, message);
    }

    public static void message(final Object message, final String title, final int messageType) throws HeadlessException {
        JOptionPane.showMessageDialog(Madness.frame, message, title, messageType);
    }

    public static void message(final Object message, final String title, final int messageType, final Icon icon) throws HeadlessException {
        JOptionPane.showMessageDialog(Madness.frame, message, title, messageType, icon);
    }
}
