package jp.ma2dev.network.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Telnet {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Telnet.class);

	private static final String DEFAULT_TERM_TYPE = "vt100";

	private TelnetClient client;

	public Telnet() {
		this(DEFAULT_TERM_TYPE);
	}

	public Telnet(String termtype) {
		client = new TelnetClient(termtype);
	}

	public void connect(InetAddress host, int port, String username, String password, String prompt)
			throws SocketException, IOException {
		client.connect(host, port);

		InputStream istream = client.getInputStream();
		OutputStream ostream = client.getOutputStream();
		Reader reader = new InputStreamReader(istream);
		Writer writer = new OutputStreamWriter(ostream);
		
		// 認証の実行
		readMessage(reader, ".*login: $");
		writer.write(username + "\n");
		writer.flush();
		readMessage(reader, ".*Password: $");
		writer.write(password + "\n");
		writer.flush();

		// プロンプト出力待ち
		readMessage(reader, ".*" + prompt);

		// コマンド実行
		writer.write("ps -aef\n");
		writer.flush();

		// 実行結果取得
		String output = readMessage(reader, "(.*)" + prompt);

		// 実行結果の出力
		//System.out.print(output);

		// ネットワークの切断
		client.disconnect();
	}

	private String readMessage(Reader reader, String message) throws IOException {
		Pattern pattern = Pattern.compile(message, Pattern.DOTALL);
		StringBuffer buffer = new StringBuffer();
		Matcher matcher = null;

		while (true) {
			int c = reader.read();
			if (c < 0) {
				break;
			}
System.out.print((char)c);
			buffer.append((char) c);
			if (reader.ready() == false) {
				matcher = pattern.matcher(buffer.toString());
				if (matcher.matches()) {
					break;
				}
			}
		}

		if (matcher.find(0) && matcher.groupCount() >= 1) {
			return (matcher.group(1));
		}
		return (null);
	}
}
