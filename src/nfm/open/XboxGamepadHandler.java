package nfm.open;

import static com.ivan.xinput.enums.XInputButton.A;
import static com.ivan.xinput.enums.XInputButton.B;
import static com.ivan.xinput.enums.XInputButton.BACK;
import static com.ivan.xinput.enums.XInputButton.DPAD_DOWN;
import static com.ivan.xinput.enums.XInputButton.DPAD_LEFT;
import static com.ivan.xinput.enums.XInputButton.DPAD_RIGHT;
import static com.ivan.xinput.enums.XInputButton.DPAD_UP;
import static com.ivan.xinput.enums.XInputButton.RIGHT_SHOULDER;
import static com.ivan.xinput.enums.XInputButton.RIGHT_THUMBSTICK;
import static com.ivan.xinput.enums.XInputButton.START;
import static com.ivan.xinput.enums.XInputButton.X;
import static nfm.open.GameSparker.u;
import static nfm.open.GameSparker.view;
import static nfm.open.xtGraphics.fase;

import com.ivan.xinput.XInputAxes;
import com.ivan.xinput.XInputComponents;
import com.ivan.xinput.XInputDevice;
import com.ivan.xinput.XInputDevice14;
import com.ivan.xinput.enums.XInputButton;
import com.ivan.xinput.exceptions.XInputNotLoadedException;
import com.ivan.xinput.listener.SimpleXInputDeviceListener;

public final class XboxGamepadHandler {

    private static final float DEADZONE = 0.25f; // my controller, which has taken its toll, has a deadzone of only 0.1f

    public static int activeDevice = 0;
    public static int pActiveDevice = 0;
    private static XInputDevice[] devices;

    // control bools
    static boolean up;
    static boolean down;
    static boolean left;
    static boolean right;
    static boolean menuUp;
    static boolean menuDown;
    static boolean menuLeft;
    static boolean menuRight;
    static boolean menuAccept;
    static boolean pause;
    static boolean handb;

    private static SimpleXInputDeviceListener listener = new SimpleXInputDeviceListener() {
        @Override
        public void connected() {
            // resume the game
        }

        @Override
        public void disconnected() {
            // pause the game and display a message
        }

        @Override
        public void buttonChanged(final XInputButton button, final boolean pressed) {
            // the given button was just pressed (if pressed == true) or released (pressed == false)
            System.out.println((pressed ? "Pressed: " : "Released: ") + button.toString());

            if (button == A) {
                if (fase != 0) {
                    u[1].enter = pressed;
                } else {
                    u[1].handb = pressed;
                }
            }
            if (button == B && fase != 0) {
                u[1].exit = pressed;
            }
            if (button == RIGHT_THUMBSTICK) {
                u[1].lookback = pressed ? 1 : 0;
            }
            if (button == DPAD_LEFT) {
                u[1].left = pressed;
            }
            if (button == DPAD_RIGHT) {
                u[1].right = pressed;
            }
            if (button == DPAD_UP) {
                u[1].up = pressed;
            }
            if (button == DPAD_DOWN) {
                u[1].down = pressed;
            }
            if (button == BACK && pressed) {
                view++;
                if (view == 3) {
                    view = 0;
                }
            }
            if (button == START) {
                u[1].enter = pressed;
            }
        }
    };

    // end control booles
    private static boolean shut = false;

    public static void initialize() throws XInputNotLoadedException {
        if (XInputDevice.isAvailable()) {
            System.out.println("XInput 1.3 is available on this platform.");
        } else {
            shut = true;
            return;
        }
        if (XInputDevice14.isAvailable()) {
            shut = true;
            return;
        }
        devices = XInputDevice.getAllDevices();

        // retrieve the device for player 1
        final XInputDevice device = XInputDevice.getDeviceFor(activeDevice); // or devices[0]

        // use XInputDevice14 if you want to use the XInput 1.4 functions

        device.addListener(listener);
    }

    public static void update() {
        if (shut || devices == null) {
            return;
        }
        if (activeDevice == -1) {
            if (activeDevice != pActiveDevice) {
                devices[pActiveDevice].removeListener(listener);
                pActiveDevice = activeDevice;
            }
            return;
        }
        if (activeDevice != pActiveDevice) {
            if (pActiveDevice != -1) {
                devices[pActiveDevice].removeListener(listener);
            }
            devices[activeDevice].addListener(listener);
            pActiveDevice = activeDevice;
        }
        devices[activeDevice].poll();

        final XInputComponents components = devices[0].getComponents();

        final XInputAxes axes = components.getAxes();
//        System.out.println("rt:lt:" + axes.rt + ", " + axes.lt);
        u[1].up = axes.rt > 0.7f;
        u[1].down = axes.lt > 0.7f;

//        System.out.println("sticks:" + axes.lx + "," + axes.ly + "," + axes.rx + "," + axes.ry);
        u[1].left = axes.lx < -0.5f;
        u[1].right = axes.lx > 0.5f;

        if (xtGraphics.fase == 0 && GameSparker.mads[1].loop == 2) {
            u[1].up = axes.ly < -0.5f;
            u[1].down = axes.ly > 0.5f;
        }

//        {
//            final float rx = deadzone(axes.rx);
//
//            Medium.controllerCamAngle = (int) ((rx + 1f) * 360f / 2 - 180f);
//        }
    }

    private static float deadzone(float amt) {
        if (Math.abs(amt) < DEADZONE) {
            amt = 0f;
        }
        return amt;
    }

}
