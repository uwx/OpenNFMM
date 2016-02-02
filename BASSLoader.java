import java.lang.reflect.Field;

import jouvieje.bass.BassInit;
import jouvieje.bass.exceptions.BassException;

public class BASSLoader {

    static void initializeBASS() {
        System.out.println(System.getProperty("java.library.path"));

        try {
            if (Madness.isUnix) {
                System.out.println("running on a unix system");
                appendToPath(Madness.workingDirectory + "/libraries/dlls/linux" + Madness.x64 + "/");
            } else if (Madness.isMac)  {
                System.out.println("running on a mac system");
                appendToPath(Madness.workingDirectory + "/libraries/dlls/mac/");
            } else if (Madness.isWindows) {
                System.out.println("running on a windows system");
                appendToPath(Madness.workingDirectory + "\\libraries\\dlls\\win" + Madness.x64 + "\\");
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
        }

        init();
    }

    //private static final String workingDirectory = System.getProperty("user.dir");

    private static void appendToPath(final String s) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        System.setProperty( "java.library.path", System.getProperty("java.library.path") + (Madness.isWindows ? ";" : ":") + s );

        Field fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
        fieldSysPath.setAccessible( true );
        fieldSysPath.set( null, null );
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

    private static final void printfExit(final String format, final Object... args) {
        String s = String.format(format, args);
        System.out.println(s);
    }
}
