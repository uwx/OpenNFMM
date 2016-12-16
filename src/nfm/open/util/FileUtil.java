package nfm.open.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import nfm.open.Madness;

public final class FileUtil {
    public static final class Preparable {
        public final String file;
        public final File parent;
        public final int index;

        private Preparable(String s, File f, int i) {
            file=s;
            parent=f;
            index=i;
        }
    }
    
    public static void loadFiles(String folder, String[] files, Consumer<byte[]> reader) throws IOException {
        File f = new File(Madness.fpath + folder);
        for (String s : files) {
            reader.accept(Files.readAllBytes(new File(f, s).toPath()));
        }
    }

    public static void loadFiles(String folder, String[] files, BiFunction<File, String, Path> prepare, Consumer<byte[]> reader) throws IOException {
        File f = new File(Madness.fpath + folder);
        for (String s : files) {
            Path path = prepare.apply(f, s);
            reader.accept(Files.readAllBytes(path));
        }
    }

    public static void loadFiles(String folder, String[] files, BiConsumer<byte[], Integer> reader) throws IOException {
        File f = new File(Madness.fpath + folder);
        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            reader.accept(Files.readAllBytes(new File(f, s).toPath()), i);
        }
    }

    public static void loadFiles(String folder, String[] files, Function<Preparable, Path> prepare, BiConsumer<byte[], Integer> reader) throws IOException {
        File f = new File(Madness.fpath + folder);
        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            Path path = prepare.apply(new Preparable(s, f, i));
            reader.accept(Files.readAllBytes(path), i);
        }
    }
}
