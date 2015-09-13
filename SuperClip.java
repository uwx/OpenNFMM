
/* SuperClip - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.ByteArrayInputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class SuperClip implements Runnable {
	Thread cliper;
	int skiprate = 0;
	SourceDataLine source = null;
	int stoped = 1;
	ByteArrayInputStream stream;

	public SuperClip(final byte[] is, final int i, final int i_0_) {
		stoped = 2;
		skiprate = i_0_;
		stream = new ByteArrayInputStream(is, 0, i);
	}

	public void close() {
		try {
			stream.close();
			stream = null;
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void play() {
		if (stoped == 2) {
			stoped = 0;
			try {
				stream.reset();
			} catch (final Exception exception) {
				/* empty */
			}
			cliper = new Thread(this);
			cliper.start();
		}
	}

	public void resume() {
		if (stoped == 2) {
			stoped = 0;
			cliper = new Thread(this);
			cliper.start();
		}
	}

	@Override
	public void run() {
		boolean bool = false;
		try {
			final AudioFormat audioformat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, skiprate, 16, 1, 2,
					skiprate, false);
			final DataLine.Info info = new DataLine.Info(null, audioformat);
			source = (SourceDataLine) AudioSystem.getLine(info);
			source.open(audioformat);
			source.start();
		} catch (final Exception exception) {
			stoped = 1;
		}
		while (stoped == 0) {
			try {
				if (source.available() < skiprate || !bool) {
					final byte[] is = new byte[skiprate * 2];
					final int i = stream.read(is, 0, is.length);
					if (i == -1) {
						stream.reset();
						stream.read(is, 0, is.length);
					}
					source.write(is, 0, is.length);
					bool = true;
				}
			} catch (final Exception exception) {
				System.out.println(new StringBuilder().append("Play error: ").append(exception).toString());
				stoped = 1;
			}
			try {
				if (cliper != null) {
					/* empty */
				}
				Thread.sleep(200L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
		source.stop();
		source.close();
		source = null;
		stoped = 2;
	}

	public void stop() {
		if (stoped == 0) {
			stoped = 1;
			if (source != null)
				source.stop();
		}
	}
}
