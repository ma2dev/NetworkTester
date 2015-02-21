package jp.ma2dev.utils.tail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * "tail -f"相当の動作を提供する。
 * 
 * @author ma2dev
 * 
 */
public class Tail implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(Tail.class);

	private File file;
	private String mode;

	private byte[] b;

	private boolean terminateFlag;
	private int offset;
	private AtomicLong timeoutMillis;

	private static final int DEFAULT_READ_BUFFER_SIZE = 1024;
	private static final String DEFAULT_MODE_R = "r";
	private static final long DEFAULT_SLEEP_TIME = 100;

	private Object lock;

	public Tail(File file) {
		this(file, DEFAULT_READ_BUFFER_SIZE);
	}

	public Tail(File file, int buffer) {
		if (file == null) {
			throw new NullPointerException("file");
		}
		assert file.exists();
		assert file.isFile();
		this.file = file;

		offset = 0;

		b = new byte[buffer];
		mode = DEFAULT_MODE_R;
		terminateFlag = false;
		timeoutMillis = new AtomicLong();
		setTimeout(DEFAULT_SLEEP_TIME);

		lock = new Object();
	}

	public void setTimeout(long time) {
		timeoutMillis.set(time);
	}

	@Override
	public void run() {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, mode);
			// long pos = 0;
			int readSize = 0;

			while (terminateFlag == false) {

				synchronized (lock) {
					readSize = raf.read(b, offset, b.length - offset - 1);
					if (readSize > 0) {
						offset += readSize;
						// pos += readSize;
						// raf.seek(pos);
					}
				}

				TimeUnit.MILLISECONDS.sleep(timeoutMillis.get());
			}

			raf.close();
		} catch (InterruptedException e) {
			log.error(e.toString());
		} catch (FileNotFoundException e) {
			log.error(e.toString());
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	public byte[] read() {
		byte[] result = null;

		synchronized (lock) {
			result = Arrays.copyOf(b, b.length);
			offset = 0;
			Arrays.fill(b, (byte) 0);
		}

		return result;
	}

	public void terminate() {
		terminateFlag = true;
	}
}
