package jp.ma2dev.utils.tail;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import jp.ma2dev.utils.tail.Tail;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TailTest {
	private static final Logger log = LoggerFactory.getLogger(TailTest.class);

	private File file;

	@Before
	public void setUp() throws Exception {
		String filename = "dat/test.txt";
		file = new File(filename);
	}

	@Test
	public final void test() {
		Tail tailf = new Tail(file);

		Thread fileReeadThread = new Thread(tailf);
		fileReeadThread.start();

		try {
			String result = null;
			for (int i = 0; i < 300; i++) {
				byte[] ret = tailf.read();
				if (ret[0] != 0) {
					result = new String(ret);
					System.out.print(result);
					log.debug(result);
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
			tailf.terminate();
		} catch (InterruptedException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
