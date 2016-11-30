package jouvieje.bass;

import jouvieje.bass.structures.HMUSIC;
import jouvieje.bass.structures.HSTREAM;
import jouvieje.bass.utils.Pointer;

/**
 * Utility stuff for BASS-ing
 *
 * @author Rafael
 */
public class BassUtils extends Pointer {
    private BassUtils() {
    }

    /**
     * warning might not work use BufferUtils.asPointer(ByteBuffer) instead
     */
    public static HMUSIC BASS_MusicLoad_FromBytes(final boolean mem, final byte[] file, final long offset, final int length, final int flags, final int freq) {
        if (!mem)
            throw new IllegalArgumentException("BASS_MusicLoad_FromBytes was called with mem as false, BASS_MusicLoad should be used instead");

        final long javaResult = BassJNI.Bass_BASS_MusicLoad(mem, file == null ? null : file, offset, length, flags, freq);
        return javaResult == 0 ? null : HMUSIC.asHMUSIC(Pointer.newPointer(javaResult));
    }

    /**
     * same as above though both work, bytebuffer should be used instead
     */
    public static HSTREAM BASS_StreamCreateFile_FromBytes(final boolean mem, final byte[] file, final long offset, final long length, final int flags) {
        if (!mem)
            throw new IllegalArgumentException("BASS_StreamCreateFile_FromBytes was called with mem as false, BASS_StreamCreateFile should be used instead");

        final long javaResult = BassJNI.Bass_BASS_StreamCreateFile(mem, file == null ? null : file, offset, length, flags);
        return javaResult == 0 ? null : HSTREAM.asHSTREAM(Pointer.newPointer(javaResult));
    }

}
