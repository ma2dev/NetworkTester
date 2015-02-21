package jp.ma2dev.utils.command.scenario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Message {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Message.class);

	private String message;

	public Message() {

	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
