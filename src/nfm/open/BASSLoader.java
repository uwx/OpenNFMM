package nfm.open;

import java.lang.reflect.Field;

import jouvieje.bass.BassInit;
import jouvieje.bass.exceptions.BassException;
import nfm.open.music.RadicalBASS;

class BASSLoader {

    private static final String os = System.getProperty("os.name").toLowerCase();
    private static final String x64 = System.getProperty("sun.arch.data.model").equals("64") ? "64" : "32";
    private static final boolean isUnix = os.indexOf("nix") == 0 || os.indexOf("nux") == 0;
    private static final boolean isWindows = os.indexOf("win") == 0;
    private static final boolean isMac = os.indexOf("mac") == 0;
    private static final String workingDirectory = ".";

    static void initializeBASS() {
        System.out.println(System.getProperty("java.library.path"));

        try {
            if (isUnix) {
                System.out.println("running on a unix system");
                appendToPath(workingDirectory + "/libraries/dlls/linux" + x64 + "/");
            } else if (isMac) {
                System.out.println("running on a mac system");
                appendToPath(workingDirectory + "/libraries/dlls/mac/");
            } else if (isWindows) {
                System.out.println("running on a windows system");
                appendToPath(workingDirectory + "\\libraries\\dlls\\win" + x64 + "\\");
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ignored) {
        }

        init();
    }

    //private static final String workingDirectory = System.getProperty("user.dir");

    private static void appendToPath(final String s) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        System.setProperty("java.library.path", System.getProperty("java.library.path") + (isWindows ? ";" : ":") + s);

        final Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        fieldSysPath.set(null, null);
    }

    private static void init() {
        /*
         * NativeBass Init
         */
        try {
            BassInit.DEBUG = true;
            BassInit.loadLibraries();
        } catch (final BassException e) {
            printfExit("NativeBass error! %s\n", e.getMessage());
            return;
        }

        /*
         * Checking NativeBass version
         */
        if (BassInit.NATIVEBASS_LIBRARY_VERSION() != BassInit.NATIVEBASS_JAR_VERSION()) {
            printfExit("Error!  NativeBass library version (%08x) is different to jar version (%08x)\n", BassInit.NATIVEBASS_LIBRARY_VERSION(), BassInit.NATIVEBASS_JAR_VERSION());
            return;
        }

        /*==================================================*/

        RadicalBASS.init = true;
    }

    private static void printfExit(final String format, final Object... args) {
        final String s = String.format(format, args);
        System.out.println(s);
    }
}
