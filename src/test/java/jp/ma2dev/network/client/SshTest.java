package jp.ma2dev.network.client;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.JSchException;

public class SshTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(SshTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		Ssh ssh = new Ssh();
		try {
			ssh.connect();
		} catch (JSchException e) {
			//  自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			//  自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
