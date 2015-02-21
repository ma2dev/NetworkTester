package jp.ma2dev.network.client;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelnetTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(TelnetTest.class);

	private InetAddress host;
	private String username;
	private int port;
	private String prompt;
	private String password;

	@Before
	public void setUp() throws Exception {
		host = InetAddress.getByName("192.168.235.65");
		username = "akimitsu";
		port = 23;
		prompt = "\\$ $";
		password = "#A10k13i";
	}

	@Test
	public final void test() {
		Telnet telnet = new Telnet();
		
		try {
			telnet.connect(host, port, username, password, prompt);
		} catch (SocketException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
