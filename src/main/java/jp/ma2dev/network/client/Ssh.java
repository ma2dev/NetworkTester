package jp.ma2dev.network.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Ssh {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Ssh.class);

	private static final String hostname = "192.168.235.130";
	private static final String userid = "akimitsu";
	private static final String password = "#A10k13i";

	public Ssh() {

	}

	public void connect() throws JSchException, IOException {
		JSch jsch = new JSch();

		// HostKeyチェックを行わない
		Hashtable<String, String> config = new Hashtable<>();
		config.put("StrictHostKeyChecking", "no");
		JSch.setConfig(config);

		// known_hosts を設定して HostKey チェックをおこなう場合
		// String knownhost = "/home/****/.ssh/known_hosts"; // known_hosts
		// ファイルのフルパス
		// jsch.setKnownHosts(knownhost);

		// connect session
		Session session = jsch.getSession(userid, hostname, 22);
		session.setPassword(password);
		session.connect();

		// exec command remotely
		String command = "ls -l";
		ChannelExec channel = (ChannelExec) session.openChannel("exec");
		channel.setCommand(command);
		channel.connect();

		// get stdout
		InputStream in = channel.getInputStream();
		byte[] tmp = new byte[1024];
		while (true) {
			while (in.available() > 0) {
				int i = in.read(tmp, 0, 1024);
				if (i < 0)
					break;
				System.out.print(new String(tmp, 0, i));
			}
			if (channel.isClosed()) {
				System.out.println("exit-status: " + channel.getExitStatus());
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ee) {
			}
		}
		channel.disconnect();
		session.disconnect();

	}
}
